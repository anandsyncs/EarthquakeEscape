package GUIModule;

import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UnfoldingMap map;
	HashMap<String, Float> lifeExpect=new HashMap<>();
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	
	public void setup(){
		size(800,600,OPENGL);
		map=new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		
		MapUtils.createDefaultEventDispatcher(this,map);
		lifeExpect=loadLifeExpectancyFromCsv("LifeExpectancyWorldBankModule3.csv");
		countries=GeoJSONReader.loadData(this,"countries.geo.json");
		countryMarkers=MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		shadeCountries();
	    map.zoomToLevel(10);

		
	}
	
	public void draw(){
		map.draw();
	}
	
	private void shadeCountries(){
		for(Marker marker:countryMarkers){
			String countryId=marker.getId();
			if(lifeExpect.containsKey(countryId)){
				float lifeExp=lifeExpect.get(countryId);
				int color=(int)map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255-color,100,color));
			}
			else{
				marker.setColor(color(155,155,155));
			}
			
		}
	}
	
	private HashMap<String,Float> loadLifeExpectancyFromCsv(String filename){
		HashMap<String,Float> store=new HashMap<>();
		String[] rows=loadStrings(filename);
		for(String row:rows){
			
			String[] columns=row.split(",");
			if (columns.length == 6 && !columns[5].equals("..")) {
				store.put(columns[4], Float.parseFloat(columns[5]));
			}
				
		}
		return store;
	}

}

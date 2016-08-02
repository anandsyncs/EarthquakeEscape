package GUIModule;

import processing.core.*;

public class imageDisplay extends PApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PImage img;
	public void setup(){
		size(400,400);
		background(255);
		stroke(0);
		img=loadImage("/Users/anand/desktop/work/me.jpg","jpg");
		img.resize(0, height);
		image(img,0,0);
	}
	
	public void draw(){
		int[] color=colorSet(second());
		fill(color[0],color[1],color[2]);
		ellipse(width/4, height/5, width/4, height/5);
		
	}

	public int[] colorSet(int seconds){
		int rgb[] = new int[3];
		float r=Math.abs(30-seconds);
		float ratio=r/30;
		rgb[0]=(int) (255*ratio);
		rgb[1]=(int) (255*ratio);
		rgb[2]=0;
		System.out.println(seconds+" "+ ratio);
		return rgb;
	}
}

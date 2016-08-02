package GUIModule;

import processing.core.PApplet;

public class MyDisplay extends PApplet{

	public void setup(){
	
		size(400,400);
		background(0,0,0);
		
	}
	
	public void draw(){
		fill(255, 0, 0);
		ellipse(200, 200, 400, 400);
		fill(0, 0, 255);
		ellipse(120,120,50,70);
		fill(0, 0, 255);
		ellipse(280,120,50,70);
		
		arc(200,300,100,100,0,PI,OPEN);
		
		
	}
}

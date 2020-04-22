package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet{	
	public ArrayList<Task> tasks = new ArrayList<Task>();
	private float Left;
	private float Margin;
	private int clickLeft = -1;
	private int clickRight = -1;
	int Number=30;

	public void settings(){
		size(800, 600);
	}

	public void loadTasks(){
		Table table = loadTable("tasks.csv", "header");
		for (TableRow row : table.rows()) {
			Task ta = new Task(row);
			tasks.add(ta);
		}
	}

	public void printTasks(){
		for(Task t : tasks){
			println(t);
		}
	} 

	public void displayTasks(){
		float X;
		float Y;
		float textHeight=0.8f;
		float rectHeight=50;
		float rectStart;
		float rectEnd; 
		float rectWidth;
		float color;
		float r=8;

		stroke(255);
		fill(255);
		textAlign(LEFT);

		for(int i=1;i<=Number;i++){
			X=map(i,1,Number,Left,width-Margin);
			line(X,Margin,X,height-Margin);

			text(i,X,Margin*textHeight);
		}

		for(int i=0;i<tasks.size();i++){
			fill(255);
			Y=map(i,0,tasks.size(),2*Margin,height-Margin);
			text(tasks.get(i).getName(),Margin,Y);

			noStroke();
			color=map(i,0,tasks.size(),0,255);
			fill(color,255,255);
			
			rectStart=map(tasks.get(i).getStart(),1,Number,Left,width-Margin);
			rectEnd=map(tasks.get(i).getEnd(),1,Number,Left,width-Margin);
			rectWidth=rectEnd-rectStart;

			rect(rectStart,Y-rectHeight/2,rectWidth,rectHeight,r);
		}
		
	}
	
	public void mousePressed()
	{
		
	}

	public void mouseDragged(){
		
	}
	
	public void setup() {
		Left = width / 6;
		Margin = width / 20;
		loadTasks();
		printTasks();
	}
	
	public void draw(){			
		colorMode(HSB);
		background(0);
		displayTasks();
	}
}

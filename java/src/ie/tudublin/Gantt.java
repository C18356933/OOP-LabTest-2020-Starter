package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	public ArrayList<Task> tasks = new ArrayList<Task>();
	private float Left;
	private float Margin;

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
		for (TableRow row : table.rows()) {
			Task ta = new Task(row);
			tasks.add(ta);
		}
	}

	public void printTasks()
	{
		for(Task t : tasks)
		{
			println(t);
		}
	} 

	public void displayTasks(){
		int Number=30;
		float X;
		float textHeight=0.8f;

		stroke(255);
		fill(255);
		textAlign(LEFT);

		for(int i=1;i<=Number;i++)
		{
			X=map(i,1,Number,Left,width-Margin);
			line(X,Margin,X,height-Margin);

			text(i,X,Margin*textHeight);
		}
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		Left = width / 6;
		Margin = width / 20;
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		colorMode(HSB);
		background(0);
		displayTasks();
	}
}

package ie.tudublin;

import processing.data.TableRow;

public class Task {
    private String Name;
    private int Start;
    private int End;

    public Task(String Name, int Start, int End){
        this.Name = Name;
        this.Start = Start;
        this.End = End;
    }

    public String getName(){
        return Name;
    } 
    
    public int getStart(){
        return Start;
    }
    
    public int getEnd(){
        return End;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setStart(int Start){
        this.Start = Start;
    }

    public void setEnd(int End){
        this.End = End;
    }

    public Task(TableRow tr){
        this(tr.getString("Task"),tr.getInt("Start"),tr.getInt("End"));
    }
}
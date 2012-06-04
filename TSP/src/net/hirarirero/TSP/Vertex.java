package net.hirarirero.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertex extends Point {

	public List<Edge> edges=new ArrayList<Edge>();
	public Integer setID=0;
	public Vertex(int x,int y,int id){
		super(x,y);
		setID=id;
	}
	public String toString(){
		return "["+x+Main.OUTPUT_DELIM+y +Main.OUTPUT_DELIM+setID+Main.OUTPUT_DELIM+edges.size()+"]";
	}
}

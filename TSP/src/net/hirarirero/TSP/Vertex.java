package net.hirarirero.TSP;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Vertex extends Point {

	public int edges=0;
	public int setID=0;
	public Vertex(int x,int y,int id){
		super(x,y);
		setID=id;
	}
	public String toString(){
		return x+" "+y;
	}
}

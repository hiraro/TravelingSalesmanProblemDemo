package net.hirarirero.TSP;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Edge {
	public Set<Integer> pts=new HashSet<Integer>();
	public double distance=0;
	public String toString(){
		return pts.toString()+distance;
	}
}

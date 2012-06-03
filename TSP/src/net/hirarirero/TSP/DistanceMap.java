package net.hirarirero.TSP;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistanceMap {
	private HashMap<Set<Integer>,Double>distanceMap=new HashMap<Set<Integer>, Double>();
	private List<Point>pointList;
	public DistanceMap(List<Point> ls){
		pointList=ls;
		culcDistance();
	}
	public void culcDistance(){
		int size=pointList.size();
		Set<Integer> key;
		Point p0,p1;
		for(int i=0;i<size;i++){
			p0=pointList.get(i);
			for(int j=i;j<size;j++){
				key=new HashSet<Integer>();
				key.add(i);
				key.add(j);
				p1=pointList.get(j);
				distanceMap.put(key, Point.distance(p0.x, p0.y, p1.x, p1.y));
			}
		}
	}
}

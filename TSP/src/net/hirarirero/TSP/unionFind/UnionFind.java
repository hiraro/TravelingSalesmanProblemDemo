package net.hirarirero.TSP.unionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnionFind {
	//protected Map<Integer, ForestElement> forest = new HashMap<Integer, ForestElement>();
	protected Map<Integer, Integer> forest = new HashMap<Integer, Integer>();
	public UnionFind(int n) {
		for (int i = 0; i < n; i++) {
			makeSet(i);
		}
	}

	protected void makeSet(int x) {
//		forest.put(x, new ForestElement(x, 0));
		forest.put(x, x);
	}

	protected void setParent(int x, int parent) {
//		forest.put(x, findElement(parent));
		forest.put(x, parent);
	}

	public int find(int x) {
//		return findElement(x).getParent();
		if (forest.get(x) == x) {
			return x;
		} else {
			return find(forest.get(x));
		}
	}

//	protected ForestElement findElement(int x) {
//		ForestElement fe = forest.get(x);
//		if (fe.getParent() == x) {
//			return fe;
//		} else {
//			return findElement(fe.getParent());
//		}
//	}

//	public void union(int x, int y) {
//		ForestElement rootX = findElement(x);
//		ForestElement rootY = findElement(y);
//		if (rootX.getRank() > rootY.getRank()) {
//			setParent(y, x);
//		} else if (rootX.getRank() < rootY.getRank()) {
//			setParent(x, y);
//		} else if (!rootX.equals(rootY)) {
//			rootX.setRank(rootX.getRank() + 1);
//			setParent(y, x);
//		}
//	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		setParent(rootX, rootY);
	}


	public class ForestElement {
		private int parent;
		private int rank;

		public ForestElement(int parent, int rank) {
			setParent(parent);
			setRank(rank);
		}

		public int getParent() {
			return parent;
		}

		public void setParent(int parent) {
			this.parent = parent;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + parent;
			result = prime * result + rank;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ForestElement other = (ForestElement) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (parent != other.parent)
				return false;
			if (rank != other.rank)
				return false;
			return true;
		}

		private UnionFind getOuterType() {
			return UnionFind.this;
		}
	}
}

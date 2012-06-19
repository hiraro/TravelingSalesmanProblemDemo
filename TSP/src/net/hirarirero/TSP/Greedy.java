package net.hirarirero.TSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.hirarirero.TSP.graph.Util;
import net.hirarirero.TSP.graph.Vertex;

/**
 * 欲張り法アルゴリズム.
 * @author h1231075
 *
 */
public class Greedy {
	private List<Vertex> cycleAsVertex;
	private List<Vertex> input;
	private boolean[] visited;

	/**
	 * コンストラクタ.
	 * @param ls 入力の頂点リスト
	 */
	public Greedy(List<Vertex> ls) {
		input=new ArrayList<Vertex>(ls);
	}

	/**
	 * アルゴリズムの実行.
	 * cycleAsVertexに結果の頂点座標リストを書き込む.
	 */
	public void exec() {
		//巡回済みフラグ配列
		visited=new boolean[input.size()];
		cycleAsVertex = new ArrayList<Vertex>();
		int i = 0;
		//入力の長さ
		int size = input.size();
		//初期値は最初の点
		Vertex v = input.get(0);
		//最初の点から最も近い点を計算
		Vertex vn = findNearest(v);
		//最初の点を巡回済みにする
		visited[v.n]= true;
		//結果リストに追加
		cycleAsVertex.add(v);
		//未巡回の最近頂点が見つからなくなるまでループ
		while (vn != null) {
			//巡回済みフラグの更新
			visited[vn.n]=true;
			//結果リストに追加
			cycleAsVertex.add(vn);
			//vにvnを退避して
			v = vn;
			//vの最近頂点vnを求める
			vn = findNearest(v);
			i++;
			Main.LOGGER.info((double) 100 * i / size + "%");
		}
		//最後に初期値の頂点に戻る
		cycleAsVertex.add(input.get(0));
		Main.LOGGER.info("Done");
	}

	/**
	 * 最近かつ未巡回の頂点を単純に計算.
	 * @param v 最近頂点を求めたい頂点
	 * @return	最近頂点
	 */
	public Vertex findNearest(Vertex v) {
		double min = Double.MAX_VALUE;
		double temp;
		Vertex vi;
		Vertex ret = null;
		for (int i = 0; i < input.size(); i++) {
			if (i != v.n) {
				vi = input.get(i);
				if (!visited[vi.n]) {
					temp = Util.length(vi, v);
					if (min > temp) {
						ret = vi;
						min = temp;
					}
				}
			}
		}
		return ret;
	}

	//結果リストのゲッタ.
	public List<Vertex> getCycle() {
		return cycleAsVertex;
	}

}

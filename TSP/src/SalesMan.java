public class SalesMan{
	double sum_distance = 0; //移動した総距離 
	int[] route = new int[129]; //どの都市を順番に回ってきたかを保存
	int[] note = new int[128]; //どの都市に訪れたかを記憶する

	//巡回セールスマンの最近追加法の実装
	//変数a, bは最短距離が更新された時の都市の場所を確保
	double Check_city_distance(SalesMan sm, CreateCity cc, int n) {
		int a = 0; //jの値を保存
		double min = 10000; //最小距離の初期化
		double distance = 0; //都市同士の距離を計る
		
		if(n != 128) {
			for(int i=0; i < sm.note.length; i++){
				if(sm.note[i] == 1) { //訪れた都市かどうかチェック
					for(int j = 0; j < sm.note.length; j++){	
						if((sm.note[j] == 0) && (i != j)){ //訪れていない都市かチェック
							//各都市との距離を求めていく
							distance = Math.sqrt(( (Math.pow((cc.x[i] - cc.x[j]), 2)) + (Math.pow((cc.y[i] - cc.y[j]), 2))));
							if(min > distance) {
								min = distance;
								a = j;
							}
						}
					}
				}
			}
			sm.note[a] = 1; //何番目の都市を訪れたか記録
			sm.route[n] = a; //次にどの都市に行ったかを記録
			return min;
		} else {
			sm.route[n] = 0;
			distance = Math.sqrt(( (Math.pow((cc.x[0] - cc.x[sm.route[n-1]]), 2)) + (Math.pow((cc.y[0] - cc.y[sm.route[n-1]]), 2))));
			return distance;
		}
	}	
}
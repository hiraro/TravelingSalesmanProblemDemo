//スタートはx[0], y[0]の座標にある都市とする
//最近追加法を用いて求めている
public class Main {
	public static void main(String[] args){
		SalesMan sm = new SalesMan();
		CreateCity cc = new CreateCity();
		
		sm.note[0] = 1; //０番目の要素をスタートとする
		for(int n = 1; n < sm.route.length; n++){
			sm.sum_distance += sm.Check_city_distance(sm, cc, n);
		}
		
		for(int i=0; i < sm.route.length; i++) {
			System.out.println(sm.route[i]);
		}
		System.out.println("-----------------------------");
		for(int i=0; i < sm.note.length; i++) {
			System.out.println(sm.note[i]);
		}
		System.out.println(sm.sum_distance);
	}
}

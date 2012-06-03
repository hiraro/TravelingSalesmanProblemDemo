import java.util.Random;
public class CreateCity {
	int m = 128; //点数を変更する場合はここをいじる
	int n = 4000; //座標の限界値
	//それぞれのx座標, y座標
	int[] x = new int[m];
	int[] y = new int[m];
	
	CreateCity() {
		Random rnd = new Random();
		for(int i=0; i < m; i++) {
			x[i] = rnd.nextInt(n);
			y[i] = rnd.nextInt(n);
		}
	}
}

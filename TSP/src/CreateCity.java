import java.util.Random;
public class CreateCity {
	int m = 128; //�_����ύX����ꍇ�͂�����������
	int n = 4000; //���W�̌��E�l
	//���ꂼ���x���W, y���W
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

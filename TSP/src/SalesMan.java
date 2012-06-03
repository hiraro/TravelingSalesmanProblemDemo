public class SalesMan{
	double sum_distance = 0; //�ړ����������� 
	int[] route = new int[129]; //�ǂ̓s�s�����Ԃɉ���Ă�������ۑ�
	int[] note = new int[128]; //�ǂ̓s�s�ɖK�ꂽ�����L������

	//����Z�[���X�}���̍ŋߒǉ��@�̎���
	//�ϐ�a, b�͍ŒZ�������X�V���ꂽ���̓s�s�̏ꏊ���m��
	double Check_city_distance(SalesMan sm, CreateCity cc, int n) {
		int a = 0; //j�̒l��ۑ�
		double min = 10000; //�ŏ������̏�����
		double distance = 0; //�s�s���m�̋������v��
		
		if(n != 128) {
			for(int i=0; i < sm.note.length; i++){
				if(sm.note[i] == 1) { //�K�ꂽ�s�s���ǂ����`�F�b�N
					for(int j = 0; j < sm.note.length; j++){	
						if((sm.note[j] == 0) && (i != j)){ //�K��Ă��Ȃ��s�s���`�F�b�N
							//�e�s�s�Ƃ̋��������߂Ă���
							distance = Math.sqrt(( (Math.pow((cc.x[i] - cc.x[j]), 2)) + (Math.pow((cc.y[i] - cc.y[j]), 2))));
							if(min > distance) {
								min = distance;
								a = j;
							}
						}
					}
				}
			}
			sm.note[a] = 1; //���Ԗڂ̓s�s��K�ꂽ���L�^
			sm.route[n] = a; //���ɂǂ̓s�s�ɍs���������L�^
			return min;
		} else {
			sm.route[n] = 0;
			distance = Math.sqrt(( (Math.pow((cc.x[0] - cc.x[sm.route[n-1]]), 2)) + (Math.pow((cc.y[0] - cc.y[sm.route[n-1]]), 2))));
			return distance;
		}
	}	
}
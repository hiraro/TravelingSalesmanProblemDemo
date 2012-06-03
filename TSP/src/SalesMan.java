public class SalesMan{
	double sum_distance = 0; //ˆÚ“®‚µ‚½‘‹——£ 
	int[] route = new int[129]; //‚Ç‚Ì“ss‚ğ‡”Ô‚É‰ñ‚Á‚Ä‚«‚½‚©‚ğ•Û‘¶
	int[] note = new int[128]; //‚Ç‚Ì“ss‚É–K‚ê‚½‚©‚ğ‹L‰¯‚·‚é

	//„‰ñƒZ[ƒ‹ƒXƒ}ƒ“‚ÌÅ‹ß’Ç‰Á–@‚ÌÀ‘•
	//•Ï”a, b‚ÍÅ’Z‹——£‚ªXV‚³‚ê‚½‚Ì“ss‚ÌêŠ‚ğŠm•Û
	double Check_city_distance(SalesMan sm, CreateCity cc, int n) {
		int a = 0; //j‚Ì’l‚ğ•Û‘¶
		double min = 10000; //Å¬‹——£‚Ì‰Šú‰»
		double distance = 0; //“ss“¯m‚Ì‹——£‚ğŒv‚é
		
		if(n != 128) {
			for(int i=0; i < sm.note.length; i++){
				if(sm.note[i] == 1) { //–K‚ê‚½“ss‚©‚Ç‚¤‚©ƒ`ƒFƒbƒN
					for(int j = 0; j < sm.note.length; j++){	
						if((sm.note[j] == 0) && (i != j)){ //–K‚ê‚Ä‚¢‚È‚¢“ss‚©ƒ`ƒFƒbƒN
							//Še“ss‚Æ‚Ì‹——£‚ğ‹‚ß‚Ä‚¢‚­
							distance = Math.sqrt(( (Math.pow((cc.x[i] - cc.x[j]), 2)) + (Math.pow((cc.y[i] - cc.y[j]), 2))));
							if(min > distance) {
								min = distance;
								a = j;
							}
						}
					}
				}
			}
			sm.note[a] = 1; //‰½”Ô–Ú‚Ì“ss‚ğ–K‚ê‚½‚©‹L˜^
			sm.route[n] = a; //Ÿ‚É‚Ç‚Ì“ss‚És‚Á‚½‚©‚ğ‹L˜^
			return min;
		} else {
			sm.route[n] = 0;
			distance = Math.sqrt(( (Math.pow((cc.x[0] - cc.x[sm.route[n-1]]), 2)) + (Math.pow((cc.y[0] - cc.y[sm.route[n-1]]), 2))));
			return distance;
		}
	}	
}
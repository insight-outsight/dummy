package javalanguage;


public class ContinueBreakReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(int k=0;k<4;k++){
			for(int i=0;i<3;i++){
				if(i==1){
					continue;//break;return
				}
				for(int j=0;j<5;j++){
					System.out.println(k+",,,"+i+"--"+j);
				}
			}	
		}
	

	}

}

package javalanguage.控制流程;

public class ContinueBreakLabel {

	public static void main(String[] args) {
		System.out.println("begin");
        bq:
        for (int i=0;i<3;i++) {
            for (int j=0;j<4;j++) {
                if (i==1)
                    break bq;
/*                if (j==2)
                    continue bq;*/
                System.out.println(i+","+j);
            }
            
        }
		System.out.println("end");
	}

}

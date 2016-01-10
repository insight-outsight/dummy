package javalanguage.对象的克隆;

public class 数组的克隆 {

    public static void main(String[] aret){
    	Ax[] ewr = new Ax[3];
    	ewr[0] = new Ax("y11");
    	ewr[1] = new Ax("atom");
    	ewr[2] = new Ax("atomic");
    	Ax[] cd = ewr.clone();
    	for(int i=0;i<cd.length;i++){
    		System.out.println(cd[i]);
    	}
    	ewr[2]=new Ax("violent");;
    	for(int i=0;i<cd.length;i++){
    		System.out.println(cd[i]);
    	}
    }
    
    public static class Ax{
    	
    	public Ax(){
    		
    	}
    	
    	public Ax(String name){
    		this.name = name;
    	}
    	
    	String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
    	
		public String toString(){
			return "name="+this.name;
		}
		
    }
    
}

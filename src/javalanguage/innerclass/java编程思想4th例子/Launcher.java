package javalanguage.innerclass.java编程思想4th例子;


public class Launcher {

	public static void main(String[] args) {
		
//		Parcel1.Contents c = new Parcel1.Contents();
		Parcel1 parcel1 = new Parcel1();
		Parcel1.Contents contents = parcel1.new Contents();
		System.out.println(contents.value());
		Parcel1.Scenario s = new Parcel1.Scenario();
		
	    Parcel2 p = new Parcel2();
	    p.ship("Tasmania");
	    Parcel2 q = new Parcel2();
	    // Defining references to inner classes:
	    Parcel2.Contents c = q.contents();
	    
	    Parcel2.Destination d = q.to("Borneo");
	    
	}

}

package commons.pojo;

public class Puma {

	public Puma(){
		System.out.println("puma开始时间"+System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("puma结束时间"+System.currentTimeMillis());
	}
}

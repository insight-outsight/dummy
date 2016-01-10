package commons.pojo;

public class CellPhone extends Phone {

	private int screenWidth;
	private int screenHeight;
	private boolean isSmart;
	
	
	public CellPhone() {
		super();
	}
	public CellPhone(String brandName) {
		super(brandName);
	}
	public int getScreenWidth() {
		return screenWidth;
	}
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
	public int getScreenHeight() {
		return screenHeight;
	}
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	public boolean isSmart() {
		return isSmart;
	}
	public void setSmart(boolean isSmart) {
		this.isSmart = isSmart;
	}
	
	
}

package javalanguage.generic.example;

public abstract class HtcCameraAbstractImpl implements HtcCameraInterface {

	private HtcCellPhoneModel model;
	
	@Override
	public void doPhoto() {
		doPhoto(model);
	}

	public abstract void doPhoto(HtcCellPhoneModel model);
}

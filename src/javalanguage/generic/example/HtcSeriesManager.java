package javalanguage.generic.example;

import java.util.List;


public abstract class HtcSeriesManager<SCREEN,CAMERA extends HtcCameraAbstractImpl> 
			implements CellPhoneSeriesManager<HtcCellPhoneSerial,HtcCellPhoneModel>{
	
	@Override
	public List<HtcCellPhoneModel> listAllModel(HtcCellPhoneSerial Series) {
		return generate();
	}
	
	public abstract List<HtcCellPhoneModel> generate();
	
	public abstract void descScreen(SCREEN Screen);
	
	abstract CAMERA returnCamera();


}

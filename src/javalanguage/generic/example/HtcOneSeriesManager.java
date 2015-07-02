package javalanguage.generic.example;

import java.util.ArrayList;
import java.util.List;


public class HtcOneSeriesManager
			extends HtcSeriesManager<HtcScreen,HtcCameraAbstractImpl>{

	@Override
	public List<HtcCellPhoneModel> generate() {
		List<HtcCellPhoneModel> modelList = new ArrayList<HtcCellPhoneModel>();
		return modelList;
	}

	@Override
	public void descScreen(HtcScreen Screen) {
		
	}

	@Override
	HtcCameraAbstractImpl returnCamera() {
		return null;
	}
	



}

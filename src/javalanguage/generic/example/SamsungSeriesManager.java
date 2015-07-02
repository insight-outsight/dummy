package javalanguage.generic.example;

import java.util.List;


public abstract class SamsungSeriesManager<CPU> 
			implements CellPhoneSeriesManager<SamsungCellPhoneSerial,SamsungPhoneModel>{
	
	@Override
	public List<SamsungPhoneModel> listAllModel(SamsungCellPhoneSerial Series) {
		return generate();
	}
	
	public abstract List<SamsungPhoneModel> generate();
	
	abstract void show(CPU cpu);


}

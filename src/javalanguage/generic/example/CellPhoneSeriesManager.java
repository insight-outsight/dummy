package javalanguage.generic.example;

import java.util.List;

public abstract interface CellPhoneSeriesManager<SERIES,BASE_MODEL> {
	
	abstract List<BASE_MODEL> listAllModel(SERIES Series);
	
}

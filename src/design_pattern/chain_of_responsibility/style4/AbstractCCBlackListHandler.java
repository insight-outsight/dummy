package design_pattern.chain_of_responsibility.style4;

import java.util.ArrayList;
import java.util.List;



public abstract class AbstractCCBlackListHandler<ArgBean> extends AbstractHandler<ArgBean>{


	private final static List<String> defaultIgnoreHanlderNameList = new ArrayList<String>(0);

	@Override
	protected final boolean canHandle(boolean defaultValue) {
		
		try {
			List<String> ignoreHanlderNameList = defaultIgnoreHanlderNameList;
//					ConfigCenterAssistant.getConfigStringListSilently("/aa/b-c3", ",", defaultIgnoreHanlderNameList, true);
					
			System.out.println("now ignoreHanlderNameList="+ignoreHanlderNameList);
            
			if(ignoreHanlderNameList.contains(this.getClass().getSimpleName())) {
				return false;
			}
			else {
				return true;
			}
		}catch(Throwable t) {
				System.out.println("canHandle() execute Error");
				t.printStackTrace();
				return defaultValue;
		}
		
	}
	
}

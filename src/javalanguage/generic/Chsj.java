package javalanguage.generic;

import java.util.List;

public abstract class Chsj<FX,L extends Lgj> extends Sj<FX>{

	abstract L returnCh();
		
	@Override
	public List<FX> listObjects(){
		return generate();
	}
	
	public abstract List<FX> generate();
	
	public abstract void jia(List<L> je);
	
}

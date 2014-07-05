package design_pattern.decorator;

public class MilkDecorator extends Decorator{
	
    private Beverage mBeverage; 
    
    public MilkDecorator(Beverage mBeverage) { 
        super(); 
        this.mBeverage = mBeverage; 
    } 
 
    @Override 
    public String getDescription() { 
        return mBeverage.getDescription() + " , milk"; 
    } 
 
    @Override 
    public double cost() { 
        return mBeverage.cost() + 1;   //加牛奶一元 
    } 
    
}
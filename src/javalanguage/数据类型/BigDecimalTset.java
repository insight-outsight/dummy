package javalanguage.数据类型;

import java.math.BigDecimal;

public class BigDecimalTset {

	public static void main(String[] args) {
		
		BigDecimal b = new BigDecimal(9.655503);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        System.out.println("f1=" + f1);//f1=9.66
        double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("f2=" + f2);//f1=9.66
        double f3 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("f3=" + f3);//f1=9.656
        double f4 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("f4=" + f4);//f1=9.656
        
        BigDecimal mData = new BigDecimal("9.655").setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("mData=" + mData);//mData=9.66
        
		float totalAmount=376.99999f;
		float vat = totalAmount*10000*8/1000000;
		System.out.println("u_---"+vat);
		
		float r1 = Float.parseFloat("7.012");
		System.out.println("r1="+r1);
		
		float r2 = Float.parseFloat("17.9090");
		System.out.println("r2="+r2);
		
		float r3=2.99f;
		float r4=0.08f;
		System.out.println("---"+(r3*100)*(r4*100)/10000);
		System.out.println("-------"+r3*100*r4/100);
		System.out.println("binggo-"+
				new BigDecimal(r3*r4).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());

	}

}

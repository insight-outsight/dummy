package javalanguage.threads.待整理;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class K4 {

	class Inner {
		private Object mutex = new Object();
		private void m4t1() {
			synchronized (mutex){
				int i = 5;
				while (i-- > 0) {
					System.out.println(Thread.currentThread().getName()
							+ " : Inner.m4t1()=" + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException ie) {
					}
				}
			}
		}

		private void m4t2() {
			synchronized (mutex){
				int i = 5;
				while (i-- > 0) {
					System.out.println(Thread.currentThread().getName()
							+ " : Inner.m4t2()=" + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException ie) {
					}
				}
			}
		}
	}

	private void m4t1(Inner inner) {
		//synchronized (inner) {
			inner.m4t1();
			System.out.println("m4t1执行完毕");
		//}
	}

	private void m4t2(Inner inner) {
		inner.m4t2();
	}

	public static void main(String[] args) {
		final K4 kkkk = new K4();
		final Inner inner = kkkk.new Inner();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				kkkk.m4t1(inner);
			}
		}, "relinquish");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				kkkk.m4t2(inner);
			}
		}, "eliminate");
		
		t1.start();
		t2.start();
	}

	/*
	 * public static void main(String[] args) { Cer cer = new Cer();
	 * cer.setCode(777); cer.setExplain("qiqiqiqqqqq"); Candidate c = new
	 * Candidate(); c.setCer(cer);
	 * System.out.println("old-->"+c.getCer().getCode
	 * ()+"="+c.getCer().getExplain()); Cer gCer222 = new Cer();
	 * gCer222.setCode(212124444); gCer222.setExplain("s333issiiisisis");
	 * c.setCer(gCer222);
	 * //System.out.println(gCer.getCode()+"="+gCer.getExplain());
	 * System.out.println
	 * ("new-->"+c.getCer().getCode()+"="+c.getCer().getExplain());
	 * 
	 * String[] cont = new String[3]; cont[0] = "gongheguo"; cont[1] =
	 * "qunimadefuerdai"; cont[2] = "eeeeeeeeeequnimadefuerdai"; c.setS(cont);
	 * //櫾少 ByteArrayOutputStream byteOut = null; try {
	 * System.out.println("--------serializable--------"); byteOut = new
	 * ByteArrayOutputStream(); ObjectOutputStream out = new
	 * ObjectOutputStream(byteOut); out.writeObject(c); byteOut.flush();
	 * byteOut.close();
	 * 
	 * System.out.println(c);
	 * 
	 * System.out.println("--------serializable end--------"); } catch
	 * (Exception e) { System.out.println("序列化出错"); e.printStackTrace(); } //櫾少
	 * for(String s :c.getS()){ System.out.println(s); } cont[0] = "haha拜拜";
	 * cont[1] = "wuwubb"; cont[2] = "hehe88"; for(String s :c.getS()){
	 * System.out.println(s); } try {
	 * System.out.println("-------- de serializable--------");
	 * ByteArrayInputStream byteIn = new
	 * ByteArrayInputStream(byteOut.toByteArray()); ObjectInputStream in = new
	 * ObjectInputStream(byteIn); Candidate c2 = (Candidate) in.readObject();
	 * 
	 * System.out.println(c2);
	 * 
	 * System.out.println("--------de serializable end--------"); } catch
	 * (Exception e) { System.out.println("反序列化出错"); e.printStackTrace(); } Zhu
	 * zzz = new Zhu(); System.out.println(zzz.cer.getCode());
	 * System.out.println(zzz.cer.getExplain()); zzz.cer.setExplain("最终可变类");
	 * System.out.println(zzz.cer.getCode());
	 * System.out.println(zzz.cer.getExplain()); long[] ll = new long[2]; ll[0]
	 * = 18; ll[1] = 333; //ll[2] = 789000; byte[] bbb = new byte[3]; bbb[0] =
	 * 127; Map m = new HashMap(); m.put("l1", ll); m.put("b2", bbb); if
	 * (m.get("l1") instanceof Collection) { System.out.println("克来新"); } else
	 * if (m.get("b2") instanceof byte[]) { System.out.println("买铺");
	 * System.out.println(((byte[])m.get("b2"))[0]);
	 * System.out.println(((byte[])m.get("b2"))[1]);
	 * System.out.println(((byte[])m.get("b2"))[2]); } else if (m.get("l1")
	 * instanceof long[]) { System.out.println("长数组");
	 * System.out.println(((long[])m.get("l1"))[0]);
	 * System.out.println(((long[])m.get("l1"))[1]); } else {
	 * System.out.println("wrong"); } }
	 */
}

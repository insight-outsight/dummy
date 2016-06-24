package javalanguage.directMemory;  
  
import java.util.ArrayList;  
import java.util.Deque;  
import java.util.LinkedList;  
import java.util.List;  
  
/** 
 * 
 * @author Vicky.H 
 * @email eclipser@163.com 
 */  
public class FIFOTest {  
  
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        FIFO<A> fifo = new FIFOImpl<A>(5);  
        for (int i = 0; i < 20; i++) {  
            A a = new A("A:" + i);  
            A head = fifo.addLastSafe(a);  
            System.out.println(i + "\thead:" + head + "\tsize:" + fifo.size());  
        }  
  
        System.out.println("---------------");  
  
        System.out.println("弹出数据");  
        List<A> polls = fifo.setMaxSize(3);  
        for (A a : polls) {  
            System.out.println("\thead:" + a);  
        }  
          
        System.out.println("剩余数据");  
        for (A a : fifo) {  
            System.out.println("\thead:" + a);  
        }  
        System.out.println(fifo.size());  
    }  
}  
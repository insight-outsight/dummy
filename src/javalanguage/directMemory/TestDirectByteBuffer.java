package javalanguage.directMemory;
import java.nio.ByteBuffer;  
  
public class TestDirectByteBuffer  
{  
    //-verbose:gc -Xloggc:C:/Users/u0007/Desktop/jvm_gc.log -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+DisableExplicitGC -XX:MaxDirectMemorySize=40M

    public static void main(String[] args) throws Exception  {  

        while (true) {
        	Object obj = new Object();
            ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);  
        }
        
    }  
}  
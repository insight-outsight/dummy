package javalanguage.service_loader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Launcher {
    
    public static void main(String[] args) {
        System.out.println("now run");
        try{
        ServiceLoader<Aab> loadedDrivers = ServiceLoader.load(Aab.class);
        Iterator<Aab> driversIterator = loadedDrivers.iterator();
//        System.out.println(driversIterator.hasNext());
        while(driversIterator.hasNext()) {
            Aab aabImpl = driversIterator.next();
            aabImpl.setName("slld2");
            System.out.println(aabImpl.getName());
        }
        } catch(Throwable t) {
            t.printStackTrace();
        }
    }

}

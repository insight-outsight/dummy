package javalanguage.util.cocurrent.locks;

import java.util.Random;

/**
 * Created by MOMO on 16/8/29.
 */
public class RaceTset  {

    public static void main(String[] args) {

        final Racer1 racer1 = new Racer1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) try {
                    racer1.exec();
                    Thread.currentThread().sleep(new Random().nextInt(10)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        final Racer2 racer2 = new Racer2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) try {
                    racer2.exec();
                    Thread.currentThread().sleep(new Random().nextInt(10)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }



}

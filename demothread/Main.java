package demothread;

public class Main {
    public static void main(String[] args) {
        DemoNumber d = new DemoNumber();

        new Thread(()->{
           for (int i=0;i<20;i++){
               //synchronized (d){
                   d.upValue();
                   d.frint();
             //  }
               try {
                   Thread.sleep(1000);
               }catch (Exception e){}
           }
        }).start();

        new Thread(()->{
            for (int i=0;i<20;i++){
              // synchronized (d){
                   d.upValue();
                   d.frint();
              // }
                try {
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
        }).start();
    }

    public static void main3(String[] args) {
        Subthread1 s = new Subthread1();
        s.setDaemon(true);
        SubRunNable r = new SubRunNable();
        Thread t = new Thread(r);
        //t.setDaemon(true);
        s.start();
        try{
            s.join();
        }
        catch (Exception e){}
        t.start();
    }
    public static void main2(String[] args) {

        // thread
        Subthread1 st1 = new Subthread1();
        st1.start();
        // subrunnable
        SubRunNable r = new SubRunNable();
        Thread t = new Thread(r);
        t.start();
        // lop an danh
        Runnable r2 = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread t2 = new Thread(r2);
        t2.start();

        new Thread(()->{

        }).start();
        for(int i = 0; i<20;i++){
            System.out.println("main i =" +i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}

        }
        System.out.println("Main done");
    }
}

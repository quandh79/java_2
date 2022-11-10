package demothread;

public class SubRunNable implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i<20;i++){
            System.out.println("SubRunNable i =" +i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
        System.out.println("SubRunNable done");

    }
}


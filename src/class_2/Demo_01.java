package class_2;

public class Demo_01 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Demo_01 class thread run");
            }
        }).start();
    }

}

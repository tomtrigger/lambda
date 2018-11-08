package class_2;

/**
 * 匿名内部类仍然是一个类，只是不需要程序员显示指定类名，编译器会自动为该类取名。
 * 因此如果有如下形式的代码，编译之后将会产生两个class文件。
 */
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

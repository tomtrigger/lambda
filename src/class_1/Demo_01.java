package class_1;

public class Demo_01 {

    public static void main(String[] args) {
        // JDK1.7之前匿名函数的写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).start();

        // JDK1.8之后使用Lambda格式的写法
        // 1.1 单行代码
        new Thread(
                () -> System.out.println("Hello Lambda")
        ).start();

        // 1.2 多行代码
        new Thread(
                () -> {
                    System.out.println("This is Lambda");
                    System.out.println("It's convenience");
                }
        ).start();

    }
}

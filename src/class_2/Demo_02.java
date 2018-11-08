package class_2;

/**
 * Lambda表达式通过invokedynamic指令实现，书写Lambda表达式不会产生新的类。
 * 如果有如下代码，编译之后不会产生新的类。
 * 通过反编译（javap -c -p class文件）可以看出Lambda表达式被封装为主类的一个私有方法，并通过invokedynamic指令调用。
 */
public class Demo_02 {

    public static void main(String[] args) {
        new Thread(
                () -> System.out.println("Lambda thread is run")
        ).start();
    }

}

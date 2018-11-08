package class_2;

/**
 * 既然Lambda表达式不是内部类的简写，那么Lambda内部的this引用也就与内部类对象没什么关系了。
 * 在Lambda中this的意义跟表达式外部完全一样。
 * 因此下面代码将会输出两遍“hello hxl”，而不是两个引用地址。
 */
public class Demo_03 {

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    public void test_01() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(toString());
            }
        }).start();
    }

    public String toString() {
        return "hello hxl";
    }

    public static void main(String[] args) {
        new Demo_03().r1.run();
        new Demo_03().r2.run();
        new Demo_03().test_01();
    }

}

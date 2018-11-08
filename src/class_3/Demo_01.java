package class_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * forEach()该方法的签名为void forEach(Consumer<? super E> action)，作用是对容器中的每个元素执行action指定的动作。
 * 其中Consumer是个函数接口，里面只有一个待实现方法void accept(T t)
 * （后面我们会看到，这个方法叫什么根本不重要，你甚至不需要记忆它的名字）
 */
public class Demo_01 {

    // JDK1.7 增强for循环遍历数据
    public static void test_01() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        for (String str : list) {
            if (str.length() > 3)
                System.out.println(str);
        }
    }

    // JDK1.8 使用forEach()结合匿名内部类迭代
    public static void test_02() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() > 3)
                    System.out.println(s);
            }
        });
    }

    // JDK1.8 使用forEach()结合Lambda表达式迭代
    public static void test_03() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.forEach(str -> {
            if (str.length() > 3)
                System.out.println(str);
        });
    }

    public static void main(String[] args) {
        test_01();
        test_02();
        test_03();
    }

}

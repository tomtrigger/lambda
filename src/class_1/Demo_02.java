package class_1;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * 使用Lambda有两个依据：
 * 1.必须有相应的函数接口（函数接口，是指内部只有一个抽象方法的接口）
 * 2.类型推断机制
 */
public class Demo_02 {

    // JDK1.7匿名内部类写法
    public static void test_1() {
        List<String> list = Arrays.asList("I", "love", "you", "too");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);
    }

    // JDK1.8 Lambda写法
    public static void test_2() {
        List<String> list = Arrays.asList("I", "love", "you", "too");
        Collections.sort(list, (s1, s2) -> { // 省略参数表的类型
            if (s1 == null) {
                return -1;
            }
            if (s2 == null) {
                return 1;
            }
            return s1.length() - s2.length();
        });
        System.out.println(list);
    }

    // Lambda不同形式的写法
    public static void test_3() {
        Runnable runnable = () -> System.out.println("hello lambda");  // 无参函数的简写

        ActionListener listener = event -> System.out.println("hello world"); // 有参函数的简写

        Runnable multiLine = () -> { // 代码块
            System.out.println("hello");
            System.out.println("hi");
        };

        BinaryOperator<Long> add = (Long x, Long y) -> x - y; // 类型推断机制

        BinaryOperator<Long> addImplicit = (x, y) -> x + y; // 类型推断机制
    }

    public static void main(String[] args) {
        test_1();
        test_2();
    }

}

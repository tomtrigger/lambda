package class_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.UnaryOperator;

/**
 * replaceAll()
 * 该方法签名为void replaceAll(UnaryOperator<E> operator)，作用是对每个元素执行operator指定的操作，并用操作结果来替换原来的元素。
 * 其中UnaryOperator是一个函数接口，里面只有一个待实现函数T apply(T t)。
 */
public class Demo_03 {

    // 使用下标实现元素替换
    public static void test_01() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("i", "love", "you", "too"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 3) {
                String str = list.get(i).toUpperCase();
                list.set(i, str);
            }
        }
        System.out.println(list);
    }

    // 使用匿名内部类实现
    public static void test_02() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("i", "love", "you", "too"));
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.length() > 3)
                    return s.toUpperCase();
                return s;
            }
        });
        System.out.println(list);
    }

    public static void test_03() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("i", "love", "you", "too"));
        list.replaceAll(s -> {
            if(s.length() > 3)
                return s.toUpperCase();
            return s;
        });
        System.out.println(list);
    }

    public static void main(String[] args) {
        test_01();
        test_02();
        test_03();
    }

}

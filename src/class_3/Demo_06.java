package class_3;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * forEach()
 * 该方法签名为void forEach(BiConsumer<? super K,? super V> action)，作用是对Map中的每个映射执行action指定的操作，
 * 其中BiConsumer是一个函数接口，里面有一个待实现方法void accept(T t, U u)。
 * BinConsumer接口名字和accept()方法名字都不重要，请不要记忆他们。
 */
public class Demo_06 {

    // JDK7之前迭代Map
    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        for (Map.Entry<Integer, String> set : map.entrySet()) {
            System.out.println(set.getKey() + "->" + set.getValue());
        }
    }

    // JDK8使用匿名类迭代Map
    public static void test_02() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer + "->" + s);
            }
        });
    }

    // JDK8使用Lambda表达式迭代
    public static void test_03() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.forEach((key, value) -> System.out.println(key + "->" + value));
    }

    public static void main(String[] args) {
        test_01();
        test_02();
        test_03();
    }

}

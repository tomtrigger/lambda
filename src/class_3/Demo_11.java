package class_3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * replaceAll()
 *
 * 该方法签名为replaceAll(BiFunction<? super K,? super V,? extends V> function)，作用是对Map中的每个映射执行function指定的操作，
 * 并用function的执行结果替换原来的value，其中BiFunction是一个函数接口，里面有一个待实现方法R apply(T t, U u)．
 */
public class Demo_11 {

    //  JDK7之前将Map中的value全部替换为大写
    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);
    }

    // JDK8结合匿名类实现
    public static void test_02() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.replaceAll(new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) {
                return s.toUpperCase();
            }
        });
        System.out.println(map);
    }

    public static void test_03() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.replaceAll((i, s) -> s.toUpperCase());
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
        test_02();
        test_03();
    }

}

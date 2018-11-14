package class_3;

import java.util.HashMap;
import java.util.Map;

/**
 * putIfAbsent()
 *
 * 该方法跟Lambda表达式没关系，但是很有用。方法签名为V putIfAbsent(K key, V value)，作用是只有在不存在key值的映射或映射值为null时，
 * 才将value指定的值放入到Map中，否则不对Map做更改．该方法将条件判断和赋值合二为一，使用起来更加方便．
 */
public class Demo_08 {

    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, null);
        System.out.println(map);
        map.putIfAbsent(3, "three");
        map.putIfAbsent(1, "four");
        map.putIfAbsent(5, "five");
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
    }

}

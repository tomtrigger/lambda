package class_3;

import java.util.HashMap;
import java.util.Map;

/**
 * merge()
 *
 * 该方法签名为merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)，作用是：
 *
 *     如果Map中key对应的映射不存在或者为null，则将value（不能是null）关联到key上；
 *     否则执行remappingFunction，如果执行结果非null则用该结果跟key关联，否则在Map中删除key的映射．
 */
public class Demo_12 {

    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.merge(4, "four", (k, v) -> "four");
        System.out.println(map);
        map.merge(4, "four", (k, v) -> "四");
        System.out.println(map);
        map.merge(4, "si", (k, v) -> null);
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
    }

}

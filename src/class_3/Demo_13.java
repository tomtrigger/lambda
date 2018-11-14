package class_3;

import java.util.HashMap;
import java.util.Map;

/**
 * compute()
 *
 * 该方法签名为compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)，
 * 作用是把remappingFunction的计算结果关联到key上，如果计算结果为null，则在Map中删除key的映射．
 */
public class Demo_13 {

    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.compute(4, (k, v) -> k + v);
        System.out.println(map);
        map.compute(4, (k, v) -> null);
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
    }

}

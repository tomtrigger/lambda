package class_3;

import java.util.HashMap;
import java.util.Map;

/**
 * computeIfPresent()
 *
 * 该方法签名为V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)，作用跟computeIfAbsent()相反，
 * 即，只有在当前Map中存在key值的映射且非null时，才调用remappingFunction，
 * 如果remappingFunction执行结果为null，则删除key的映射，否则使用该结果替换key原来的映射．
 */
public class Demo_15 {

    public static void test_01() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "一");
        map.computeIfPresent("1", (k, v) -> k + v);
        System.out.println(map);
        map.computeIfPresent("2", (k, v) -> k);
        System.out.println(map);
        map.computeIfPresent("1", (k, v) -> null);
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
    }

}

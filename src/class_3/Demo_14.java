package class_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *computeIfAbsent()
 *
 * 该方法签名为V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)，
 * 作用是：只有在当前Map中不存在key值的映射或映射值为null时，才调用mappingFunction，并在mappingFunction执行结果非null时，将结果跟key关联．
 *
 * Function是一个函数接口，里面有一个待实现方法R apply(T t)．
 */
public class Demo_14 {

    public static void test_01() {
        Map<String, Set<String>> map = new HashMap<>();
        map.put("1", new HashSet<>());
        map.get("1").add("一");
        map.computeIfAbsent("hello", v -> new HashSet<String>()).add("world");
        System.out.println(map);
        // 没有执行才调用mappingFunction方法，但依然返回key对应的value
        map.computeIfAbsent("1", v -> new HashSet<>()).add("yi");
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
    }

}

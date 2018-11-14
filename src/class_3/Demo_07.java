package class_3;

import java.util.HashMap;
import java.util.Map;

/**
 * getOrDefault()
 * 该方法跟Lambda表达式没关系，但是很有用。方法签名为V getOrDefault(Object key, V defaultValue)，作用是按照给定的key查询Map中对应的value，
 * 如果没有找到则返回defaultValue。使用该方法程序员可以省去查询指定键值是否存在的麻烦．
 */
public class Demo_07 {

    // JDK7之前查询Map中是否有对应的键
    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        if (map.containsKey(4)) {
            System.out.println(map.get(4));
        } else {
            System.out.println("No Value");
        }
    }

    // JDK8查询Map中是否有对应的键
    public static void test_02() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map.getOrDefault(3, "No Value"));
        System.out.println(map.getOrDefault(4, "No Value"));
    }

    public static void main(String[] args) {
        test_01();
        test_02();
    }

}

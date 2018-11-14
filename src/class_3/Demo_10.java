package class_3;

import java.util.HashMap;
import java.util.Map;

/**
 * replace()
 * 在Java7及以前，要想替换Map中的映射关系可通过put(K key, V value)方法实现，该方法总是会用新值替换原来的值．
 * 为了更精确的控制替换行为，Java8在Map中加入了两个replace()方法，分别如下：
 *   1.replace(K key, V value)，只有在当前Map中key的映射存在时才用value去替换原来的值，否则什么也不做．
 *   2.replace(K key, V oldValue, V newValue)，只有在当前Map中key的映射存在且等于oldValue时才用newValue去替换原来的值，否则什么也不做．
 */
public class Demo_10 {

    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map);
        map.replace(1, "1");
        map.replace(4, "four");
        System.out.println(map);
    }

    public static void test_02() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.replace(1, "1", "一");
        System.out.println(map);
        map.replace(1, "one", "yi");
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
        test_02();
    }

}

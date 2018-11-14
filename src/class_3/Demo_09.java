package class_3;

import java.util.HashMap;
import java.util.Map;

/**
 * remove()
 *
 * 我们都知道Map中有一个remove(Object key)方法，来根据指定key值删除Map中的映射关系；
 * Java8新增了remove(Object key, Object value)方法，只有在当前Map中key正好映射到value时才删除该映射，否则什么也不做．
 */
public class Demo_09 {

    public static void test_01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map);
        map.remove(1, "two");
        System.out.println(map);
        map.remove(1, "one");
        System.out.println(map);
    }

    public static void main(String[] args) {
        test_01();
    }

}

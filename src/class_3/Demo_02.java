package class_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * removeIf()
 * 该方法签名是boolean removeIf(Predicate<? super E> filter)，作用是删除容器中所有满足filter指定条件的元素，
 * 其中Predicate是一个函数接口，里面只有一个待实现方法boolean test(T t)，同样的这个方法的名字根本不重要，因为用的时候不需要书写这个名字。
 */
public class Demo_02 {

    // 使用迭代器删除列表元素
    public static void test_01() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() > 3)
                iterator.remove();
        }
        System.out.println(list);
    }

    // 使用removeIf()结合匿名内部类实现
    public static void test_02() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });
        System.out.println(list);
    }

    // 使用removeIf()结合Lambda表达式实现
    public static void test_03() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(str -> str.length() > 3);
        System.out.println(list);
    }

    public static void main(String[] args) {
        test_01();
        test_02();
        test_03();
    }

}

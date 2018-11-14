package class_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * sort()
 * 该方法定义在List接口中，方法签名为void sort(Comparator<? super E> c)，该方法根据c指定的比较规则对容器元素进行排序。
 * Comparator接口我们并不陌生，其中有一个方法int compare(T o1, T o2)需要实现，显然该接口是个函数接口
 */
public class Demo_04 {

    // Collections.sort() 方法
    public static void test_01() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);
    }


    // 使用匿名内部类实现
    public static void test_02() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);
    }

    // 使用Lambda表达式
    public static void test_03() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.sort((str1, str2) -> str1.length() - str2.length());
        System.out.println(list);
    }

    public static void main(String[] args) {
        test_01();
        test_02();
        test_03();
    }
}

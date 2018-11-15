package class_4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream 常用的方法
 */
public class Demo_01 {

    // forEach()
    public static void test_01() {
        Stream<String> i = Stream.of("I", "love", "you", "too");
        i.forEach(str -> System.out.println(str));
    }

    // filter()
    public static void test_02() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.filter(str -> str.length() == 3).forEach(str -> System.out.println(str));
    }

    // distinct()
    public static void test_03() {
        Stream<String> stream = Stream.of("I", "love", "you", "too", "too");
        stream.distinct().forEach(str -> System.out.println(str));
    }

    // sorted()
    public static void test_04() {
        Stream<String> i = Stream.of("I", "love", "you", "too");
        i.sorted((str1, str2) -> str1.compareTo(str2)).forEach(str -> System.out.println(str));
    }

    // map()
    public static void test_05() {
        Stream<String> i = Stream.of("I", "love", "you", "too");
        i.map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));
    }

    // flatMap()
    public static void test_06() {
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        listStream.flatMap(list -> list.stream()).forEach(integer -> System.out.println(integer));
    }

    public static void main(String[] args) {
        test_01();
        test_02();
        test_03();
        test_04();
        test_05();
        test_06();
    }

}

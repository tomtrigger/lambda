package class_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo_03 {

    // 将Stream转化为容器或Map
    public static void test_01() {
        Stream<String> i = Stream.of("I", "love", "you", "too");
        // List<String> list = i.collect(Collectors.toList());
        //Set<String> set = i.collect(Collectors.toSet());
        Map<String, Integer> map = i.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
    }

    // 将stream转化为容器
    public static void test_02() {
        Stream<String> i = Stream.of("I", "love", "you", "too");
        //ArrayList<Object> list = i.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<String> list = i.collect(Collectors.toList());
        System.out.println(list);
    }

    // 将stream转化为list或set
    public static void test_03() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        //List<String> list = stream.collect(Collectors.toList());
        //System.out.println(list);
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
    }

    //  将stream转化为指定容器的list或者set
    public static void test_04() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        //ArrayList<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
        //System.out.println(list);
        HashSet<String> set = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
    }

    public static void main(String[] args) {
        /*test_01();
        test_02();*/
        //test_03();
        test_04();
    }

}

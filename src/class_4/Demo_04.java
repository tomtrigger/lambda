package class_4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用collect()生成Map
 *
 * 前面已经说过Stream背后依赖于某种数据源，数据源可以是数组、容器等，但不能是Map。反过来从Stream生成Map是可以的，
 * 但我们要想清楚Map的key和value分别代表什么，根本原因是我们要想清楚要干什么。通常在三种情况下collect()的结果会是Map：
 *
 *     使用Collectors.toMap()生成的收集器，用户需要指定如何生成Map的key和value。
 *     使用Collectors.partitioningBy()生成的收集器，对元素进行二分区操作时用到。
 *     使用Collectors.groupingBy()生成的收集器，对元素做group操作时用到。
 */
public class Demo_04 {

    // 使用toMap()统计字符串的长度
    public static void test_01() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<String, Integer> collect = stream.collect(Collectors.toMap(Function.identity(), str -> str.length()));
        System.out.println(collect);
    }

    // 使用partitioningBy()生成的收集器，这种情况适用于将Stream中的元素依据某个二值逻辑（满足条件，或不满足）
    // 分成互补相交的两部分，比如男女性别、成绩及格与否等。
    public static void test_02() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<Boolean, List<String>> collect = stream.collect(Collectors.partitioningBy(str -> str.length() >= 3));
        System.out.println(collect);
    }

    // 使用groupingBy()生成的收集器，这是比较灵活的一种情况。跟SQL中的group by语句类似，
    // 这里的groupingBy()也是按照某个属性对数据进行分组，属性相同的元素会被对应到Map的同一个key上
    public static void test_03() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<Integer, List<String>> collect = stream.collect(Collectors.groupingBy(String::length));
        System.out.println(collect);
    }

    // 增强版的groupingBy()允许我们对元素分组之后再执行某种运算，比如求和、计数、平均值、类型转换等。
    // 这种先将元素分组的收集器叫做上游收集器，之后执行其他运算的收集器叫做下游收集器(downstream Collector)。
    public static void test_04() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<Integer, Long> collect = stream.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collect);
    }

    // 下游收集器还可以包含更下游的收集器
    public static void test_05() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<Integer, List<String>> collect = stream.collect(Collectors.groupingBy(String::length, Collectors.mapping(str -> str.toUpperCase(), Collectors.toList())));
        System.out.println(collect);

    }

    // 使用collect()做字符串join
    public static void test_06() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        // String collect = stream.collect(Collectors.joining());
        // String collect = stream.collect(Collectors.joining(","));
        String collect = stream.collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect);
    }

    public static void main(String[] args) {
        test_06();
    }

}

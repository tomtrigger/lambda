package class_4;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 规约操作（reduction operation）又被称作折叠操作（fold），是通过某个连接动作将所有元素汇总成一个汇总结果的过程。
 * 元素求和、求最大值或最小值、求出元素总个数、将所有元素转换成一个列表或集合，都属于规约操作。
 * Stream类库有两个通用的规约操作reduce()和collect()，也有一些为简化书写而设计的专用规约操作，比如sum()、max()、min()、count()等
 */
public class Demo_02 {

    /**
     * reduce操作可以实现从一组元素中生成一个值，sum()、max()、min()、count()等都是reduce操作，将他们单独设为函数只是因为常用。
     * reduce()的方法定义有三种重写形式：
     *     Optional<T> reduce(BinaryOperator<T> accumulator)
     *     T reduce(T identity, BinaryOperator<T> accumulator)
     *     <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
     *
     * 虽然函数定义越来越长，但语义不曾改变，多的参数只是为了指明初始值（参数identity），
     * 或者是指定并行执行时多个部分结果的合并方式（参数combiner）。reduce()最常用的场景就是从一堆值中生成一个值。
     */
    // 从一组单词中找出最长的单词。这里“大”的含义就是“长”。
    public static void test_01() {
        Stream<String> i = Stream.of("I", "love", "you", "too");
        Optional<String> optional = i.reduce((str1, str2) -> str1.length() >= str2.length() ? str1 : str2);
        // Optional<String> max = i.max((str1, str2) -> str1.length() - str2.length());
        System.out.println(optional.get());
    }

    // 求出一组单词的长度之和。这是个“求和”操作，操作对象输入类型是String，而结果类型是Integer。
    public static void test_02() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Integer reduce = stream.reduce(0, // 初始值
                (sum, str) -> sum + str.length(), // 累加器
                (a, b) -> a + b); // 部分和拼接器，并行执行时才会用到
        // int sum = stream.mapToInt(str -> str.length()).sum();
        System.out.println(reduce);
    }

    public static void main(String[] args) {
        test_01();
        test_02();
    }

}

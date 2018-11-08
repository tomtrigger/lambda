package class_1;

import java.util.Arrays;
import java.util.List;

public class Demo_03 {

    public static void test_1(String string) {
        ConsumerInterface<String> consumer = str -> System.out.println(str);
        consumer.accpt(string);
    }

    private static class MyStream<T> {
        private List<T> list;

        public MyStream(List<T> list) {
            this.list = list;
        }

        public void myForEach(ConsumerInterface<T> consumer) {
            for (T t: list) {
                consumer.accpt(t);
            }
        }
    }

    public static void test_2() {
        List<String> list = Arrays.asList("I", "love", "you", "too");
        MyStream<String> myStream = new MyStream<>(list);
        myStream.myForEach(str -> System.out.println(str)); // 使用自定义函数接口书写Lambda表达式
    }

    public static void main(String[] args) {
        test_1("hello");
        test_2();
    }

}

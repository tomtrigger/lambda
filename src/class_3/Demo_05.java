package class_3;

import java.util.*;

/**
 * spliterator()
 *
 * 方法签名为Spliterator<E> spliterator()，该方法返回容器的可拆分迭代器。从名字来看该方法跟iterator()方法有点像，
 * 我们知道Iterator是用来迭代容器的，Spliterator也有类似作用，但二者有如下不同：
 *
 *     1.Spliterator既可以像Iterator那样逐个迭代，也可以批量迭代。批量迭代可以降低迭代的开销。
 *     2.Spliterator是可拆分的，一个Spliterator可以通过调用Spliterator<T> trySplit()方法来尝试分成两个。
 *       一个是this，另一个是新返回的那个，这两个迭代器代表的元素没有重叠。
 *
 * 可通过（多次）调用Spliterator.trySplit()方法来分解负载，以便多线程处理。
 */
public class Demo_05 {

    // 顺序遍历
    public static void test_01() {
        List<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // 并行遍历
    public static void test_02() {
        List<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Spliterator<String> spliterator_1 = list.spliterator();
        Spliterator<String> spliterator_2 = spliterator_1.trySplit();
        Spliterator<String> spliterator_3 = spliterator_1.trySplit();
        //Spliterator<String> spliterator_4 = spliterator_1.trySplit();
        spliterator_1.forEachRemaining((str) -> System.out.println("1 -> " + str));
        spliterator_2.forEachRemaining((str) -> System.out.println("2 -> " + str));
        spliterator_3.forEachRemaining((str) -> System.out.println("3 -> " + str));
        //spliterator_4.forEachRemaining((str) -> System.out.println("4 -> " + str));
    }

    public static void main(String[] args) {
        test_01();
        test_02();
    }

}

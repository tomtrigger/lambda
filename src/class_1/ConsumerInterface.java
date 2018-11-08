package class_1;

@FunctionalInterface // 可选的，但加上该标注编译器会帮你检查接口是否符合函数接口规范
public interface ConsumerInterface<T> {

    void accpt(T t);

}

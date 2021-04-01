package com.software.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class TestClass {
    public static void main(String[] args) {
        String[] array = {"aaaa", "bbbb", "cccc"};
         List<String> list = Arrays.asList(array);
         list.forEach(ClassB::accept);



        //        Function<T, R> T 作为输入，返回的 R 作为输出
        //        Predicate<T> T 作为输入 ，返回 boolean 值的输出
        //        Consumer<T> T 作为输入 ，没有输出
        //        Supplier<R> 没有输入 , R 作为输出
        //        BinaryOperator<T> 两个 T 作为输入 ，T 同样是输出
        //        UnaryOperator<T> 是 Function 的变种 ，输入输出者是 T

        // hello world 示例
        Function<String,String> function = (x) -> {return x+"Function";};
        System.out.println(function.apply("hello world"));  // hello world Function
        UnaryOperator<String> unaryOperator = x -> x + 2;
        System.out.println(unaryOperator.apply("9420-"));   // 9420-2
        // 判断输入值是否为偶数示例
        Predicate<Integer> predicate = (x) ->{return x % 2 == 0 ;};
        System.out.println(predicate.test(1));              // false

        // 这个没有返回值
        Consumer<String> consumer = (x) -> {System.out.println(x);};
        consumer.accept("hello world ");                    // hello world

        // 这个没有输入
        Supplier<String> supplier = () -> {return "Supplier";};
        System.out.println(supplier.get());                 // Supplier

        // 找出大数
        BinaryOperator<Integer> bina = (x, y) ->{return x > y ? x : y;};
        System.out.println( bina.apply(1,2));
    }

    interface  ClassA{
        void accept(String str);
    }
    static class  ClassB{
        public static void accept(String str) {
            System.out.println(str);
        }
        public  static  void hello() {
            System.out.println("hello");
        }

    }

    public static  void TestCar(){
        final Car car = Car.create( Car::new );
       // 等价于 Car car = Car.create(() -> new Car());
        //第二种方法引用的类型是静态方法引用，语法是Class::static_method。注意：这个方法接受一个Car类型的参数。
        List<Car> cars=new ArrayList<>();
        cars.add(car);

        cars.forEach( Car::collide );
       // forEach 原型为 forEach(Consumer<? super T> action) 使用的是 Consumer 只有参数，没有返回值；这个参数 T 就是 car 类型，因为是 cars.forEach 嘛，所以上面的方法引用等价于

       // cars.forEach(car -> Car.collide(car));
       // 第三种方法引用的类型是某个类的成员方法的引用，语法是Class::method，注意，这个方法没有定义入参：

        cars.forEach( Car::repair2 );
        //它等价于
        //cars.forEach(x -> x.repair());
    }

    public static class Car {
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }

        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }

        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }

        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }

        public   void repair2() {
            System.out.println( "Repaired " + this.toString() );
        }
    }
}

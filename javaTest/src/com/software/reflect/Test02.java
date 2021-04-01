package com.software.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<? extends Number> upperToNumber = new ArrayList<>();
        List<? super Integer> downToInteger = new ArrayList<>();


        Integer integer = 1;
        Number number = new Double(2.0d);
        integerList.add(integer);

        // <? super Integer>中的?表示Integer的某个父类型。
        // 凡是Integer的变量，一定是<? extends Integer>类型
        downToInteger.add(integer);
        // 一个<? extends Integer>类型，并不总能表示为Integer，所以下一行代码无法编译
        //Integer i = downToInteger.get(0);
        // 一个<? extends Integer>类型总能表示为Object
        Object o = downToInteger.get(0);


        // integer继承自number，符合<? extends Number>的定义，所以可以直接这样赋值
        upperToNumber = integerList;
        // Integer只是<? extends Number>的一种可能，所以下一行代码无法编译
        //upperToNumber.add(integer);
        // null可以是任意类型，一定是<? extends Number>
        upperToNumber.add(null);
        //<? extends Number> 类型一定可以表示为Number
        Number n = upperToNumber.get(0);


        //泛型函数使用类型上边界来定义
        try {
            Method addMethod = integerList.getClass().getMethod("add", Object.class);
            addMethod.invoke(integerList, "StringValue");
            // 运行期List<T>的类型变量范围只有上边界Object
            for (Object value: integerList){
                System.out.println(value);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

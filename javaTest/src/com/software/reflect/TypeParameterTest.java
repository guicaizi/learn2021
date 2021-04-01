package com.software.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeParameterTest  {
    public static void main(String[] args) throws NoSuchMethodException {
           Type as=TypeParameterTest.class.getMethod("getList").getGenericReturnType();
           if(as instanceof ParameterizedType){
               ParameterizedType ptype = (ParameterizedType)as;
               //得到参数化类型中的实际类型参数
               Type[] types = ptype.getActualTypeArguments();
               //取出第一个
               Class domainClass = (Class)types[0];
               //获取domainClass的类名
               String resultType = domainClass.getName();
               System.out.println(types[0]);
               System.out.println(types[1]);

           }




    }
    public static Map<String, Integer> getList()
    {
        return new HashMap<>();
    }

}

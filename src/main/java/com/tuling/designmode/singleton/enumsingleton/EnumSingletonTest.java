package com.tuling.designmode.singleton.enumsingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author zhangChen
 * @Date 2022/9/12 17:11
 */
//单例模式-枚举类
public enum EnumSingletonTest {
    INSTANCE;

    public void print(){
        System.out.println(this.hashCode());
    }
}

class EnumTest{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*EnumSingletonTest instance = EnumSingletonTest.INSTANCE;
        EnumSingletonTest instance1 = EnumSingletonTest.INSTANCE;
        System.out.println(instance1==instance);*/
        Constructor<EnumSingletonTest> declaredConstructor = EnumSingletonTest.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingletonTest instance = declaredConstructor.newInstance("INSTANCE", 0);
    }
}

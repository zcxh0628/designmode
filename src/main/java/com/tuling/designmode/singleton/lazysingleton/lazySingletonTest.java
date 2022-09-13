package com.tuling.designmode.singleton.lazysingleton;

/**
 * @Author zhangChen
 * @Date 2022/9/12 15:39
 */
//单例模式-单例模式
public class lazySingletonTest {
    public static void main(String[] args) {
        /*LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instancel = LazySingleton.getInstance();
        System.out.println(instance==instancel);*/
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}
//懒汉模式
class LazySingleton {
    //私有的静态属性
    private volatile static LazySingleton instance;

    //私有的构造函数，避免外部对应实例创建
    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            /*try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //解决并发情况下可能创建多个实例
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

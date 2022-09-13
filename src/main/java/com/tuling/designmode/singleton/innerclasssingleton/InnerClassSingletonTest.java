package com.tuling.designmode.singleton.innerclasssingleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author zhangChen
 * @Date 2022/9/12 16:33
 */
//单例模式-静态内部类
public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
//        InnerClassSingLeton instance = InnerClassSingLeton.getInstance();
//        InnerClassSingLeton instances = InnerClassSingLeton.getInstance();
//        System.out.println(instance==instances);
       /* new Thread(()->{
            InnerClassSingLeton instance = InnerClassSingLeton.getInstance();
            System.out.println(instance);
        }).start();
        new Thread(()->{
            InnerClassSingLeton instance = InnerClassSingLeton.getInstance();
            System.out.println(instance);
        }).start();*/
        /*Constructor<InnerClassSingLeton> declaredAnnotations = InnerClassSingLeton.class.getDeclaredConstructor();
        declaredAnnotations.setAccessible(true);
        InnerClassSingLeton innerClassSingLeton = declaredAnnotations.newInstance();
        InnerClassSingLeton instance = InnerClassSingLeton.getInstance();
        System.out.println(instance==innerClassSingLeton);*/

        InnerClassSingLeton instance = InnerClassSingLeton.getInstance();

        /*ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("testSerializable"));
        oos.writeObject(instance);
        oos.close();*/

        ObjectInputStream ois =new ObjectInputStream(new FileInputStream("testSerializable"));
        InnerClassSingLeton object = ((InnerClassSingLeton) ois.readObject());
        System.out.println(instance==object);

    }
}

//静态内部类
class InnerClassSingLeton implements Serializable {
    static final long serialVersionUID = 42L;
    private static class InnerClassHolder {
        private static InnerClassSingLeton instance = new InnerClassSingLeton();
    }

    private InnerClassSingLeton() {
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单列不允许多个实例");
        }
    }

    public static InnerClassSingLeton getInstance() {
        return InnerClassHolder.instance;
    }

    Object writeReplace() throws ObjectStreamException{
        return InnerClassHolder.instance;
    }

    float aa = 0.0f;
}

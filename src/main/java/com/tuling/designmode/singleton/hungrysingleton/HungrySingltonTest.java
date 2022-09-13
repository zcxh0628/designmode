package com.tuling.designmode.singleton.hungrysingleton;

/**
 * @Author zhangChen
 * @Date 2022/9/12 16:23
 */
//单例模式-饿汉模式
public class HungrySingltonTest {
    public static void main(String[] args) {
        HungrySinglton instance = HungrySinglton.getInstance();
        HungrySinglton instances = HungrySinglton.getInstance();
        System.out.println(instances==instances);
    }
}

//饿汉模式
class HungrySinglton {
    private static HungrySinglton instance = new HungrySinglton();

    private HungrySinglton() {

    }

    public static HungrySinglton getInstance() {
        return instance;
    }
}

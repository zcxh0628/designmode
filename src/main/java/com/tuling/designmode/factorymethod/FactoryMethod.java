package com.tuling.designmode.factorymethod;

/**
 * @Author zhangChen
 * @Date 2022/9/12 20:42
 */
//工厂方法模式
public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new ConCreateProductA();
        Product product = application.getObject();
        product.method1();
    }
}

interface Product {
    public void method1();
}


class ProductA implements Product {
    public void method1() {
        System.out.println("ProductA.methodl executed.");
    }
}

class ProductB implements Product {
    public void method1() {
        System.out.println("ProductB.methodl executed.");
    }
}

class SimpleFactory {
    public static Product createProduct(String type) {
        if (type.equals("0")) {
            return new ProductA();
        } else if (type.equals("1")) {
            return new ProductB();
        }else {
            return null;
        }
    }
}

abstract class Application {
    abstract Product createPrduct();

    Product getObject() {
        Product product = createPrduct();
        return product;
    }
}

class ConCreateProductA extends Application{

    @Override
    Product createPrduct() {
        return new ProductA();
    }
}
class ConCreateProductB extends Application{

    @Override
    Product createPrduct() {
        return new ProductB();
    }
}
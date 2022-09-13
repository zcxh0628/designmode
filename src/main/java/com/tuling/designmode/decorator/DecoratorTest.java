package com.tuling.designmode.decorator;

/**
 * @Author zhangChen
 * @Date 2022/9/12 23:08
 */
//装饰者模式
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConreteDecoratorl2(new ConreteDecoratorl(new ConcreteComponent()));
        component.operation();
    }
}

interface Component {
    void operation();
}

class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

abstract class Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConreteDecoratorl extends Decorator {

    public ConreteDecoratorl(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        component.operation();
    }
}

class ConreteDecoratorl2 extends Decorator {
    public ConreteDecoratorl2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        component.operation();
    }
}

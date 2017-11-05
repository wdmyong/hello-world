package com.exper;

/**
 * Created by wdmyong on 2017/11/1.
 */
public class Test {

    public static void main(String[] args) {
        Data data = new Data();
        // 调用的是父类的，接口BaseInterface的被抽象类覆盖了
        // 居然没注意，犯了这个SB错
        // 因为 Data()是实现了抽象类，以下都是调用com.exper.BaseAbstract.getData()
        System.out.println(data.getData());
        data.setData("ok");
        System.out.println(data.getData());

        BaseAbstract baseAbstract = new Data();
        System.out.println(baseAbstract.getData());
        baseAbstract.setData("ok1");
        System.out.println(baseAbstract.getData());

        BaseInterface baseInterface = new Data();
        // 这里出现了问题的原因是，我当时直接点击了getData()方法
        // 就进入了com.exper.BaseInterface.getData()
        System.out.println(baseInterface.getData());
        if (baseInterface instanceof BaseAbstract) {
            ((BaseAbstract)baseInterface).setData("ok2");
        }
        System.out.println(baseInterface.getData());

        // 直接实现BaseInterface
        OnlyInterface onlyInterface = new OnlyInterface();
        System.out.println(onlyInterface.getData());
        onlyInterface.setData("only");
        System.out.println(onlyInterface.getData());

        BaseInterface bInterface = new OnlyInterface();
        System.out.println(onlyInterface.getData());
        if (bInterface instanceof OnlyInterface) {
            ((OnlyInterface)bInterface).setData("only1");
        }
        System.out.println(onlyInterface.getData());
    }
}
/*
** 输出如下：
BaseAbstract getData
null
BaseAbstract getData
ok
BaseAbstract getData
null
BaseAbstract getData
ok1
BaseAbstract getData
null
BaseAbstract getData
ok2
BaseInterface getData
default
BaseInterface getData
default
BaseInterface getData
default
BaseInterface getData
default
**
 */
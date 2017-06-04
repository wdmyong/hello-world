package jdk8;

public class InterfaceClass implements InterfaceTest {

    public double cal() {
        return add(1, 20);
    }

    public static void main(String[] args) {
        InterfaceTest test = new InterfaceClass();
        System.out.println(test.add(1, 2));
        System.out.println(test.cal());
    }
}

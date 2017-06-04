package jdk8;

public interface InterfaceTest {

    default double add(double a, double b) {
        return a + b;
    }

    double cal();
}

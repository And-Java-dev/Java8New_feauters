package defaultAndStaticMethods;

@FunctionalInterface
public interface Interface {
    void method2();

    default void log(String str) {
        System.out.println("I2 logging::" + str);
    }
}

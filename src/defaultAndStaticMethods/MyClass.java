package defaultAndStaticMethods;

public class MyClass implements Interface, Interface1 {

    @Override
    public void method2() {

    }
    //MyClass won't compile without having it's own log() implementation
    @Override
    public void log(String str) {
        System.out.println("MyClass logging::" + str);
        Interface1.print("abc");
    }

    @Override
    public void method1(String str) {

    }
}

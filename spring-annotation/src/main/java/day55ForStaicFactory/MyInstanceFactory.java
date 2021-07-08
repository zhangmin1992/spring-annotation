package day55ForStaicFactory;

public class MyInstanceFactory {
    public static Person getCar() {
        return new Person("zhangmin",21);
    }
}

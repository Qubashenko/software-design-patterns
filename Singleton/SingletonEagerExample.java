package Singleton;

/*
Singleton.SingletonLazyExample - always creates an instance of the object, even if it's not necessary
 */
public class SingletonEagerExample {
    private static  Integer invoke = 0;
    private static final SingletonEagerExample INSTANCE = new SingletonEagerExample();

    // In case of changing access to pubic and invoke of a constructor,
    // it will create new instance of the class and
    // brake singleton
    private SingletonEagerExample(){
        this.invoke++;
    };

    public Integer getInvoke(){
        return this.invoke;
    }

    public static SingletonEagerExample getInstance(){
        return INSTANCE;
    }

}

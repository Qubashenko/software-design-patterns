package Singleton;

/*
Singleton.SingletonThreadSafeExample - eager example with getInstance() class synchronized will make it impossible for one thread
    to access the method if another thread hasn’t finished with its execution
 */
public class SingletonThreadSafeExample {
    private static  Integer invoke = 0;
    private static final SingletonThreadSafeExample INSTANCE = new SingletonThreadSafeExample();

    // In case of changing access to pubic and invoke of a constructor,
    // it will create new instance of the class and
    // brake singleton
    private SingletonThreadSafeExample(){
        this.invoke++;
    };

    public Integer getInvoke(){
        return this.invoke;
    }

    public static synchronized SingletonThreadSafeExample getInstance(){
        return INSTANCE;
    }

}

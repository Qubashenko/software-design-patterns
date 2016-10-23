package Singleton;

/*
Singleton.SingletonLazyExample - prevents creation of the instance untill it is requested for the first time
 */
public class SingletonLazyExample {
    private static Integer invoke = 0;
    private static SingletonLazyExample instance = null;

    private SingletonLazyExample(){
        invoke++;
    }

    public Integer getInvoke(){
        return this.invoke;
    }

    public static SingletonLazyExample getInstance(){
        if(instance == null){
            instance = new SingletonLazyExample();
        }
        return instance;
    }
}



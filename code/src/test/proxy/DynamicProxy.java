package test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Dyakira on 2016/5/27.
 */
public class DynamicProxy implements InvocationHandler {
    private Object obj;

    public DynamicProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do before");
        Object result = method.invoke(obj, args);
        System.out.println("do after");
        return obj;
    }
}

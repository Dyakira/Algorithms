package test.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Dyakira on 2016/5/27.
 */
public class ProxyTest {
    public static void main(String[] args) {
        DynamicProxy inter = new DynamicProxy(new Vendor());
        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(),new Class[]{Sell.class} , inter));
        sell.sell();
    }
}

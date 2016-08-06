package test.proxy;

/**
 * Created by Dyakira on 2016/5/27.
 */
public class Vendor implements Sell {
    @Override
    public void ad() {
        System.out.println("ad method");
    }

    @Override
    public void sell() {
        System.out.println("sell method");
    }
}

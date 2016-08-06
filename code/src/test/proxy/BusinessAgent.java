package test.proxy;

/**
 * Created by Dyakira on 2016/5/27.
 */
public class BusinessAgent implements Sell {
    private Vendor mVendor;

    public BusinessAgent (Vendor vendor){
        mVendor = vendor;
    }

    @Override
    public void ad() {
        mVendor.sell();
    }

    @Override
    public void sell() {
        mVendor.ad();
    }
}

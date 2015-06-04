package jp.ac.it_college.std.s14002.pdp.factory.idcard;

import jp.ac.it_college.std.s14002.pdp.factory.framework.Factory;
import jp.ac.it_college.std.s14002.pdp.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s14002 on 15/06/04.
 */
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List getOwners() {
        return owners;
    }
}

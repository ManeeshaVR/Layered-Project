package bo.custom;

import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.ItemBoImpl;
import bo.custom.impl.PurchaseOrderBoImpl;
import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BoTypes{
        CUSTOMER, ITEM, PURCHASE
    }

    public SuperBO getBo(BOFactory.BoTypes types){
        switch (types){
            case CUSTOMER:return new CustomerBoImpl();
            case ITEM:return new ItemBoImpl();
            case PURCHASE:return new PurchaseOrderBoImpl();
            default:return null;
        }
    }
}

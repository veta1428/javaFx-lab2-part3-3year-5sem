package mapper;

import java.util.HashMap;
import java.util.Map;

import types.TripType;
import vouchers.CruiseVoucher;
import vouchers.ExcursionVoucher;
import vouchers.RestVoucher;
import vouchers.ShoppingVoucher;
import vouchers.TreatmentVoucher;

/**
 * Is a mapper table between type of Voucher derived class and TripType enum values
 */
public class TripTypeMapper {
    
    /** 
     * @return Map<Class, TripType>
     */
    public static Map<Class, TripType> getMapperTable() {
        Map<Class, TripType> map = new HashMap<Class, TripType>();

        map.put(RestVoucher.class, TripType.Rest);
        map.put(CruiseVoucher.class, TripType.Cruise);
        map.put(ExcursionVoucher.class, TripType.Excursion);
        map.put(ShoppingVoucher.class, TripType.Shopping);
        map.put(TreatmentVoucher.class, TripType.Treatment);

        return map;
    }
}

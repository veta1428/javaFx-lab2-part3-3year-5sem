package vouchers;

import types.TripType;

public class RestVoucher extends Voucher{
    
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "This is Rest Voucher\n" + super.toString();
    }

    @Override
    public TripType getType() {
        return TripType.Rest;
    }
}

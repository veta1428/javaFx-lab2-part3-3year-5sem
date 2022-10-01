package vouchers;

import types.TripType;

public class ShoppingVoucher extends Voucher{
     /** 
     * @return String
     */
    @Override
    public String toString() {
        return "This is Shopping Voucher\n" + super.toString();
    }

    @Override
    public TripType getType() {
        return TripType.Shopping;
    }
}

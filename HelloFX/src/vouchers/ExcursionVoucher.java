package vouchers;

import types.TripType;

public class ExcursionVoucher extends Voucher{
     /** 
     * @return String
     */
    @Override
    public String toString() {
        return "This is Excursion Voucher\n" + super.toString();
    }

    @Override
    public TripType getType() {
        return TripType.Excursion;
    }
}

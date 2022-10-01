package vouchers;

import types.TripType;

public class CruiseVoucher extends Voucher{
     /** 
     * @return String
     */
    @Override
    public String toString() {
        return "This is Cruise Voucher\n" + super.toString();
    }

    @Override
    public TripType getType() {
        return TripType.Cruise;
    }
}

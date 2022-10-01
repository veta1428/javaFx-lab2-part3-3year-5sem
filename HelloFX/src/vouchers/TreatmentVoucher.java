package vouchers;

import types.TripType;

public class TreatmentVoucher extends Voucher{
     /** 
     * @return String
     */
    @Override
    public String toString() {
        return "This is Treatment Voucher\n" + super.toString();
    }

    @Override
    public TripType getType() {
        return TripType.Treatment;
    }
}

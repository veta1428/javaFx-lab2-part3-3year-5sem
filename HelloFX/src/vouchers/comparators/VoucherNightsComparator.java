package vouchers.comparators;

import java.util.Comparator;

import vouchers.Voucher;

public class VoucherNightsComparator implements Comparator<Voucher>{

    
    /** 
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Voucher o1, Voucher o2) {
        if (o1.getNights() < o2.getNights()){
            return -1;
        } else if (o1.getNights() > o2.getNights()){
            return 1;
        } else {
            return 0;
        }
    }
}

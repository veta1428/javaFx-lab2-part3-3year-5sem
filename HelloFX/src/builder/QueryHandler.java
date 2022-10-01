package builder;

import java.util.ArrayList;
import java.util.stream.Collectors;

import types.SortType;
import vouchers.Voucher;
import vouchers.comparators.VoucherNightsComparator;
import vouchers.comparators.VoucherPriceComparator;

// command pattern
public class QueryHandler {
    
    /** 
     * @param unfilteredVouchers
     * @param query
     * @return ArrayList<Voucher>
     */
    public static ArrayList<Voucher> perform(ArrayList<Voucher> unfilteredVouchers, Query query) {
        ArrayList<Voucher> filtered = new ArrayList<Voucher>();

        filtered = (ArrayList<Voucher>) unfilteredVouchers
            .stream()
            .filter(query.getPredicate())
            .collect(Collectors.toList());

        if(query.getSortType() == SortType.SortByNights) {
            VoucherNightsComparator cmp = new VoucherNightsComparator();
            filtered.sort(cmp);
        }

        if(query.getSortType() == SortType.SortByPrice) {
            VoucherPriceComparator cmp = new VoucherPriceComparator();
            filtered.sort(cmp);
        }

        return filtered;
    }
}

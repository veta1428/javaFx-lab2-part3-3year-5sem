package context;

import java.util.ArrayList;

import dataseeder.DataSeeder;
import vouchers.Voucher;

// facade for working with DB / in-memory / file system
public class DataContext {
    private static DataContext _context;
    public ArrayList<Voucher> vouchers;

    private DataContext(){
        vouchers = DataSeeder.GetVouchers();
    }

    
    /** 
     * @return DataContext
     */
    public static DataContext getDataContext() {
        if (_context == null) {
            return new DataContext();
        } else {
            return _context;
        }
    }
}

package builder;

import java.util.function.Predicate;

import types.SortType;
import vouchers.Voucher;

/**
 * 
 */
public class Query {
    private Predicate<Voucher> predicate;
    private SortType sortType;

    
    /** 
     * @return QueryBuilder
     */
    public static QueryBuilder createQueryBuilder(){
        return new QueryBuilder();
    }

    
    /** 
     * @param predicate
     */
    // setters

    public void setPredicate(Predicate<Voucher> predicate){
        this.predicate = predicate;
    }

    
    /** 
     * @param sortType
     */
    public void setSortType(SortType sortType){
        this.sortType = sortType;
    }


    
    /** 
     * @return Predicate<Voucher>
     */
    // getters

    public Predicate<Voucher> getPredicate() {
        return this.predicate;
    }

    
    /** 
     * @return SortType
     */
    public SortType getSortType(){
        return this.sortType;
    }
}

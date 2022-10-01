package builder;

import java.util.function.Predicate;

import types.SortType;
import vouchers.Voucher;

/**
 * QueryBuilder is designed to build query to perform on data set
 */
public class QueryBuilder {
    private Query query;

    public QueryBuilder(){
        query = new Query();
    }

    
    /** 
     * @param predicate
     * @return QueryBuilder
     */
    public QueryBuilder setPredicate(Predicate<Voucher> predicate) {
        query.setPredicate(predicate);
        return this;
    }

    
    /** 
     * @param sortType
     * @return QueryBuilder
     */
    public QueryBuilder setSortType(SortType sortType) {
        query.setSortType(sortType);
        return this;
    }

    
    /** 
     * @return Query
     */
    public Query build(){
        return query;
    }
}

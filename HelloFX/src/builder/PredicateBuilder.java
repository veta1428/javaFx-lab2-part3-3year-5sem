package builder;

import java.util.function.Predicate;

import mapper.TripTypeMapper;
import types.Food;
import types.Transport;
import types.TripType;
import vouchers.Voucher;

/**
 * PredicateBuilder is designed to build predicate for Voucher filtering
 */
public class PredicateBuilder {
    private Predicate<Voucher> predicate;

    public PredicateBuilder(){
        predicate = voucher -> true;
    }

    
    /** 
     * @param type
     * @return PredicateBuilder
     */
    public PredicateBuilder setTripTypeFilter(TripType type) {
        Predicate<Voucher> typePr = voucher -> (TripTypeMapper.getMapperTable().get(voucher.getClass()) == type);
        this.predicate = predicate.and(typePr);
        return this;
    }

    
    /** 
     * @param nights
     * @return PredicateBuilder
     */
    public PredicateBuilder setNightsFilter(int nights){
        Predicate<Voucher> nightsPr = voucher -> voucher.getNights() == nights;
        this.predicate = predicate.and(nightsPr);
        return this;
    }

    
    /** 
     * @param food
     * @return PredicateBuilder
     */
    public PredicateBuilder setFoodFilter(Food food) {
        Predicate<Voucher> foodPr = voucher ->voucher.getFood() == food;
        this.predicate = predicate.and(foodPr);
        return this;
    }

    
    /** 
     * @param transport
     * @return PredicateBuilder
     */
    public PredicateBuilder setTransportFilter(Transport transport) {
        Predicate<Voucher> trPr = voucher ->voucher.getTransport() == transport;
        this.predicate = predicate.and(trPr);
        return this;
    }

    
    /** 
     * @return Predicate<Voucher>
     */
    public Predicate<Voucher> build(){
        return predicate;
    }
}

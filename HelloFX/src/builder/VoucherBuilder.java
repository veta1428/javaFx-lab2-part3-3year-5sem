package builder;
import java.time.LocalDateTime;

import types.Food;
import types.Transport;
import types.TripType;

import vouchers.Voucher;

// builder
public class VoucherBuilder {
    
    private Voucher voucher;

    
    /** 
     * @param type
     * @return VoucherBuilder
     */
    public VoucherBuilder create(TripType type) {
        voucher = Voucher.create(type);
        return this;
    }

    
    /** 
     * @param name
     * @return VoucherBuilder
     */
    public VoucherBuilder setName(String name) {
        voucher.setTourName(name);
        return this;
    }

    
    /** 
     * @param desc
     * @return VoucherBuilder
     */
    public VoucherBuilder setDescription(String desc) {
        voucher.setDescription(desc);
        return this;
    }

    
    /** 
     * @param program
     * @return VoucherBuilder
     */
    public VoucherBuilder setProgram(String program) {
        voucher.setProgram(program);
        return this;
    }

    
    /** 
     * @param nights
     * @return VoucherBuilder
     */
    public VoucherBuilder setNights(int nights) {
        voucher.setNights(nights);
        return this;
    }

    
    /** 
     * @param date
     * @return VoucherBuilder
     */
    public VoucherBuilder setStartDate(LocalDateTime date) {
        voucher.setStartDate(date);
        return this;
    }

    
    /** 
     * @param price
     * @return VoucherBuilder
     */
    public VoucherBuilder setPrice(double price){
        voucher.setPrice(price);
        return this;
    }

    
    /** 
     * @param transport
     * @return VoucherBuilder
     */
    public VoucherBuilder setTransport(Transport transport){
        voucher.setTransport(transport);
        return this;
    }

    
    /** 
     * @param food
     * @return VoucherBuilder
     */
    public VoucherBuilder setFood(Food food){
        voucher.setFood(food);
        return this;
    }

    
    /** 
     * @return Voucher
     */
    public Voucher build(){
        return voucher;
    }
}

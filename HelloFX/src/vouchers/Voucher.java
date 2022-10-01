package vouchers;
import java.time.LocalDateTime;

import builder.VoucherBuilder;
import types.Food;
import types.Transport;
import types.TripType;

// factory method 
public abstract class Voucher implements Comparable<Voucher> {

    
    /** 
     * @param voucherType
     * @return Voucher
     */
    public static Voucher create(TripType voucherType){
        switch (voucherType) {
            case Rest: {
                return new RestVoucher();
            }
            case Excursion:{
                return new ExcursionVoucher();
            }
            case Treatment:{
                return new TreatmentVoucher();
            }
            case Shopping:{
                return new ShoppingVoucher();
            }
            case Cruise:{
                return new CruiseVoucher();
            }
            default:{
                throw new EnumConstantNotPresentException(voucherType.getClass(), voucherType.name());
            }

        }
    }

    
    /** 
     * @return VoucherBuilder
     */
    public static VoucherBuilder createBuilder(){
        return new VoucherBuilder();
    }

    private String tourName = null; 
    private String description = null;
    private String program = null;
    private LocalDateTime start = null;
    private int nights;
    private double price;
    private Transport transport = null;
    private Food food = null;

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Tour name: %s\nDescription: %s\nProgram: %s\nDate: %s\nNights: %d\nPrice: %s\nTransport: %s\nFood: %s\n", 
        tourName, description, program, start.toString(), nights, price, transport, food);
    }

    
    /** 
     * @param tourName
     */
    // setters
    public void setTourName(String tourName){
        if (tourName.isEmpty() || tourName == null){
            throw new IllegalArgumentException();
        }

        this.tourName = tourName;
    }

    
    /** 
     * @param desc
     */
    public void setDescription(String desc){
        this.description = desc;
    }

    
    /** 
     * @param program
     */
    public void setProgram(String program){
        this.program = program;
    }

    
    /** 
     * @param date
     */
    public void setStartDate(LocalDateTime date){
        if(date == null || date.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException();
        }
        this.start = date;
    }

    
    /** 
     * @param nights
     */
    public void setNights(int nights){
        if(nights > 50 || nights < 3) {
            throw new IllegalArgumentException();
        }
        this.nights = nights;
    }

    
    /** 
     * @param price
     */
    public void setPrice(double price){
        if(price < 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    
    /** 
     * @param transport
     */
    public void setTransport(Transport transport){
        this.transport = transport;
    }

    
    /** 
     * @param food
     */
    public void setFood(Food food){
        this.food = food;
    }


    
    /** 
     * @return String
     */
    // getters
    public String getTourName(){
        return this.tourName;
    }

    
    /** 
     * @return String
     */
    public String getDescription(){
        return this.description;
    }

    
    /** 
     * @return String
     */
    public String getProgram(){
        return this.program;
    }

    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getStartDate(){
        return this.start;
    }

    
    /** 
     * @return int
     */
    public int getNights(){
        return this.nights;
    }

    
    /** 
     * @return double
     */
    public double getPrice(){
        return this.price;
    }

    
    /** 
     * @return Transport
     */
    public Transport getTransport(){
        return this.transport;
    }

    
    /** 
     * @return Food
     */
    public Food getFood(){
        return this.food;
    }

    public abstract TripType getType();

    /** 
     * @param p
     * @return int
     */
    @Override
    public int compareTo(Voucher p){
        if (getPrice() < p.getPrice()){
            return -1;
        } else if (getPrice() > p.getPrice()){
            return 1;
        } else {
            return 0;
        }
    }
}

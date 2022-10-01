package dataseeder;

import java.time.LocalDateTime;
import java.util.ArrayList;

import types.Food;
import types.Transport;
import types.TripType;
import vouchers.Voucher;

public class DataSeeder {
    
    /** 
     * @return ArrayList<Voucher>
     */
    public static ArrayList<Voucher> GetVouchers() {

        ArrayList<Voucher> vouchers = new ArrayList<Voucher>();

        // rest 
        Voucher restVoucher = Voucher
            .createBuilder()
            .create(TripType.Rest)
            .setName("Turkey. Izmir. Hotel XYZ")
            .setDescription("Sunny beach")
            .setProgram("Swimming, eating ice-cream")
            .setNights(14)
            .setPrice(2000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 11, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(restVoucher);

        Voucher restVoucher2 = Voucher
            .createBuilder()
            .create(TripType.Rest)
            .setName("Turkey. Izmir. Hotel XYZ")
            .setDescription("Sunny beach")
            .setProgram("Swimming, eating ice-cream")
            .setNights(10)
            .setPrice(1200.0)
            .setStartDate(LocalDateTime.of(2022, 11, 11, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.BreakfastAndLaunchOnly)
            .build();
        vouchers.add(restVoucher2);

        Voucher restVoucher3 = Voucher
            .createBuilder()
            .create(TripType.Rest)
            .setName("Turkey. Izmir. Hotel XYZ")
            .setDescription("Sunny beach")
            .setProgram("Swimming, eating ice-cream")
            .setNights(7)
            .setPrice(800.0)
            .setStartDate(LocalDateTime.of(2022, 11, 11, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(restVoucher3);

        Voucher restVoucher4 = Voucher
            .createBuilder()
            .create(TripType.Rest)
            .setName("Egypt")
            .setDescription("Sunny beach")
            .setProgram("Cairo, Hurgada")
            .setNights(14)
            .setPrice(1800.0)
            .setStartDate(LocalDateTime.of(2022, 11, 9, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.BreakfastOnly)
            .build();
        vouchers.add(restVoucher4);

        Voucher restVoucher5 = Voucher
            .createBuilder()
            .create(TripType.Rest)
            .setName("Egypt")
            .setDescription("Sunny beach")
            .setProgram("Cairo, Hurgada")
            .setNights(10)
            .setPrice(900.0)
            .setStartDate(LocalDateTime.of(2022, 11, 8, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.BreakfastAndLaunchOnly)
            .build();
        vouchers.add(restVoucher5);

        Voucher restVoucher6 = Voucher
            .createBuilder()
            .create(TripType.Rest)
            .setName("Egypt")
            .setDescription("Sunny beach")
            .setProgram("Cairo, Hurgada")
            .setNights(7)
            .setPrice(600.0)
            .setStartDate(LocalDateTime.of(2022, 11, 7, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(restVoucher6);

        // Excursion
        Voucher excursionVoucher = Voucher
            .createBuilder()
            .create(TripType.Excursion)
            .setName("Poland")
            .setDescription("Nice tour")
            .setProgram("Gdansk, Gdynia, Sopot, Warszawa, Krakow, Zakopane")
            .setNights(7)
            .setPrice(1500.0)
            .setStartDate(LocalDateTime.of(2022, 11, 10, 12, 0, 0))
            .setTransport(Transport.Bus)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(excursionVoucher);

        Voucher excursionVoucher2 = Voucher
            .createBuilder()
            .create(TripType.Excursion)
            .setName("Poland")
            .setDescription("Nice tour")
            .setProgram("Gdansk, Gdynia, Sopot, Warszawa, Krakow, Zakopane")
            .setNights(7)
            .setPrice(1500.0)
            .setStartDate(LocalDateTime.of(2022, 11, 3, 12, 0, 0))
            .setTransport(Transport.Bus)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(excursionVoucher2);

        Voucher excursionVoucher3 = Voucher
            .createBuilder()
            .create(TripType.Excursion)
            .setName("Poland")
            .setDescription("Nice tour")
            .setProgram("Gdansk, Gdynia, Sopot, Warszawa, Krakow, Zakopane")
            .setNights(7)
            .setPrice(1500.0)
            .setStartDate(LocalDateTime.of(2022, 11, 7, 12, 0, 0))
            .setTransport(Transport.Train)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(excursionVoucher3);

        Voucher excursionVoucher4 = Voucher
            .createBuilder()
            .create(TripType.Excursion)
            .setName("Holandia")
            .setDescription("Nice tour")
            .setProgram("Amsterdam")
            .setNights(7)
            .setPrice(2000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 7, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(excursionVoucher4);

        Voucher excursionVoucher5 = Voucher
            .createBuilder()
            .create(TripType.Excursion)
            .setName("Holandia")
            .setDescription("Nice tour")
            .setProgram("Amsterdam")
            .setNights(7)
            .setPrice(2000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 4, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(excursionVoucher5);

        // cruise
        Voucher cruiseVoucher = Voucher
            .createBuilder()
            .create(TripType.Cruise)
            .setName("Jungles")
            .setDescription("...")
            .setProgram("Try to survive")
            .setNights(7)
            .setPrice(3000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 4, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(cruiseVoucher);

        Voucher cruiseVoucher1 = Voucher
            .createBuilder()
            .create(TripType.Cruise)
            .setName("Jungles")
            .setDescription("...")
            .setProgram("Try to survive")
            .setNights(7)
            .setPrice(3000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 8, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(cruiseVoucher1);

        Voucher cruiseVoucher2 = Voucher
            .createBuilder()
            .create(TripType.Cruise)
            .setName("Jungles")
            .setDescription("...")
            .setProgram("Try to survive")
            .setNights(7)
            .setPrice(3000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 17, 12, 0, 0))
            .setTransport(Transport.Plain)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(cruiseVoucher2);

        // treatment

        Voucher treatmentVoucher = Voucher
            .createBuilder()
            .create(TripType.Treatment)
            .setName("Druskininkai")
            .setDescription("Nice place")
            .setProgram("Some procedures")
            .setNights(7)
            .setPrice(1000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 1, 12, 0, 0))
            .setTransport(Transport.Bus)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(treatmentVoucher);

        Voucher treatmentVoucher2 = Voucher
            .createBuilder()
            .create(TripType.Treatment)
            .setName("Druskininkai")
            .setDescription("Nice place")
            .setProgram("Some procedures")
            .setNights(10)
            .setPrice(1400.0)
            .setStartDate(LocalDateTime.of(2022, 11, 9, 12, 0, 0))
            .setTransport(Transport.Car)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(treatmentVoucher2);

        Voucher treatmentVoucher3 = Voucher
            .createBuilder()
            .create(TripType.Treatment)
            .setName("Druskininkai")
            .setDescription("Nice place")
            .setProgram("Some procedures")
            .setNights(12)
            .setPrice(1400.0)
            .setStartDate(LocalDateTime.of(2022, 11, 9, 12, 0, 0))
            .setTransport(Transport.Bus)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(treatmentVoucher3);

        // shopping 
        Voucher shoppingVoucher = Voucher
            .createBuilder()
            .create(TripType.Shopping)
            .setName("Turkey")
            .setDescription("Nice place")
            .setProgram("Some sales")
            .setNights(7)
            .setPrice(1000.0)
            .setStartDate(LocalDateTime.of(2022, 11, 1, 12, 0, 0))
            .setTransport(Transport.Bus)
            .setFood(Food.AllIncluded)
            .build();
        vouchers.add(shoppingVoucher);

        return vouchers;
    }
}

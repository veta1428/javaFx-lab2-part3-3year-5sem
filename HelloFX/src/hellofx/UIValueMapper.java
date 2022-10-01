package hellofx;

import java.util.HashMap;
import java.util.Map;

import types.Food;
import types.Transport;
import types.TripType;

public class UIValueMapper {
    public static Map<String, TripType> uIStringToTripType() {
        Map<String, TripType> map = new HashMap<String, TripType>();

        map.put(Constants.Rest, TripType.Rest);
        map.put(Constants.Cruise, TripType.Cruise);
        map.put(Constants.Excursion, TripType.Excursion);
        map.put(Constants.Shopping, TripType.Shopping);
        map.put(Constants.Treatment, TripType.Treatment);
        map.put(Constants.StringNull, null);
        map.put(Constants.StringEmpty, null);
        return map;
    }

    public static Map<String, Food> uIStringToFoodType() {
        Map<String, Food> map = new HashMap<String, Food>();

        map.put(Constants.NotIncluded, Food.NotIncluded);
        map.put(Constants.BreakfastOnly, Food.BreakfastOnly);
        map.put(Constants.BreakfastAndLaunchOnly, Food.BreakfastAndLaunchOnly);
        map.put(Constants.AllIncluded, Food.AllIncluded);
        map.put(Constants.StringNull, null);
        map.put(Constants.StringEmpty, null);
        return map;
    }

    public static Map<String, Transport> uIStringToTransportType() {
        Map<String, Transport> map = new HashMap<String, Transport>();

        map.put(Constants.Car, Transport.Car);
        map.put(Constants.Train, Transport.Train);
        map.put(Constants.Bus, Transport.Bus);
        map.put(Constants.Plain, Transport.Plain);
        map.put(Constants.StringNull, null);
        map.put(Constants.StringEmpty, null);
        return map;
    }
}

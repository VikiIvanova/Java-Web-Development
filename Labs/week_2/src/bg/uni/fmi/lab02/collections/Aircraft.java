package bg.uni.fmi.lab02.collections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aircraft {
    private String tailNumber;
    private Map<String, List<FlightLeg>> flightLegs;

    public Aircraft(String tailNumber) {
        this.tailNumber = tailNumber;
        this.flightLegs = new HashMap<>();
    }

    public void addFlightLeg(String fromAirport, String toAirport, LocalDate date) {
        FlightLeg flightLeg = new FlightLeg(fromAirport, toAirport, date);
        if (!flightLegs.containsKey(fromAirport)) {
            flightLegs.put(fromAirport, new ArrayList<>());
        }
        flightLegs.get(fromAirport).add(flightLeg);
    }

    public List<FlightLeg> getFlightLegs(String airport) {
        List<FlightLeg> result = new ArrayList<>();
        if (flightLegs.containsKey(airport)) {
            result.addAll(flightLegs.get(airport));
        }
        return result;
    }
}

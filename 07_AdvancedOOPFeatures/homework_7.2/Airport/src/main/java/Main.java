import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> result = new ArrayList<>();

        Calendar datePlusTwoHour = Calendar.getInstance();
        datePlusTwoHour.add(Calendar.HOUR, 2);

        airport.getTerminals()
                .forEach(terminal -> terminal.getFlights().stream()
                        .filter(flight -> flight.getType() == DEPARTURE)
                        .filter(flight -> flight.getDate().before(datePlusTwoHour.getTime()))
                        .forEach(result::add));

        return result;
    }

}
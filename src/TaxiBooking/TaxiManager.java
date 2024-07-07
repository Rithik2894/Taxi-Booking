package TaxiBooking;

import java.util.ArrayList;
import java.util.List;

public class TaxiManager {
    private List<Taxi> taxis;

    public TaxiManager(int numberOfTaxis) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= numberOfTaxis; i++) {
            taxis.add(new Taxi(i, "A", 0));
        }
    }

    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }

    public Taxi isTaxiAvailable(String pickupPoint, int pickupTime) {
        Taxi nearestTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.isTaxiAvailable() && taxi.getCurrentLocation().equals(pickupPoint)) {
                return taxi;
            } else if (taxi.isTaxiAvailable() || taxi.getAvailableTime() <= pickupTime) {
                int distance = Math.abs(taxi.getCurrentLocation().charAt(0) - pickupPoint.charAt(0));
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestTaxi = taxi;
                }
            }
        }
        return nearestTaxi;
    }
}

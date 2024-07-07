package TaxiBooking;

public class Taxi {
    private int id;
    private String currentLocation = "A";
    private int totalEarnings;
    private boolean available = true;
    private int availableTime = 0;

    public Taxi(int id, String currentLocation, int totalEarnings) {
        this.id = id;
        this.currentLocation = currentLocation;
        this.totalEarnings = totalEarnings;
    }

    public int getId() {
        return id;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void updateEarnings(int fare) {
        totalEarnings += fare;
    }

    public boolean isTaxiAvailable() {
        return available;
    }

    public void setAvailabilty(boolean available) {
        this.available = available;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public void updateLocationAndTime(String newLocation, int dropTime) {
        this.currentLocation = newLocation;
        this.availableTime = dropTime;
        this.available = false;
    }

    public void makeAvailable(int time) {
        this.availableTime = time;
        this.available = true;
    }
}

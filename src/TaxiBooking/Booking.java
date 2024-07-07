package TaxiBooking;

public class Booking {
    private int bookingId;
    private int customerId;
    private String pickupPoint;
    private String dropPoint;
    private int pickupTime;
    private int dropTime;
    private int amount;

    public Booking(int bookingId, int customerId, String pickupPoint, String dropPoint, int pickupTime) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.dropTime = calculateDropTime();
        this.amount = calculateFare();
    }

    private int calculateDropTime() {
        int distance = Math.abs(pickupPoint.charAt(0) - dropPoint.charAt(0));
        return pickupTime + distance * 60;
    }

    private int calculateFare() {
        int distance = Math.abs(pickupPoint.charAt(0) - dropPoint.charAt(0)) * 15;
        if (distance <= 5) {
            return 100;
        } else {
            return 100 + (distance - 5) * 10;
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public String getDropPoint() {
        return dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public int getAmount() {
        return amount;
    }

    public void afterBooking(Taxi taxi) {
        taxi.updateEarnings(amount);
        taxi.setCurrentLocation(dropPoint);
        taxi.setAvailableTime(dropTime);
        taxi.setAvailabilty(false);
    }
}

package TaxiBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaxiManager taxiManager = new TaxiManager(4);

        int bookingId = 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Book Taxi\n2. Display Taxi Details\n3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer ID:");
                    int customerId = scanner.nextInt();
                    System.out.println("Enter Pickup Point:");
                    String pickupPoint = scanner.next();
                    System.out.println("Enter Pickup Time:");
                    int pickupTime = scanner.nextInt();
                    System.out.println("Enter Drop Point:");
                    String dropPoint = scanner.next();

                    Taxi assignedTaxi = taxiManager.isTaxiAvailable(pickupPoint, pickupTime);

                    if (assignedTaxi != null) {
                        Booking booking = new Booking(bookingId++, customerId, pickupPoint, dropPoint, pickupTime);
                        booking.afterBooking(assignedTaxi);
                        System.out.println("Taxi can be allotted.");
                        System.out.println("Taxi-" + assignedTaxi.getId() + " is allotted.");
                    } else {
                        System.out.println("No taxi available at this time.");
                    }
                    break;

                case 2:
                    // Display taxi details
                    for (Taxi taxi : taxiManager.getTaxis()) {
                        System.out.println("Taxi-" + taxi.getId() + " Total Earnings: Rs. " + taxi.getTotalEarnings());
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

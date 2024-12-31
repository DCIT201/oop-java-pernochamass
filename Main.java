import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a RentalAgency
        RentalAgency rentalAgency = getRentalAgency();

        // Step 3: Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

    // Ask for vehicle preferences
        System.out.println("Enter the brand of the vehicle (e.g., Toyota, Honda, Ford):");
    String brand = scanner.nextLine();

        System.out.println("Enter the transmission type (e.g., Manual, Automatic):");
        String transmissionType = scanner.nextLine();

        System.out.println("Enter the type of the car (e.g., Sedan, SUV, Pickup):");
    String carType = scanner.nextLine();

    // Ask for the number of rental days
        System.out.println("Enter the number of days you want to rent the vehicle:");
    int rentalDays;
        try {
        rentalDays = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input for days. Please enter a number.");
        return;
    }

    // Process rental
        System.out.println("\nProcessing your rental...");
    Customer customer = new Customer(""); // Create a sample customer
        String vehicleId = "";
        rentalAgency.rentVehicle(vehicleId, customer, rentalDays);

    // Display rental summary
        System.out.println("\nRental Summary:");
        System.out.println("Customer: " + customer.getName());
        Vehicle selectedVehicle = null;
        System.out.println("Vehicle: " + selectedVehicle.getModel());
        System.out.println("Brand: " + brand);
        System.out.println("Transmission Type: " + transmissionType);
        System.out.println("Car Type: " + carType);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + selectedVehicle.calculateRentalCost(rentalDays));

    // Display available vehicles after rental
        System.out.println("\nAvailable vehicles after the rental:");
        rentalAgency.displayAvailableVehicles();

    // Close the scanner
        scanner.close();
}

private static RentalAgency getRentalAgency() {
    RentalAgency rentalAgency = new RentalAgency();

    // Step 2: Add Vehicles to the Fleet
    Vehicle car1 = new Car("C001", "Toyota Corolla", 30.0, "Automatic");
    Vehicle car2 = new Car("C002", "Honda Civic", 35.0, "Manual");
    Vehicle motorcycle = new Motorcycle("M001", "Harley Davidson", 20.0, "Manual");
    Vehicle truck = new Truck("T001", "Ford F-150", 50.0, "Automatic");

    rentalAgency.addVehicle(car1);
    rentalAgency.addVehicle(car2);
    rentalAgency.addVehicle(motorcycle);
    rentalAgency.addVehicle(truck);
    return rentalAgency;
}

}





import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a RentalAgency
        RentalAgency rentalAgency = getRentalAgency();

        // Step 3: Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Our Advanced Vehicle Rental System!");
        System.out.println("Here are the available vehicles:");
        System.out.println("Please choose a vehicle to rent:");
        System.out.println("1. Motorcycle");
        System.out.println("2. Car");
        System.out.println("3. Truck");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Variables to hold common details
        String vehicleId = "", model, transmissionType = "";
        double baseRentalRate;

        // Handle user choice
        Vehicle selectedVehicle = null;
        switch (choice) {
            case 1: // Motorcycle
                System.out.print("Enter Motorcycle ID: ");
                vehicleId = scanner.nextLine();

                System.out.print("Enter Motorcycle Model: ");
                model = scanner.nextLine();

                System.out.print("Enter Base Rental Rate for the Motorcycle: ");
                baseRentalRate = scanner.nextDouble();

                // Create Motorcycle instance
                selectedVehicle = new Motorcycle(vehicleId, model, baseRentalRate);
                break;

            case 2: // Car
                System.out.print("Enter Car ID: ");
                vehicleId = scanner.nextLine();

                System.out.print("Enter Car Model: ");
                model = scanner.nextLine();

                System.out.print("Enter Base Rental Rate for the Car: ");
                baseRentalRate = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Transmission Type (Manual/Automatic): ");
                 transmissionType = scanner.nextLine();

                // Create Car instance
                selectedVehicle = new Car(vehicleId, model, baseRentalRate, transmissionType);
                break;

            case 3: // Truck
                System.out.print("Enter Truck ID: ");
                vehicleId = scanner.nextLine();

                System.out.print("Enter Truck Model: ");
                model = scanner.nextLine();

                System.out.print("Enter Base Rental Rate for the Truck: ");
                baseRentalRate = scanner.nextDouble();

                // Create Truck instance
                selectedVehicle = new Truck(vehicleId, model, baseRentalRate, transmissionType);
                break;

            default:
                System.out.println("Invalid choice! Please restart the program and choose a valid option.");
                System.exit(0);
        }

        // Display selected vehicle details
        if (selectedVehicle != null) {
            System.out.println("You have successfully entered the vehicle of your choice to be rented :");
            System.out.println(selectedVehicle);
        }

        // Close the scanner
        scanner.close();

// Display available vehicles
        rentalAgency.displayAvailableVehicles();
    // Ask for vehicle preferences
        System.out.println("Enter the brand of the vehicle (e.g., Toyota, Honda, Ford):");
    String brand = scanner.nextLine();

        System.out.println("Enter the transmission type (e.g., Manual, Automatic):");
      transmissionType = scanner.nextLine();

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
    Customer customer = new Customer("Alice"); // Create a sample customer
        rentalAgency.rentVehicle(vehicleId, customer, rentalDays);

    // Display rental summary
        System.out.println("\nRental Summary:");
        System.out.println("Customer: " + customer.getName());
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
    Vehicle motorcycle = new Motorcycle("M001", "Harley Davidson", 20.0);
    Vehicle truck = new Truck("T001", "Ford F-150", 50.0, "Automatic");

    rentalAgency.addVehicle(car1);
    rentalAgency.addVehicle(car2);
    rentalAgency.addVehicle(motorcycle);
    rentalAgency.addVehicle(truck);
    return rentalAgency;
}

}





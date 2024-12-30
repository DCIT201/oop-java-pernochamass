public class Car extends Vehicle {
    public Car(String vehicleId, String model, double baseRentalRate, String transmissionType) {
        super(vehicleId, model, baseRentalRate, transmissionType);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Rental cost is the base rate multiplied by the number of days
        return getBaseRentalRate() * days;
    }

    @Override
    public boolean isAvailableForRental() {
        // Return whether the car is currently available for rental
        return isAvailable();
    }
}
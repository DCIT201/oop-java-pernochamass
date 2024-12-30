public class Truck extends Vehicle {
    public Truck(String vehicleId, String model, double baseRentalRate, String transmissionType) {
        super(vehicleId, model, baseRentalRate, transmissionType);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Rental cost is the base rate multiplied by the number of days with a 50% extra cost
        return getBaseRentalRate() * days * 1.5; // 50% surcharge
    }

    @Override
    public boolean isAvailableForRental() {
        // Return whether the truck is currently available for rental
        return isAvailable();
    }
}
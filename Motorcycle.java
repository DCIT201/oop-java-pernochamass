public class Motorcycle extends Vehicle {
    public Motorcycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Rental cost is the base rate multiplied by the number of days with a 10% discount
        return getBaseRentalRate() * days * 0.9; // 10% discount
    }

    @Override
    public boolean isAvailableForRental() {
        // Return whether the motorcycle is currently available for rental
        return isAvailable();
    }
}
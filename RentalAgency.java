import java.util.ArrayList;
import java.util.List;

class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void rentVehicle(String vehicleId, Customer customer, int days) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailable()) {
                vehicle.setAvailable(false);
                customer.addRentalHistory(vehicle);
                double cost = vehicle.calculateRentalCost(days);
                System.out.println(customer.getName() + " rented " + vehicle.getModel() + " for $" + cost);
                return;
            }
        }
        System.out.println("Vehicle not available for rent.");
    }

    public void returnVehicle(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && !vehicle.isAvailable()) {
                vehicle.setAvailable(true);
                System.out.println(vehicle.getModel() + " has been returned.");
                return;
            }
        }
        System.out.println("Vehicle not found or already available.");
    }

    public Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null; // Return null if the vehicle ID is not found
    }

    public void displayAvailableVehicles() {
    }
}

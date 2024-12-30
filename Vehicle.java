public abstract class Vehicle {
    // Private encapsulated fields
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private String transmissionType; // Added transmission type field

    // Constructor
    public Vehicle(String vehicleId, String model, double baseRentalRate, String transmissionType) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than zero.");
        }
        if (transmissionType == null || (!transmissionType.equalsIgnoreCase("Manual")
                && !transmissionType.equalsIgnoreCase("Automatic"))) {
            throw new IllegalArgumentException("Transmission type must be either 'Manual' or 'Automatic'.");
        }

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.transmissionType = transmissionType;
        this.isAvailable = true; // Vehicles are available by default
    }

    // Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        this.model = model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than zero.");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        if (transmissionType == null || (!transmissionType.equalsIgnoreCase("Manual")
                && !transmissionType.equalsIgnoreCase("Automatic"))) {
            throw new IllegalArgumentException("Transmission type must be either 'Manual' or 'Automatic'.");
        }
        this.transmissionType = transmissionType;
    }

    // Abstract methods to enforce implementation in subclasses
    public abstract double calculateRentalCost(int days);

    public abstract boolean isAvailableForRental();

    // toString method for displaying vehicle details
    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId +
                ", Model: " + model +
                ", Base Rental Rate: $" + baseRentalRate +
                ", Transmission Type: " + transmissionType +
                ", Availability: " + (isAvailable ? "Available" : "Not Available");
    }

    // Equality and hash code for comparing vehicles
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return vehicleId.equals(vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return vehicleId.hashCode();
    }
}

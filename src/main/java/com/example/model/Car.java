package com.example.model;

public class Car {
    private String registration;
    private String model;
    private int year;

    public Car(String registration, String model, int year) {
        this.registration = registration;
        this.model = model;
        this.year = year;
    }

    public String getRegistration() {
        return registration;
    }

    public String getModel() {
        return model;
    }


    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registration='" + registration + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        return this.year == other.year &&
                this.registration.equalsIgnoreCase(other.registration) &&
                this.model.equalsIgnoreCase(other.model);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(registration.toLowerCase(), model.toLowerCase(), year);
    }
}

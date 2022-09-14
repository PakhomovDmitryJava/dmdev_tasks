package com.dmdev.hometask4;

public class Floor {
    private int floorNumber;
    private Apartment[] apartments;

    public Floor(int floorNumber, Apartment[] apartments) {
        this.floorNumber = floorNumber;
        this.apartments = apartments;
    }

    public void print() {
        System.out.println("Floor number is " + floorNumber + ", "
                + "number of apartments is " + apartments.length);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }
}

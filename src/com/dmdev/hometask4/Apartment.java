package com.dmdev.hometask4;

public class Apartment {
    private int apartmentNumber;
    private Room[] rooms;

    public Apartment(int apartmentNumber, Room[] rooms) {
        this.apartmentNumber = apartmentNumber;
        this.rooms = rooms;
    }

    public void print() {
        System.out.println("Apartment number is " + apartmentNumber + ", "
                + "number of rooms is " + rooms.length);
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}

package com.dmdev.hometask4;

public class Home {
    private int homeNumber;
    private Floor[] floors;

    public Home(int homeNumber, Floor[] floors) {
        this.homeNumber = homeNumber;
        this.floors = floors;
    }

    public void print() {
        System.out.println("Home number is " + homeNumber + ", "
                + "number of apartments is " + floors.length);
    }

    public void printAllInformation(Home home) {
        home.print();
        for (Floor floor : floors) {
            floor.print();
            Apartment[] apartments = floor.getApartments();
            for (Apartment apartment : apartments) {
                apartment.print();
                Room[] rooms = apartment.getRooms();
                for (Room room : rooms) {
                    room.print();
                }
            }
        }
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

}

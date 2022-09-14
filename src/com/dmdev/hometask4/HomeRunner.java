package com.dmdev.hometask4;

public class HomeRunner {
    public static void main(String[] args) {
        Room room1 = new Room(true);
        room1.print();
        Room room2 = new Room(false);
        Room room3 = new Room(false);
        Room[] rooms = {room1, room2, room3};

        Apartment apartment1 = new Apartment(1,rooms);
        apartment1.print();
        Apartment apartment2 = new Apartment(2,rooms);
        Apartment apartment3 = new Apartment(3,rooms);
        Apartment[] apartments = {apartment1, apartment2, apartment3};

        Floor floor1 = new Floor(1,apartments);
        floor1.print();
        Floor floor2 = new Floor(2,apartments);
        Floor floor3 = new Floor(3,apartments);
        Floor[] floors = {floor1, floor2, floor3};

        Home home = new Home(1,floors);
        home.print();

        home.printAllInformation(home);
    }
}

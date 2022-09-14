package com.dmdev.hometask4;

public class Room {
  private boolean walktroughRoom;

    public Room(boolean walktroughRoom) {
        this.walktroughRoom = walktroughRoom;
    }

    public void print() {
        if (walktroughRoom == true) {
            System.out.println("This room is walk-through!");
        } else {
            System.out.println("This room is NOT walk-through!");
        }
    }

    public boolean isTroughRoom() {
        return walktroughRoom;
    }

    public void setTroughRoom(boolean troughRoom) {
        this.walktroughRoom = troughRoom;
    }
}

package com.dmdev.oop.lesson7;

public class CompositionRunner {
    public static void main(String[] args) {
        Ram ram = new Ram(1024);
        Ssd ssd = new Ssd(2048);
        Computer computer = new Computer(ram,ssd);
        computer.printState();
    }
}

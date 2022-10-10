package com.dmdev.hometask7;

public abstract class Meteoroid extends SpaceObject {
    public Meteoroid(String name, long mass, long radius) {
        super(name, mass, radius);
    }

    @Override
    public String toString() {
        return "Meteoroid{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", radius=" + radius +
                '}';
    }
}

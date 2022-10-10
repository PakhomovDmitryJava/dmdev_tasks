package com.dmdev.oop.lesson15.task.weapon;

import com.dmdev.oop.lesson15.task.weapon.RangeWeapon;

public class Bow implements RangeWeapon {
    @Override
    public int getDamage() {
        return 10;
    }
}

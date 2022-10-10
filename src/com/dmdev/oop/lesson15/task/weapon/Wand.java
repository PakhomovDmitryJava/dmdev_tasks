package com.dmdev.oop.lesson15.task.weapon;

import com.dmdev.oop.lesson15.task.weapon.MagicWeapon;

public class Wand implements MagicWeapon {
    @Override
    public int getDamage() {
        return 20;
    }
}

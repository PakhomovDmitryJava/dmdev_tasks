package com.dmdev.oop.lesson15.task.weapon;

import com.dmdev.oop.lesson15.task.weapon.MeleeWeapon;

public class Sword implements MeleeWeapon {
    @Override
    public int getDamage() {
        return 15;
    }
}

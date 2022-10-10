package com.dmdev.oop.lesson15.task;

import com.dmdev.oop.lesson15.task.weapon.Bow;
import com.dmdev.oop.lesson15.task.weapon.MeleeWeapon;
import com.dmdev.oop.lesson15.task.weapon.Sword;
import com.dmdev.oop.lesson15.task.weapon.Weapon;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<>("Legolas", 15);
        archer.setWeapon(new Bow());

        Warrior<Sword> warrior = new Warrior<>("Boromir", 10);
        warrior.setWeapon(new Sword());

        printWeaponDamage(warrior);
    }

    public static <T extends Weapon> void printWeaponDamage(Hero<? extends Sword> hero)  {
        Sword weapon = hero.getWeapon();
        System.out.println(hero.getWeapon().getDamage());
    }
}

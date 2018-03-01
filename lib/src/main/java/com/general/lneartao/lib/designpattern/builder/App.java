package com.general.lneartao.lib.designpattern.builder;

import com.general.lneartao.lib.Logger;

/**
 * 建造者模式
 * Created by lneartao on 2017/11/14.
 */

public class App {
    public static void main(String[] args) {
        Hero mage =
                new Hero.Builder(Profession.MAGE, "Riobard").withHairColor(HairColor.BLACK)
                        .withWeapon(Weapon.DAGGER).build();
        Logger.printl(mage.toString());

        Hero warrior =
                new Hero.Builder(Profession.WARRIOR, "Amberjill").withHairColor(HairColor.BLOND)
                        .withHairType(HairType.LONG_CURLY).withArmor(Armor.CHAIN_MAIL).withWeapon(Weapon.SWORD)
                        .build();
        Logger.printl(warrior.toString());

        Hero thief =
                new Hero.Builder(Profession.THIEF, "Desmond").withHairType(HairType.BALD)
                        .withWeapon(Weapon.BOW).build();
        Logger.printl(thief.toString());
    }
}

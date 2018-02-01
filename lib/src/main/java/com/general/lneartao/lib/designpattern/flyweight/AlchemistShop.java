package com.general.lneartao.lib.designpattern.flyweight;

import com.general.lneartao.lib.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lneartao on 2017/11/22.
 */

public class AlchemistShop {
    private List<Potion> topShelf;
    private List<Potion> bottomShelf;

    public AlchemistShop() {
        topShelf = new ArrayList<>();
        bottomShelf = new ArrayList<>();
        fillShelves();
    }

    private void fillShelves() {
        PotionFactory factory = new PotionFactory();
        topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        topShelf.add(factory.createPotion(PotionType.STRENGTH));
        topShelf.add(factory.createPotion(PotionType.HEALING));
        topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        topShelf.add(factory.createPotion(PotionType.STRENGTH));
        topShelf.add(factory.createPotion(PotionType.HEALING));
        topShelf.add(factory.createPotion(PotionType.HEALING));

        bottomShelf.add(factory.createPotion(PotionType.POISON));
        bottomShelf.add(factory.createPotion(PotionType.POISON));
        bottomShelf.add(factory.createPotion(PotionType.POISON));
        bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
        bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
    }

    public final List<Potion> getTopShelf() {
        return Collections.unmodifiableList(this.topShelf);
    }

    public final List<Potion> getBottomShelf() {
        return Collections.unmodifiableList(this.bottomShelf);
    }

    public void enumerate() {
        Logger.printl("Enumerating top shelf potions.");
        for (Potion p : topShelf) {
            p.drink();
        }
        Logger.printl("Enumerating bottom shelf potions.");
        for (Potion p : bottomShelf) {
            p.drink();
        }
    }
}

package com.general.lneartao.lib.designpattern.iterator;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/28.
 */

public class App {
    public static void main(String[] args) {
        TreasureChest chest = new TreasureChest();
        ItemIterator ringIterator = chest.iterator(ItemType.RING);
        while (ringIterator.hasNext()) {
            Logger.printl(ringIterator.next().toString());
        }

        ItemIterator potionIterator = chest.iterator(ItemType.POTION);
        while (potionIterator.hasNext()) {
            Logger.printl(potionIterator.next().toString());
        }

        ItemIterator weaponIterator = chest.iterator(ItemType.WEAPON);
        while (weaponIterator.hasNext()) {
            Logger.printl(weaponIterator.next().toString());
        }

        ItemIterator it = chest.iterator(ItemType.ANY);
        while (it.hasNext()) {
            Logger.printl(it.next().toString());
        }

    }
}

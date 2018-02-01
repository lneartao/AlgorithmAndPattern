package com.general.lneartao.lib.designpattern.iterator;

/**
 * Created by lneartao on 2017/11/28.
 */

public class Item {
    private String name;
    private ItemType itemtype;

    public Item(ItemType itemtype, String name) {
        this.name = name;
        this.itemtype = itemtype;
    }

    public ItemType getItemtype() {
        return itemtype;
    }

    public final void setItemtype(ItemType itemtype) {
        this.itemtype = itemtype;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", itemtype=" + itemtype +
                '}';
    }
}

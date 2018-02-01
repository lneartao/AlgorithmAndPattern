package com.general.lneartao.lib.designpattern.iterator;

import java.util.List;

/**
 * Created by lneartao on 2017/11/28.
 */

public class TreasureChestItemIterator implements ItemIterator {
    private int idx;
    private TreasureChest mTreasureChest;
    private ItemType mItemType;

    public TreasureChestItemIterator(TreasureChest treasureChest, ItemType itemType) {
        mItemType = itemType;
        mTreasureChest = treasureChest;
        idx = -1;
    }

    private int findNextIds() {
        List<Item> items = mTreasureChest.getItems();
        boolean found = false;
        int tempIdx = idx;
        while (!found) {
            tempIdx++;
            if (tempIdx >= items.size()) {
                tempIdx = -1;
                break;
            }
            if (ItemType.ANY.equals(mItemType) || items.get(tempIdx).getItemtype().equals(mItemType)) {
                break;
            }
        }
        return tempIdx;
    }

    @Override
    public boolean hasNext() {
        return findNextIds() != -1;
    }

    @Override
    public Item next() {
        idx = findNextIds();
        if (idx != -1) {
            return mTreasureChest.getItems().get(idx);
        } else {
            return null;
        }
    }
}

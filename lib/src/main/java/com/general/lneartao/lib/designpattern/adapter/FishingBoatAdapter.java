package com.general.lneartao.lib.designpattern.adapter;

/**
 * Created by lneartao on 2017/11/13.
 */

public class FishingBoatAdapter implements RowingBoat {
    private FishingBoat mFishingBoat;

    public FishingBoatAdapter() {
        mFishingBoat = new FishingBoat();
    }

    @Override
    public void row() {
        mFishingBoat.sail();
    }
}

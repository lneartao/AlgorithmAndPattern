package com.general.lneartao.lib.designpattern.adapter;

/**
 * Created by lneartao on 2017/11/13.
 */

public class Captain implements RowingBoat {
    private RowingBoat mRowingBoat;

    public Captain() {
    }

    public Captain(RowingBoat rowingBoat) {
        mRowingBoat = rowingBoat;
    }

    public void setRowingBoat(RowingBoat rowingBoat) {
        mRowingBoat = rowingBoat;
    }

    @Override
    public void row() {
        mRowingBoat.row();
    }
}

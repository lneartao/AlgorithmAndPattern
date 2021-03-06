package com.general.lneartao.lib.designpattern.mediator;

/**
 * Created by lneartao on 2017/12/7.
 */

public interface Party {
    void addMember(PartyMember partyMember);

    void act(PartyMember partyMember, Action action);
}

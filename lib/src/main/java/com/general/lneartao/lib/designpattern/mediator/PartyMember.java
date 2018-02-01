package com.general.lneartao.lib.designpattern.mediator;

/**
 * Created by lneartao on 2017/12/7.
 */

public interface PartyMember {
    void joinedParty(Party party);

    void partyAction(Action action);

    void act(Action action);
}

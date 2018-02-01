package com.general.lneartao.lib.designpattern.mediator;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/12/7.
 */

public abstract class PartyMemberBase implements PartyMember {

    protected Party party;

    @Override
    public void joinedParty(Party party) {
        Logger.printl(this + " joins the party.");
        this.party = party;
    }

    @Override
    public void partyAction(Action action) {
        Logger.printl(this + " " + action.getDescription());
    }

    @Override
    public void act(Action action) {
        if (party != null) {
            Logger.printl(this + " " + action);
            party.act(this, action);
        }
    }

    @Override
    public abstract String toString();
}

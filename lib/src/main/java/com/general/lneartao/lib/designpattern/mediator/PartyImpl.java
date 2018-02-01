package com.general.lneartao.lib.designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lneartao on 2017/12/7.
 */

public class PartyImpl implements Party {
    private final List<PartyMember> mPartyMembers;

    public PartyImpl() {
        mPartyMembers = new ArrayList<>();
    }

    @Override
    public void addMember(PartyMember partyMember) {
        mPartyMembers.add(partyMember);
        partyMember.joinedParty(this);
    }

    @Override
    public void act(PartyMember partyMember, Action action) {
        for (PartyMember member : mPartyMembers) {
            if (!member.equals(partyMember)) {
                member.partyAction(action);
            }
        }
    }
}

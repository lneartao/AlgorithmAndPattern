package com.general.lneartao.lib.designpattern.chain;

/**
 * Created by lneartao on 2017/11/29.
 */

public class OrcKing {
    RequestHandler chain;

    public OrcKing() {
        buildChain();
    }

    private void buildChain() {
        chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public void makeRequest(Request req) {
        chain.handleRequest(req);
    }
}

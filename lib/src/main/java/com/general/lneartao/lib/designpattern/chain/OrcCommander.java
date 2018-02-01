package com.general.lneartao.lib.designpattern.chain;

/**
 * Created by lneartao on 2017/11/29.
 */

public class OrcCommander extends RequestHandler {
    public OrcCommander(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        if (RequestType.DEFEND_CASTLE.equals(req.getRequestType())) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc commander";
    }
}

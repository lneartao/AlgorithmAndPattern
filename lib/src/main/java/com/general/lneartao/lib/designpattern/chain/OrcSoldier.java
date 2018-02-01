package com.general.lneartao.lib.designpattern.chain;

/**
 * Created by lneartao on 2017/11/29.
 */

public class OrcSoldier extends RequestHandler {

    public OrcSoldier(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        if (RequestType.COLLECT_TAX.equals(req.getRequestType())) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc soldier";
    }
}

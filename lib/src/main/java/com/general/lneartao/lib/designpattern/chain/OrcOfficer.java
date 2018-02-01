package com.general.lneartao.lib.designpattern.chain;

/**
 * Created by lneartao on 2017/11/29.
 */

public class OrcOfficer extends RequestHandler {

    public OrcOfficer(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        if (RequestType.TORTURE_PRISONER.equals(req.getRequestType())) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc officer";
    }
}

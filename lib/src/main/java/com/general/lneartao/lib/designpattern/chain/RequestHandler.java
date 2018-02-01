package com.general.lneartao.lib.designpattern.chain;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/29.
 */

public abstract class RequestHandler {
    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request req) {
        if (next != null) {
            next.handleRequest(req);
        }
    }

    public void printHandling(Request req) {
        Logger.printl(this + " handling request " + req);
    }

    @Override
    public abstract String toString();

}

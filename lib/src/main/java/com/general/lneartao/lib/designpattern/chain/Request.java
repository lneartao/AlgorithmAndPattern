package com.general.lneartao.lib.designpattern.chain;

import java.util.Objects;

/**
 * Created by lneartao on 2017/11/29.
 */

public class Request {
    private final RequestType mRequestType;
    private final String mRequestDescription;
    private boolean handled;

    public Request(RequestType requestType, String requestDescription) {
        mRequestType = Objects.requireNonNull(requestType);
        mRequestDescription = Objects.requireNonNull(requestDescription);
    }

    public RequestType getRequestType() {
        return mRequestType;
    }

    public String getRequestDescription() {
        return mRequestDescription;
    }

    public void markHandled() {
        handled = true;
    }

    public boolean isHandled() {
        return handled;
    }

    @Override
    public String toString() {
        return getRequestDescription();
    }
}

package com.general.lneartao.lib.concurrency.ohter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Using FutureTask to preload data that is needed later
 *
 * @author lneartao
 * @date 2018/4/27.
 */
public class Preloader {
    ProductInfo loadProductInfo() throws DataLoadException {
        return null;
    }

    private final FutureTask<ProductInfo> future = new FutureTask<>(this::loadProductInfo);
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                throw (DataLoadException) cause;
            } else {
                // LaunderThrowable.launcerThrowable(cause);
                throw null;
            }
        }
    }

    interface ProductInfo {

    }
}

class DataLoadException extends Exception {

}

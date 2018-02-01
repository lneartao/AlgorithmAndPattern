package com.general.lneartao.lib.designpattern.observer.generic;

/**
 * Created by lneartao on 2017/11/27.
 */

public interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

    void update(S subject, A argument);
}

package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Delegating thread safety to multiple underlying state variables
 * 如果一个类是由多个独立且线程安全的状态变量组成，并且在所有的操作中都不包含无效状态转换，那么可以将线程安全性委托给底层的状态变量
 *
 * @author lneartao
 * @date 2018/4/25.
 */
@ThreadSafe
public class VisualComponent {

    private final List<KeyListener> mKeyListeners = new CopyOnWriteArrayList<>();
    private final List<MouseListener> mMouseListeners = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener listener) {
        mKeyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mMouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        mKeyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mMouseListeners.remove(listener);
    }

    interface KeyListener {

    }

    interface MouseListener {

    }
}

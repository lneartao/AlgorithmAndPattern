package com.general.lneartao.lib.effectivejava.r5;

/**
 * 用实例域代替序数
 * <p>
 * 永远不要根据枚举的序数导出与它关联的值，而是要将它保存在一个实例域中，比如下面的 {@link Ensemble#numberOfMusicians}
 * 最好完全避免使用 ordinal方法，它是设计用于像EnumSet和EnumMap这种基于枚举的通用数据结构的。
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public class I35 {
    private enum Ensemble {
        SOLO(1), DUET(2), QUARTET(4), QUINTET(5);
        private final int numberOfMusicians;

        Ensemble(int numberOfMusicians) {
            this.numberOfMusicians = numberOfMusicians;
        }

        public int getNumberOfMusicians() {
            return numberOfMusicians;
        }
    }
}

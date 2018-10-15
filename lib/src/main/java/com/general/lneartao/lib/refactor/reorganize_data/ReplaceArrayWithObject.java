package com.general.lneartao.lib.refactor.reorganize_data;

/**
 * 以对象取代数组：对于数组中的的每个元素（非相似），以一个字段来表示
 *
 * @author lneartao
 * @date 2018/10/11.
 */
public class ReplaceArrayWithObject {

    public void doSomething() {
        Performance performance = new Performance();
        performance.setName("LiverPool");
        performance.setWins("15");
        String name = performance.getName();
        int wins = performance.getWins();
    }

    public void doSomethingUgly() {
        String[] row = new String[3];
        row[0] = "LiverPool";
        row[1] = "15";
        String name = row[0];
        int wins = Integer.parseInt(row[1]);
    }

    /**
     * 以对象取代数组
     */
    class Performance {
        private String name;
        private String wins;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWins() {
            return Integer.parseInt(wins);
        }

        public void setWins(String wins) {
            this.wins = wins;
        }
    }
}

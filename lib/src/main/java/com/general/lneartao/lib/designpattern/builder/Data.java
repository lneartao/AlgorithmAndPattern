package com.general.lneartao.lib.designpattern.builder;

/**
 * Created by lneartao on 2017/11/14.
 * 使用InnerBuilder自动生成的Builder模式，也可以用gson的annotation
 */

public class Data {
//    @SerializedName(value = "sub_date", alternate = {"date"})
//    @SerializedName("UNREAD_NUMBER")
    private final String name;
    private final String value;
    private final int count;

    private Data(Builder builder) {
        name = builder.name;
        value = builder.value;
        count = builder.count;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public static final class Builder {
        private String name;
        private String value;
        private int count;

        public Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withValue(String value) {
            this.value = value;
            return this;
        }

        public Builder withCount(int count) {
            this.count = count;
            return this;
        }

        public Data build() {
            return new Data(this);
        }
    }
}

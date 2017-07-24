package com.BRAVHAdapter;

/**
 * Created by ${liguoying} on 2017/7/24.
 */

public class DataEntity {
    private String name;
    private Class<?> activity;

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

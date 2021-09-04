package com.gradle.plugin;

/**
 * 类 必须是pulic
 *
 * 属性必须提供getter setter
 * */
public class MyConfig {

    public  String testName;

    public MyConfig(String name ) {
        this.testName = name;
        System.out.println("Hello from Plugin");
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }


}

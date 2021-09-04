package com.gradle.plugin;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecSpec;

import javax.inject.Inject;

/**
 * 自定义一个方法，标注@TaskAction注解
 *
 *
 */
public class MyTask extends DefaultTask {

    public String testName;

    @Inject
    public MyTask(String testName){
        this.testName = testName;
    }

    @TaskAction
    public void myTask(){
        System.out.println("收到TestName" + this.testName);
    }

    /**
     * 执行命令行
     * */
    public void invokeCommand(){
        getProject().exec(new Action<ExecSpec>(){

            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java", "-jar", "");
            }
        });
    }
}
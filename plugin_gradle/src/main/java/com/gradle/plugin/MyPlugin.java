package com.gradle.plugin;


import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;


public class MyPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
         final MyConfig myConfig = project.getExtensions()
                .create("myconfig",MyConfig.class,"测试11");

        project.afterEvaluate(new Action<Project>() {

            @Override
            public void execute(Project project) {
                String testName = myConfig.testName;
                System.out.println("配置的dddname:" + testName);

                AppExtension appExtension1 = (AppExtension) project
                        .getExtensions().getByName("android");
                AppExtension appExtension2 = project
                        .getExtensions().getByType(AppExtension.class);
                //如果编译器ApplicationVariant这里报红，不用管
                appExtension2.getApplicationVariants().all(new Action<ApplicationVariant>(){
                    @Override
                    public void execute(ApplicationVariant applicationVariant) {
                        String name = applicationVariant.getName();
                        System.out.println("Variant的name:" + name);
                    }
                });

                final Task task11 = project.getTasks().create("MyTaskName", MyTask.class, testName);
                task11.setGroup("CustomTask");
                project.getTasks().all(new Action<Task>(){

                    @Override
                    public void execute(Task task) {
                        System.out.println("task:" + task.getName());
                        if("clean".equals( task.getName())){
                            task.dependsOn(task11);
                        }

                    }
                });



            }
        });
    }
}
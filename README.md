## 步骤

在新建的App项目中做如下操作：

### 1.新建jar  Library

### 2.gradle中添加

```java
dependencies {
    implementation gradleApi() //必须
    implementation localGroovy() //用groovy语言开发需要依赖
}
```

### 3.添加properties
在 src/main/resource目录下面新建META-INF/gradle-plugins/com.plugin.name.properties文件的内容如下：<br>
要指向我们自己定义的Plugin类<br>
> implementation-class=com.gradle.plugin.MyPlugin





## 如何上传本地的Maven库

需要在gradle中配置
```java
plugins {
plugins {
    id 'java-library'
    id 'maven-publish'
}

publishing {
    publications{
        TestTask(MavenPublication) {
            from components.java
            groupId  'com.zzds.plugin'
            artifactId  'mygraldeplugin'
            version  '1.0.0'
        }
    }
}
```
点击编译，然后在右侧目录中，会有一个Task
> publishTestTaskPublicationToMavenLocal
点击Task会上传

在根目录下的gradle，依赖本地maven库
```
repositories {
        google()
        jcenter()
        mavenLocal()
}
```


## 如何在App module下引用定义的插件

在根目录 build.gralde下引用，
```java
dependencies {
    classpath 'com.zzds.plugin:mygraldeplugin:1.0.0'
}
```

在app目录下 build.gradle下，对应上线添加的properties名字
```java
apply plugin: 'com.gradle.plugin'
```


# 开发android gradle plugin的配置

gradle下配置，就可以依赖AGP下的方法了
```java
dependencies {
    implementation gradleApi() //必须
    implementation localGroovy() //用groovy语言开发需要依赖
    implementation "com.android.tools.build:gradle:4.2.1"
}
```
package com.example.demo.student;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private final Integer studentId;
    private final String studentName;

    public Student(Integer studentId,
                   String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    //测试元数据区-XX:MetaspaceSize=30m -XX:MaxMetaspaceSize=130m -XX:+PrintFlagsFinal
    public static void main(String[] args) throws MalformedURLException {
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        URL url = new File("/Users/i541133/OneDrive - SAP SE/study/spring/spring-security/spring-boot-security-course/target/test-classes").toURI().toURL();
        URL[] urls = {url};

        try {
            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.example.demo.DemoApplicationTests");
                System.out.println(loader);
                System.out.println(loader.getParent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

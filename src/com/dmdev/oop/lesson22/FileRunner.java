package com.dmdev.oop.lesson22;

import java.io.File;

public class FileRunner {
    public static void main(String[] args) {
        File file = new File("resources/test.txt");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}

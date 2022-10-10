package com.dmdev.oop.lesson16;

import java.util.Arrays;

import static com.dmdev.oop.lesson16.ProcessorType.BIT_64;

public class EnumRunner {
    public static void main(String[] args) {
        ProcessorType bit32 = ProcessorType.BIT_32;
        ProcessorType bit64 = ProcessorType.BIT_64;
        System.out.println(bit32.name() + " " + bit64.name());
        System.out.println(bit32 + " " + bit64);
        System.out.println(ProcessorType.valueOf("BIT_64"));
        System.out.println(Arrays.toString(ProcessorType.values()));
        System.out.println(ProcessorType.BIT_32.ordinal() + " " + BIT_64.ordinal());
        System.out.println(ProcessorType.BIT_32.getName() + " " + ProcessorType.BIT_64.getName());
        System.out.println(ProcessorType.BIT_32.getDescription() + " " + BIT_64.getDescription());
    }
}

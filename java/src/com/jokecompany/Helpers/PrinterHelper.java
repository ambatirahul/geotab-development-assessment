package com.jokecompany.Helpers;

public class PrinterHelper {
    public static Object PrintValue;

    public PrinterHelper Value(String value)
    {

        PrintValue = value;
        return this;
    }

    @Override
    public String toString() {
        System.out.println(PrintValue);
        return null;
    }

}

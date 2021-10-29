package com.company.singleton;

import java.util.Scanner;

public class ScannerSingleton {
    private static ScannerSingleton scannerSingleton;

    private Scanner scanner;

    private ScannerSingleton() {
        scanner = new Scanner(System.in);
    }

    public static ScannerSingleton getInstance() {
        if (scannerSingleton == null)
            scannerSingleton = new ScannerSingleton();
        return scannerSingleton;
    }

    public Scanner getScanner() {
        return scanner;
    }
}

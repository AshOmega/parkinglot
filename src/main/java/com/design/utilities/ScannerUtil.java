package com.design.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerUtil {

    private static ScannerUtil scannerUtil = new ScannerUtil();

    private ScannerUtil(){

    }


    /**
     * Get instance for Scanner
     * @return
     */

    public static ScannerUtil getInstance(){
        return scannerUtil;
    }


    /**
     * Read input
     * @return String
     */

    public String readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

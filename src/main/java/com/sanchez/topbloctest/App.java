package com.sanchez.topbloctest;

import resources.ExcelUtilities;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExcelUtilities xc = new ExcelUtilities();
        xc.readExcelFile("src/main/assets/Test Retake Scores.xlsx");
    }
}

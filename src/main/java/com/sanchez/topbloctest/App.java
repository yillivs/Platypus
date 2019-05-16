package com.sanchez.topbloctest;

/**
 * Top level class
 */
public class App 
{
    /**
     * Delegates flow to driver
     * @param args arguments vector
     */
    public static void main( String[] args )
    {
        Driver program = new Driver();
        program.run();
    }
}

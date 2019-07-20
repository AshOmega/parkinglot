package com.design;

import com.design.application.ParkingLotApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;


public class TestSuite {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    ParkingLotApplication parkingLotApplication = new ParkingLotApplication();

    @Before
    public void setUpStreams() {

    }

    public List<String> getCommandList() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add("create_parking_lot 6");
        commandsList.add("park KA-01-HH-1234 White");
        commandsList.add("park KA-01-HH-9999 White");
        commandsList.add("park KA-01-BB-0001 Black");
        commandsList.add("park KA-01-HH-7777 Red");
        commandsList.add("park KA-01-HH-2701 Blue");
        commandsList.add("park KA-01-HH-3141 Black");
        commandsList.add("leave 4");
        commandsList.add("status");
        commandsList.add("park KA-01-P-333 White");
        commandsList.add("park DL-12-AA-9999 White");
        commandsList.add("registration_numbers_for_cars_with_colour White");
        commandsList.add("slot_numbers_for_cars_with_colour White");
        commandsList.add("slot_number_for_registration_number KA-01-HH-3141");
        commandsList.add("slot_number_for_registration_number MH-04-AY-1111");
        return commandsList;
    }


    /**
     * Test for incorrect number of arguments
     */

    @Test
    public void testIncorrectNumberOfArgs() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        String moreThanOneArg[] = {"file_inputs.txt", "dummy"};
        parkingLotApplication.startApplication(moreThanOneArg);
        assertEquals("Incorrect number of arguments!!!. You need to either provide the filename or use the interactive shell without any arguments\n", outContent.toString());
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Test for read from File
     */
    @Test
    public void testFileMode() {
        String args[] = {"file_inputs.txt"};
        parkingLotApplication.startApplication(args);
       // System.out.println(System.getProperty("user.dir"));
    }


    /**
     * Test for interactive mode
     */
    @Test
    public void testInteractiveMode() throws UnsupportedEncodingException {
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        System.setIn(in);
        String noArgs[] = {};
        parkingLotApplication.startApplication(noArgs);
    }


    @Test
    public void emptyParkingLotSize() {
        List<String> commandsList = getCommandList();
        commandsList.get(0).replace("create_parking_lot 6", "create_parking_lot 0");

    }
}

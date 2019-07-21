package com.design;

import com.design.application.ParkingLotApplication;
import com.design.processimpl.ParkingLotProcessor;
import com.design.systeminitialization.SystemInit;
import com.design.systeminitialization.SystemInitImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void clearStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

//    public List<String> getCommandList() {
//        List<String> commandsList = new ArrayList<>();
//        commandsList.add("create_parking_lot 6");
//        commandsList.add("park KA-01-HH-1234 White");
//        commandsList.add("park KA-01-HH-9999 White");
//        commandsList.add("park KA-01-BB-0001 Black");
//        commandsList.add("park KA-01-HH-7777 Red");
//        commandsList.add("park KA-01-HH-2701 Blue");
//        commandsList.add("park KA-01-HH-3141 Black");
//        commandsList.add("leave 4");
//        commandsList.add("status");
//        commandsList.add("park KA-01-P-333 White");
//        commandsList.add("park DL-12-AA-9999 White");
//        commandsList.add("registration_numbers_for_cars_with_colour White");
//        commandsList.add("slot_numbers_for_cars_with_colour White");
//        commandsList.add("slot_number_for_registration_number KA-01-HH-3141");
//        commandsList.add("slot_number_for_registration_number MH-04-AY-1111");
//        return commandsList;
//    }


    /**
     * Test for incorrect number of arguments
     */

    @Test
    public void testIncorrectNumberOfArgs() {
//        System.setOut(originalOut);
//        System.setErr(originalErr);
        String moreThanOneArg[] = {"file_inputs.txt", "dummy"};
        parkingLotApplication.startApplication(moreThanOneArg);
        assertEquals("Incorrect number of arguments!!!. You need to either provide the filename or use the interactive shell without any arguments\n", outContent.toString());

    }

    /**
     * Test for read from File
     */
    @Test
    public void testFileMode() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        String args[] = {"file_inputs.txt"};
        parkingLotApplication.startApplication(args);
    }


    /**
     * Test for interactive mode
     */
    @Test
    public void testInteractiveMode() {
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        System.setIn(in);
        String noArgs[] = {};
        parkingLotApplication.startApplication(noArgs);
    }


    /**
     * Check for zero parking space
     */
    @Test
    public void emptyParkingLotSize() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "create_parking_lot 0");
        commandsList.add("park KA-01-HH-1234 White");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Created a parking lot with 0 slots\nSorry, parking lot is full\n", outContent.toString());

    }


    /**
     * Leave Only If Already Parked
     */
   // @Test
    public void leaveOnlyIfAlreadyParked() {
        setUpStreams();
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "create_parking_lot 0");
        commandsList.add("park KA-01-HH-1234 White");
        commandsList.add("leave 4");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Created a parking lot with 0 slots\nSorry, parking lot is full\nError : Cannot leave as there are no slots assigned\n", outContent.toString());
        clearStreams();
    }



    /**
     * n-slots, n parking
     */
    @Test
    public void nParking() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "create_parking_lot 1");
        commandsList.add("park KA-01-HH-1234 White");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Created a parking lot with 1 slots\nAllocated slot number: 1\n", outContent.toString());

    }

    /**
     * n-slots, n+1 parking
     */
   // @Test
    public void nPlusOneParking() {
        setUpStreams();
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "create_parking_lot 1");
        commandsList.add("park KA-01-HH-1234 White");
        commandsList.add("park KA-01-HH-9999 White");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Created a parking lot with 1 slots\nAllocated slot number: 1\nSorry, parking lot is full\n", outContent.toString());
        clearStreams();
    }


    /**
     * Invalid command Create Parking Lot
     */
    @Test
    public void invalidCommandCreateParkingLot() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "create_parking_lot");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Error : Invalid command\n", outContent.toString());

    }


    /**
     * Invalid command Leave
     */
    @Test
    public void invalidCommandLeave() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "leave");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Error : Invalid command\n", outContent.toString());

    }


    /**
     * Invalid command Park
     */
    @Test
    public void invalidCommandPark() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "park");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Error : Invalid command\n", outContent.toString());

    }

    /**
     * Invalid command Reg Num Car
     */
    @Test
    public void invalidRegNumCar() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "registration_numbers_for_cars_with_colour");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Error : Invalid command\n", outContent.toString());

    }


    /**
     * Invalid command Slot Num Color
     */
    @Test
    public void invalidCommandSlotNumColor() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "slot_numbers_for_cars_with_colour");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Error : Invalid command\n", outContent.toString());

    }


    /**
     * Invalid command Slot Num Regn
     */
    @Test
    public void invalidCommandSlotNumRegn() {
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "slot_number_for_registration_number");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Error : Invalid command\n", outContent.toString());

    }


    /**
     * Empty Status
     */
   // @Test
    public void emptyStatus() {
        setUpStreams();
        List<String> commandsList = new ArrayList<>();
        commandsList.add(0, "status");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Slot No.\tRegistration No\t\tColour\n", outContent.toString());
        clearStreams();
    }


    /**
     * Some Status
     */
  //  @Test
    public void someStatus() {
        setUpStreams();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("create_parking_lot 6");
        commandsList.add("park KA-01-HH-1234 White");
        commandsList.add(0, "status");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
        commandsList.stream().forEach(e -> parkingLotProcessor.startProcessing(e));
        assertEquals("Slot No.\tRegistration No\t\tColour\n" +
                "Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n", outContent.toString());
        clearStreams();
    }
}

package com.design.entity.factories;

import com.design.entity.Car;
import com.design.entity.ParkingSlot;
import com.design.utilities.ParkingLotConstants;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Park implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public Park() {
        //logger.setLevel(Level.SEVERE);
    }

    /**
     * Override execute command
     * @param command
     */

    @Override
    public void executeCommand(String command) {

        String commandsString[] = command.split(" ");
        String regnNum = commandsString[1];
        String color = commandsString[2];

        initiateParkingTask(regnNum, color);
    }


    /**
     * Initiate Parking
     * @param regnNum
     * @param color
     */

    private void initiateParkingTask(String regnNum, String color) {

        logger.log(Level.INFO, "Entering initiateParkingTask(String regnNum, String color)");
        Car car = new Car(regnNum, color);
        Integer slotNumber = computeAndAllocateFreeSlotForCar(car);

        if(slotNumber != -1)
            System.out.println("Allocated slot number: " + slotNumber);
        else
            System.out.println("Sorry, parking lot is full");

        logger.log(Level.INFO, "Exiting initiateParkingTask(String regnNum, String color)");
    }


    /**
     * Compute And Allocate Free Slot For Car
     * @param car
     */

    private Integer computeAndAllocateFreeSlotForCar(Car car) {

        logger.log(Level.INFO, "Entering computeAndAllocateFreeSlotForCar(Car car)");
        List<ParkingSlot> parkingSlotList = CreateParkingLot.getInstance().getParkingSlotList();
        for(Integer counter = 0; counter < parkingSlotList.size(); counter++) {
            ParkingSlot parkingSlot = parkingSlotList.get(counter);

            if(parkingSlot.getCar() == null){
                parkingSlot.setCar(car);
                parkingSlot.setEntryTime(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());
                logger.log(Level.INFO, "Exiting computeAndAllocateFreeSlotForCar(Car car)");
                return Integer.valueOf(parkingSlot.getId());
            }
        }
        logger.log(Level.INFO, "Exiting computeAndAllocateFreeSlotForCar(Car car)");
        return Integer.valueOf(-1);
    }
}

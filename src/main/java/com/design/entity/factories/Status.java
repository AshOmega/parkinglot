package com.design.entity.factories;

import com.design.entity.ParkingSlot;
import com.design.utilities.ParkingLotConstants;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Status implements ProcessFactory {
    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public Status() {
        //logger.setLevel(Level.SEVERE);
    }

    /**
     * Overrride executeCommand
     * @param command
     */

    @Override
    public void executeCommand(String command) {

        logger.log(Level.INFO, "Entering initiateLeavingTask(Integer slotNumber)");
        List<ParkingSlot> parkingSlotList = CreateParkingLot.getInstance().getParkingSlotList();
        displayStatus(parkingSlotList);
    }


    /**
     * Display status of parking slots with cars
     * @param parkingSlotList
     */

    private void displayStatus(List<ParkingSlot> parkingSlotList) {
        System.out.println("Slot No.\tRegistration No\t\tColour");
        parkingSlotList.stream()
                .filter(entry -> entry.getCar() != null)
                .forEach(entry -> System.out.println(entry.getId() + "\t\t\t" + entry.getCar().getRegnNumber() + "\t\t" + entry.getCar().getColor()));
    }
}

package com.design.entity.factories;

import com.design.entity.ParkingSlot;
import com.design.utilities.ParkingLotConstants;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SlotNumRegn implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public SlotNumRegn() {
        logger.setLevel(Level.SEVERE);
    }

    /**
     * Override executeCommand
     * @param command
     */

    @Override
    public void executeCommand(String command) {

        String commandsString[] = command.split(" ");
        String regn = commandsString[1];
        findSlotNumberByRegn(regn);
    }


    /**
     * Find Slot Number By Regn
     * @param regn
     */
    private void findSlotNumberByRegn(String regn) {
        List<ParkingSlot> parkingSlotList = CreateParkingLot.getInstance().getParkingSlotList();
        String slotDetails =parkingSlotList.stream()
                .filter(entry -> entry.getCar().getRegnNumber().equalsIgnoreCase(regn))
                .map(entry -> entry.getId().toString())
                .collect(Collectors.joining(", "));

        //SYS OUT
        if(!slotDetails.isEmpty())
            System.out.println(slotDetails);
        else
            System.out.println("Not found");
    }
}

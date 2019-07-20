package com.design.entity.factories;

import com.design.entity.ParkingSlot;
import com.design.processimpl.ArchiveSlotInfo;
import com.design.utilities.ParkingLotConstants;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leave implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);


    public Leave(){
        logger.setLevel(Level.SEVERE);
    }

    /**
     * Override execute command
     * @param command
     */

    @Override
    public void executeCommand(String command) {

        String commandsString[] = command.split(" ");
        String slotNumber = commandsString[1];

        initiateLeavingTask(Integer.parseInt(slotNumber));
    }


    /**
     * Initiate Leaving Task
     * @param slotNumber
     */
    private void initiateLeavingTask(Integer slotNumber) {

        logger.log(Level.INFO, "Entering initiateLeavingTask(Integer slotNumber)");
        List<ParkingSlot> parkingSlotList = CreateParkingLot.getInstance().getParkingSlotList();
        ParkingSlot parkingSlot = parkingSlotList.get(slotNumber-1);
        parkingSlot.setExitTime(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());

        //add to archive list for future reference for audits
        ArchiveSlotInfo.getInstance().addToParkingSlotArchivedList(parkingSlot);

        clearSlot(parkingSlotList, parkingSlot, slotNumber);

        //SYS OUT
        System.out.println("Slot number 4 is free");
        logger.log(Level.INFO, "Exiting initiateLeavingTask(Integer slotNumber)");
    }


    /**
     *
     * @param parkingSlotList
     * @param parkingSlot
     * @param slotNumber
     */

    private void clearSlot(List<ParkingSlot> parkingSlotList, ParkingSlot parkingSlot, Integer slotNumber) {
        logger.log(Level.INFO, "Entering clearSlot(List<ParkingSlot> parkingSlotList, ParkingSlot parkingSlot, Integer slotNumber)");
        parkingSlotList.remove(parkingSlot);
        parkingSlotList.add(slotNumber, new ParkingSlot(0L,0L, slotNumber));
        logger.log(Level.INFO, "Exiting clearSlot(List<ParkingSlot> parkingSlotList, ParkingSlot parkingSlot, Integer slotNumber)");
    }
}

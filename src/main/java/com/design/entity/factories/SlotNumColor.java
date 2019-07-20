package com.design.entity.factories;

import com.design.entity.ParkingSlot;
import com.design.utilities.ParkingLotConstants;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SlotNumColor implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public SlotNumColor() {
        logger.setLevel(Level.SEVERE);
    }

    /**
     * Override executeCommand
     * @param command
     */

    @Override
    public void executeCommand(String command) {
        String commandsString[] = command.split(" ");
        String color = commandsString[1];
        findSlotNumberByColor(color);
    }


    /**
     * Find Slot Number By Color
     * @param color
     */
    private void findSlotNumberByColor(String color) {
        List<ParkingSlot> parkingSlotList = CreateParkingLot.getInstance().getParkingSlotList();
        String slotDetails =parkingSlotList.stream()
                .filter(entry -> entry.getCar().getColor().equalsIgnoreCase(color))
                .map(entry -> entry.getId().toString())
                .collect(Collectors.joining(", "));

        //SYS OUT
        System.out.println(slotDetails);
    }
}

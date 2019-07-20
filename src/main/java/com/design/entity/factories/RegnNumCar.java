package com.design.entity.factories;

import com.design.entity.ParkingSlot;
import com.design.utilities.ParkingLotConstants;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RegnNumCar implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public RegnNumCar() {
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
        findRegistrationNumberByColor(color);
    }


    /**
     * Find Registration Number By Color
     * @param color
     */

    private void findRegistrationNumberByColor(String color) {

        List<ParkingSlot> parkingSlotList = CreateParkingLot.getInstance().getParkingSlotList();
        String registrationDetails =parkingSlotList.stream()
                .filter(entry -> entry.getCar().getColor().equalsIgnoreCase(color))
                .map(entry -> entry.getCar().getRegnNumber())
                .collect(Collectors.joining(", "));

        //SYS OUT
        System.out.println(registrationDetails);
    }
}

package com.design.entity.factories;

import com.design.entity.ParkingSlot;
import com.design.utilities.ParkingLotConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateParkingLot implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);
    private AtomicInteger parkingLotSize = new AtomicInteger();



    List<ParkingSlot> parkingSlotList = new ArrayList<>();

    public CreateParkingLot(){
        //logger.setLevel(Level.SEVERE);
    }

    /**
     * Execute command method
     * @param command
     */

    @Override
    public void executeCommand(String command) {

        String commandsString[] = command.split(" ");
        parkingLotSize.set(Integer.parseInt(commandsString[1]));
        logger.log(Level.INFO, "Initializing Parking lot size of ==> " + parkingLotSize.intValue());

        int count = 0;

        while(count++ < parkingLotSize.intValue()){
            parkingSlotList.add(new ParkingSlot(0L, 0L));
        }
    }

    /**
     * Get Parking Slots
     * @return List<ParkingSlot></ParkingSlot>
     */
    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }
}

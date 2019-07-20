package com.design.entity.factories;

import com.design.utilities.ParkingLotConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateParkingLot implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public CreateParkingLot(){
        //logger.setLevel(Level.SEVERE);
    }

    /**
     * Execute command method
     * @param command
     */

    @Override
    public void executeCommand(String command) {

    }
}

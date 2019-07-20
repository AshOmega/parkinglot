package com.design.entity.factories;

import com.design.utilities.ParkingLotConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RegnNumCar implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public RegnNumCar() {
        //logger.setLevel(Level.SEVERE);
    }

    /**
     *
     * @param command
     */

    @Override
    public void executeCommand(String command) {

    }
}

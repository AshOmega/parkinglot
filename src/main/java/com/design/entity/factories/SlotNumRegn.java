package com.design.entity.factories;

import com.design.utilities.ParkingLotConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SlotNumRegn implements ProcessFactory {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public SlotNumRegn() {
       // logger.setLevel(Level.SEVERE);
    }

    /**
     *
     * @param command
     */

    @Override
    public void executeCommand(String command) {

    }
}

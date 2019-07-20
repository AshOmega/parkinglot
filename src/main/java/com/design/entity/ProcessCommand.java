package com.design.entity;

import com.design.entity.factories.*;
import com.design.utilities.ParkingLotConstants;

public class ProcessCommand {

    private static ProcessCommand processCommand = new ProcessCommand();

    private ProcessCommand() {

    }

    /**
     * Process factory get instance
     *
     * @return ProcessCommand instance
     */
    public static ProcessCommand getInstance() {
        return processCommand;
    }

    /**
     * Get process factory
     * @param processName
     * @return ProcessFactory instance for a specific process
     */

    public ProcessFactory getProcessFactory(String processName) {

        ProcessFactory processFactory = null;

        switch (processName) {
            case ParkingLotConstants.CREATE_PARKING_LOT:
                processFactory = CreateParkingLot.getInstance();
                break;
            case ParkingLotConstants.PARK:
                processFactory = new Park();
                break;
            case ParkingLotConstants.LEAVE:
                processFactory = new Leave();
                break;
            case ParkingLotConstants.STATUS:
                processFactory = new Status();
                break;
            case ParkingLotConstants.REGN_NO_CAR_WITH_COLOR:
                processFactory = new RegnNumCar();
                break;
            case ParkingLotConstants.SLOT_NO_CAR_WITH_COLOR:
                processFactory = new SlotNumColor();
                break;
            case ParkingLotConstants.SLOT_NO_FOR_REGN:
                processFactory = new SlotNumRegn();
                break;
            default:
                processFactory = null;
        }

        return processFactory;
    }
}

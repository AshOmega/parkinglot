package com.design.processimpl;

import com.design.entity.ProcessCommand;
import com.design.entity.factories.ProcessFactory;

public class ParkingLotProcessor {

    /**
     * Start command processing
     * @param command
     */

    public void startProcessing(String command){
        //System.out.println(command);

        //the first array element denotes the process to be executed
        String processName = command.split(" ")[0];

        //get the relevant process factory instance
        ProcessFactory processFactory = ProcessCommand.getInstance().getProcessFactory(processName);

       // System.out.println(processFactory.getClass().getName());

    }
}

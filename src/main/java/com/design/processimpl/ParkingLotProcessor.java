package com.design.processimpl;

import com.design.entity.ProcessCommand;
import com.design.entity.factories.ProcessFactory;
import com.design.utilities.ParkingLotConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingLotProcessor {

    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public ParkingLotProcessor(){
       // logger.setLevel(Level.SEVERE);
    }


    /**
     * Start command processing
     * @param command
     */

    public void startProcessing(String command){
        //System.out.println(command);

        //the first array element denotes the process to be executed
        String processName = command.split(" ")[0];
        logger.log(Level.INFO, "Start processing command ==> " + processName);

        //get the relevant process factory instance
        ProcessFactory processFactory = ProcessCommand.getInstance().getProcessFactory(processName);

        if(processFactory != null)
            processFactory.executeCommand(command);
        else
            System.out.println("Error : Invalid command. Use the commands that are allowed. Refer documentation for more info");
    }
}

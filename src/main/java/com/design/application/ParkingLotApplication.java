package com.design.application;

import com.design.systeminitialization.SystemInit;
import com.design.systeminitialization.SystemInitImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingLotApplication {
    final static Logger logger = Logger.getLogger("ParkingLotApplication");

    public static void main(String args[]){

        SystemInit systemInit = new SystemInitImpl();

        //Interactive mode
        if(args.length == 0){
            logger.info("Interactive mode");
            systemInit.initializeSystem();

        }
        // File processing mode
        else if(args.length == 1){
            logger.info("File processing mode");
            //systemInit.initializeSystem(args[0]); //fix path according to actual spec requirements
            systemInit.initializeSystem("/Users/i327143/IdeaProjects/parkinglot/src/main/resources/file_inputs.txt");
        }
        else
        {
            logger.log(Level.SEVERE, "Incorrect number of arguments!!!. You need to either provide the filename or use the interactive " +
                    "shell without any arguments");
        }
    }
}

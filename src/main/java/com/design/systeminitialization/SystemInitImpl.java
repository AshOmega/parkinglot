package com.design.systeminitialization;

import com.design.processimpl.ParkingLotProcessor;
import com.design.utilities.FileReaderUtil;
import com.design.utilities.ParkingLotConstants;
import com.design.utilities.ScannerUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemInitImpl implements SystemInit {
    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);

    public SystemInitImpl() {
        //logger.setLevel(Level.SEVERE);
    }


    /**
     * Initialize for File processing
     *
     * @param fileName
     */

    @Override
    public void initializeSystem(String fileName) {
        logger.log(Level.INFO, "Initializing System for File Processing");
        List<String> inputCommandsList = FileReaderUtil.getInstance().readFromFile(fileName);
        inputCommandsList.forEach(entry -> new ParkingLotProcessor().startProcessing(entry));
    }


    /**
     * Initialize for interactive mode
     */

    @Override
    public void initializeSystem() {

        logger.log(Level.INFO, "Initializing System for Interactive mode");
        ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();

        String inputString = null;
        do {
            try {
                inputString = ScannerUtil.getInstance().readInput();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Exception encountered ", ex);
            }
            if (!inputString.equalsIgnoreCase("exit"))
                parkingLotProcessor.startProcessing(inputString);
        }
        while (!inputString.equalsIgnoreCase("exit"));


    }
}

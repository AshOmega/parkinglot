package application;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingLotApplication {
    final static Logger logger = Logger.getLogger("ParkingLotApplication");

    public static void main(String args[]){

        if(args.length == 0){
            logger.info("Interactive mode");

        }
        else if(args.length == 1){
            logger.info("File processing mode");

        }
        else
        {
            logger.log(Level.SEVERE, "Incorrect number of arguments!!!. You need to either provide the filename or use the interactive " +
                    "shell without any arguments");
        }
    }
}

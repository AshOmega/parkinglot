package com.design.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileReaderUtil {


    private static FileReaderUtil fileReaderUtil = new FileReaderUtil();
    final static Logger logger = Logger.getLogger(ParkingLotConstants.APP_NAME);
    private FileReaderUtil(){

    }

    /**
     * Singleton instance of FileReaderUtil
     * @return instance
     *
     */
    public static FileReaderUtil getInstance(){
        return fileReaderUtil;
    }


    /**
     * Read from file
     * @param - fileName
     * @return - List<String> (commands to be executed sequentially.)
     *
     */

    public List<String> readFromFile(String fileName){

        List<String> fileContentAsList = new LinkedList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(fileContentAsList::add);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Exception triggered", e);
        }

        return fileContentAsList;
    }
}

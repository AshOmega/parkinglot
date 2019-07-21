package com.design.utilities;

import com.design.application.ParkingLotApplication;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    public List<String> readFromFile(String fileName) throws UnsupportedEncodingException {

        //Extension to prepend the directory path to the file as the applcation is invoked with the relative path of file.
        //Hence we need to fetch the absolute path for processing
        String path = ParkingLotApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath = URLDecoder.decode(path, "UTF-8");
        decodedPath = decodedPath.substring(0, decodedPath.lastIndexOf('/'));
        fileName = decodedPath + "/" + fileName;

        System.out.println(fileName);
        List<String> fileContentAsList = new LinkedList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(fileContentAsList::add);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Exception triggered while reading input file", e);
        }

        return fileContentAsList;
    }
}

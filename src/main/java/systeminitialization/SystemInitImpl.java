package systeminitialization;

import processimpl.ParkingLotProcessor;
import utilities.FileReaderUtil;

import java.util.List;

public class SystemInitImpl implements SystemInit{

    /**
     * Initialize for File processing
     * @param fileName
     */
    @Override
    public void initializeSystem(String fileName) {

        List<String> inputCommandsList = FileReaderUtil.getInstance().readFromFile(fileName);
        inputCommandsList.forEach(entry -> new ParkingLotProcessor().startProcessing(entry));
    }

    /**
     * Initialize for interactive mode
     */
    @Override
    public void initializeSystem() {

    }
}

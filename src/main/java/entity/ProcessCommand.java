package entity;

public class ProcessCommand {

    public static ProcessCommand processCommand = new ProcessCommand();

    private ProcessCommand(){

    }

    /**
     * Process factory get instance
     * @return ProcessCommand instance
     */
    public static ProcessCommand getInstance(){
        return processCommand;
    }


    public static void getProcessFactory(String processName){

    }


}

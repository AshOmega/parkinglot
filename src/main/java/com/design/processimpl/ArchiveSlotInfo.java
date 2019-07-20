package com.design.processimpl;

import com.design.entity.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ArchiveSlotInfo {

    private static ArchiveSlotInfo archiveSlotInfo = new ArchiveSlotInfo();
    List<ParkingSlot> parkingSlotArchivedList = new ArrayList<>();

    private ArchiveSlotInfo(){

    }


    /**
     * Get instance for ArchiveSlotInfo
     * @return ArchiveSlotInfo
     */

    public static ArchiveSlotInfo getInstance(){
        return archiveSlotInfo;
    }


    /**
     * Getter method
     * @return List<ParkingSlot>
     */

    public List<ParkingSlot> getParkingSlotArchivedList() {
        return parkingSlotArchivedList;
    }


    /**
     * Add to parking slot archived list
     * @param parkingSlot
     */

    public void addToParkingSlotArchivedList(ParkingSlot parkingSlot) {
        parkingSlotArchivedList.add(parkingSlot);
        //parkingSlotArchivedList.stream().forEach(entry -> System.out.println(entry));
    }
}

package com.design.entity;

public class ParkingSlot {

    private Long entryTime;
    private Long exitTime;
    private Car car;

    public ParkingSlot(Long entryTime, Long exitTime) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Long entryTime) {
        this.entryTime = entryTime;
    }

    public Long getExitTime() {
        return exitTime;
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = exitTime;
    }

    public Car getCar() {
        return car;
    }

}

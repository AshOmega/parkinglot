package com.design.entity;

public class ParkingSlot {

    private Integer id;
    private Long entryTime;
    private Long exitTime;


    private Car car;

    public ParkingSlot(Long entryTime, Long exitTime, Integer id) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.id = id;
        this.car = null;
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

    public Integer getId() {
        return id;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

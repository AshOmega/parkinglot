package entity;

public class ParkingLot {

    private Long entryTime;
    private Long exitTime;
    private Car car;

    public ParkingLot(Long entryTime, Long exitTime, Car car) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.car = car;
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

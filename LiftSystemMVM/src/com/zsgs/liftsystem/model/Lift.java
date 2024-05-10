package com.zsgs.liftsystem.model;

public class Lift {
    private int currentFloor;
    private int destinationFloor;
    private int capacity;

    private int[] accessibleFloors;

    private int lowestAccess;
    private int highestAccess;

    private boolean isUnderMaintanance;

    public Lift(int lowestAccess, int highestAccess, int capacity, boolean isUnderMaintanance) {
        this.lowestAccess = lowestAccess;
        this.highestAccess = highestAccess;

        if(lowestAccess == 1 && highestAccess == 10) {
            accessibleFloors = new int[11];
            int ptr = lowestAccess;
            for(int i = 1; i < 11; i++) {
                accessibleFloors[i] = ptr;
                ptr++;
            }
        } else {
            accessibleFloors = new int[6];
            int ptr = lowestAccess;
            for(int i = 1; i < 6; i++) {
                accessibleFloors[i] = ptr;
                ptr++;
            }
        }

        this.capacity = capacity;
        this.isUnderMaintanance = isUnderMaintanance;
        if(isUnderMaintanance) {
            setCurrentFloor(-1);
        }
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getLowestAccess() {
        return lowestAccess;
    }

    public int getHighestAccess() {
        return highestAccess;
    }

    public int[] getAccessibleFloors() {
        return accessibleFloors;
    }

    public void setIsUnderMaintenance() {
        isUnderMaintanance = true;
        setCurrentFloor(-1);
    }
}

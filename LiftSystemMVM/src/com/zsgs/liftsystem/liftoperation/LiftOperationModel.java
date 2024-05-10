package com.zsgs.liftsystem.liftoperation;

import com.zsgs.liftsystem.model.Lift;

import java.util.Scanner;
import java.util.Arrays;

public class LiftOperationModel {
    static Scanner sc = new Scanner(System.in);
    private LiftOperationView liftOperationView;

    public LiftOperationModel(LiftOperationView liftOperationView) {
        this.liftOperationView = liftOperationView;
    }

    public void liftDetails(Lift[] lifts) {
        for (int i = 0; i < 5; i++) {
            System.out.print("L" + (i + 1) + ": " + "current floor: " + lifts[i].getCurrentFloor());
            System.out.print(" Access: " + lifts[i].getLowestAccess() + " to " + lifts[i].getHighestAccess());
            System.out.println(" " + Arrays.toString(lifts[i].getAccessibleFloors()));
        }
    }

    public void assignLift(Lift[] lifts) {
        System.out.print("Enter the current floor: ");
        int curr = sc.nextByte();
        System.out.print("Enter the destination floor(1-10): ");
        int dest = sc.nextByte();

        if (dest < 1 || dest > 10 || curr < 1 || curr > 10) {
            System.out.println("Invalid input.");
            System.exit(0);
        } else {
            System.out.println("L1 is assigned.");
            lifts[0].setCurrentFloor(dest);
            lifts[0].setDestinationFloor(dest);
            liftDetails(lifts);
        }

    }

    public void assignNearest(Lift[] lifts) {
        System.out.print("Enter the current floor: ");
        int curr = sc.nextByte();
        System.out.print("Enter the destination floor(1-10): ");
        int dest = sc.nextByte();

        if (dest < 1 || dest > 10 || curr < 1 || curr > 10) {
            System.out.println("Invalid input.");
            System.exit(0);
        } else {
            int min = 1000;
            int nearestLift = -1;
            for (int i = 0; i < 5; i++) {
                if (lifts[i].getCurrentFloor() != -1 && Math.abs(lifts[i].getCurrentFloor() - curr) < min) {
                    min = Math.abs(lifts[i].getCurrentFloor() - curr);
                    nearestLift = i;
                }
            }
            System.out.println("L" + (nearestLift + 1) + " is assigned.");
            lifts[nearestLift].setDestinationFloor(dest);
            lifts[nearestLift].setCurrentFloor(dest);
            liftDetails(lifts);
        }
    }

    public void assignSameDirection(Lift[] lifts) {
        System.out.print("Enter the current floor: ");
        int curr = sc.nextByte();
        System.out.print("Enter the destination floor(1-10): ");
        int dest = sc.nextByte();

        boolean goDown = curr > dest;

        int min = 1000;
        int nearestLift = -1;

        for (int i = 0; i < 5; i++) {
            if (lifts[i].getCurrentFloor() != -1 && Math.abs(lifts[i].getCurrentFloor() - curr) < min) {
                min = Math.abs(lifts[i].getCurrentFloor() - curr);
                nearestLift = i;
            }
            if (lifts[i].getCurrentFloor() != -1 && Math.abs(lifts[i].getCurrentFloor() - curr) == min) {
                if (goDown) {
                    min = Math.abs(lifts[i].getCurrentFloor() - curr);
                    nearestLift = i;
                } else {
                    continue;
                }
            }
        }

        System.out.println("L" + (nearestLift + 1) + " is assigned.");
        lifts[nearestLift].setDestinationFloor(dest);
        lifts[nearestLift].setCurrentFloor(dest);
        liftDetails(lifts);
    }

    public void assignLeastStop(Lift[] lifts) {
        System.out.print("Enter the current floor: ");
        int curr = sc.nextByte();
        System.out.print("Enter the destination floor(1-10): ");
        int dest = sc.nextByte();

        if (dest < 1 || dest > 10 || curr < 1 || curr > 10) {
            System.out.println("Invalid input.");
            System.exit(0);
        } else {
            int minStops = Integer.MAX_VALUE;
            int nearestLift = -1;

            for (int i = 0; i < 5; i++) {
                if (lifts[i].getCurrentFloor() != -1) {
                    int stops = calculateStops(lifts[i], curr, dest);
                    if (stops < minStops) {
                        minStops = stops;
                        nearestLift = i;
                    }
                }
            }

            System.out.println("L" + (nearestLift + 1) + " is assigned.");
            lifts[nearestLift].setCurrentFloor(dest);
            lifts[nearestLift].setDestinationFloor(dest);
            liftDetails(lifts);
        }
    }

    private int calculateStops(Lift lift, int currentFloor, int targetFloor) {
        int stops = 0;
        int current = currentFloor;

        for (int floor : lift.getAccessibleFloors()) {
            if (current < floor && targetFloor >= floor) {
                stops++;
            } else if (current > floor && targetFloor <= floor) {
                stops++;
            }
            current = floor;
        }
        return stops;
    }

    public void setAsUnderMaintanance(Lift[] lifts) {
        System.out.print("Enter the lift number to set it under maintanence(1 to 5): ");
        int liftNumber = sc.nextInt();

        lifts[liftNumber - 1].setIsUnderMaintenance();
        System.out.println("L" + liftNumber + " has been sent to maintanence successfully.");
    }

}

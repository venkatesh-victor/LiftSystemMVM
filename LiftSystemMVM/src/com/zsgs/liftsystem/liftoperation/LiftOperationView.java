package com.zsgs.liftsystem.liftoperation;

import com.zsgs.liftsystem.main.LiftSystem;
import com.zsgs.liftsystem.model.Lift;

import java.util.Scanner;

public class LiftOperationView {
    static Scanner sc = new Scanner(System.in);

    public LiftOperationModel liftOperationModel;

    public LiftOperationView() {
        liftOperationModel = new LiftOperationModel(this);
    }

    public void init() {
        Lift[] lifts = new Lift[5];

//      for (int i = 0; i < 5; i++) {
//          if (i <= 1) {
//              lifts[i] = new Lift("lower");
//          } else if (i > 1 && i <= 3) {
//              lifts[i] = new Lift("upper");
//          } else {
//              lifts[i] = new Lift("all");
//          }
//      }

        lifts[0] = new Lift(1, 5, 8, false);
        lifts[1] = new Lift(1, 5, 10, false);
        lifts[2] = new Lift(6, 10, 8, false);
        lifts[3] = new Lift(6, 10, 10, false);
        lifts[4] = new Lift(1, 10, 10, false);

        //LiftFunctions.liftDetails(lifts);
        //LiftFunctions.assignLift(lifts);
        //LiftFunctions.assignNearest(lifts);
        //LiftFunctions.assignSameDirection(lifts);
        //LiftFunctions.assignLeastStop(lifts);

        System.out.println("--- " + LiftSystem.getInstance().getAppName() + " ---");
        System.out.println("Version - " + LiftSystem.getInstance().getAppVersion());

        while (true) {
            System.out.println("\n---------- Lift services ----------\n");
            System.out.println("1. Assign Lift. \n2.Set a lift as under maintenance. \n3.Show lift details. \n4.Exit ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    liftOperationModel.assignNearest(lifts);
                    break;
                case 2:
                    liftOperationModel.setAsUnderMaintanance(lifts);
                    break;
                case 3:
                    liftOperationModel.liftDetails(lifts);
                    break;
                case 4:
                    System.out.println("---Thank you---");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}













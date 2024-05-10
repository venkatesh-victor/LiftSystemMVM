package com.zsgs.liftsystem.main;

import com.zsgs.liftsystem.liftoperation.*;

import java.util.Scanner;

public class LiftSystem {
    static Scanner sc = new Scanner(System.in);
    private static LiftSystem liftSystem;
    private String appName = "Lift System";
    private String appVersion = "0.1.0";

    public static LiftSystem getInstance() {
        if (liftSystem == null) {
            liftSystem = new LiftSystem();
        }

        return liftSystem;
    }

    private void create() {
        LiftOperationView liftOperationView = new LiftOperationView();
        liftOperationView.init();
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public static void main(String[] args) {
        LiftSystem.getInstance().create();
    }
}

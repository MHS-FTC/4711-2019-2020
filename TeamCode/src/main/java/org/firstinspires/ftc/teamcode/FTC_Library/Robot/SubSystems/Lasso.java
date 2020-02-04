package org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.SubSystem;

public class Lasso extends SubSystem {

    private String lassoName;
    private String holdName;

    private Servo lasso;
    private Servo hold;





    @Override
    public boolean init(HardwareMap hardwareDevices) {

        lasso = hardwareDevices.servo.get(lassoName);


        hold = hardwareDevices.servo.get(holdName);


        return true;
    }

    public Lasso setDeviceNames(String lasso, String hold) {
        lassoName = lasso;
        holdName = hold;

        return this;

    }


    public void lassoUp() {

        lasso.setPosition(0);

    }
    public void lassoDown() {

        lasso.setPosition(1);

    }

    public void blockGrab() {

        hold.setPosition(0);


    }
    public void blockRealese() {

        hold.setPosition(1);


    }

}

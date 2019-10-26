package org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

//import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.SubSystem;

public class Lifter extends SubSystem {

    private String liftName;
    private String handName;

    private DcMotor lift;
    private Servo hand;

    private final double LIFT_SPEED = 1;




    @Override
    public boolean init(HardwareMap hardwareDevices) {

        lift = hardwareDevices.dcMotor.get(liftName);

        hand = hardwareDevices.servo.get(handName);


        return true;
    }

    public Lifter setDeviceNames(String lift, String hand) {
        liftName = lift;
        handName = hand;
        return this;

    }

    public void liftUp() {

            lift.setPower(LIFT_SPEED);

    }

    public void liftDown() {
        lift.setPower(-LIFT_SPEED);
    }

    //kind of an artificial stop designed to work for hanging
    public void liftStop() {
        lift.setPower(0);

    }
    public void handUp() {

        hand.setPosition(0);

    }
    public void handDown() {

        hand.setPosition(1);

    }


    public DcMotor getMotor() {
        return lift;
    }
}
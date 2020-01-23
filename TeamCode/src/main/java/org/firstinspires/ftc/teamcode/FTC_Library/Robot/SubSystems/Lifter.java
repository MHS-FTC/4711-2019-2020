package org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.SubSystem;

public class Lifter extends SubSystem {

    private String liftName;
    private String handName;
    private String rotateName;
    private String trayMoverName;

    private double rotatePos = 0;

    private DcMotor lift;
    private Servo hand;
    private DcMotor rotate;
    private Servo trayMover;


    private final double LIFT_SPEED = 1;

    private final int TARGETING_DEADZONE = 1;
    private final int TARGET_DIFF = 55;//change target by this amount each time if not on target
    private final int MANUAL_TARGET_DIFF = TARGET_DIFF - 3;

    private double ARM_UP_TARGETING_DIFFERENCE = 2;// this is in motor rotations and multiplied in 'init' by encoder ticks per rev
    private double armTargetPosition = 0;
    private int armDownLocation = 0;
    private int armUpLocation = 0;




    @Override
    public boolean init(HardwareMap hardwareDevices) {

        lift = hardwareDevices.dcMotor.get(liftName);

        hand = hardwareDevices.servo.get(handName);

        rotate = hardwareDevices.dcMotor.get(rotateName);

        trayMover = hardwareDevices.servo.get(trayMoverName);

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        return true;
    }

    public Lifter setDeviceNames(String lift, String hand, String rotate, String trayMover) {
        liftName = lift;
        handName = hand;
        rotateName = rotate;
        trayMoverName = trayMover;
        return this;

    }

    public void liftUp() {

            armTargetPosition = lift.getCurrentPosition();
            armTargetPosition += 1;
            lift.setPower(0.5);
            lift.setTargetPosition((int) armTargetPosition);


    }

    public void liftDown() {

        armTargetPosition = lift.getCurrentPosition();
        armTargetPosition -= 1;
        lift.setPower(-0.5);
        lift.setTargetPosition((int) armTargetPosition);
    }

    //kind of an artificial stop designed to work for hanging
    public void liftStop() {
        lift.setTargetPosition(lift.getCurrentPosition());
        lift.setPower(0);
    }
    public void handUp() {

        hand.setPosition(rotatePos);
        rotatePos += 0.05;
    }
    public void handDown() {

        hand.setPosition(rotatePos);
        rotatePos -= 0.05;
    }

    public void trayGrab() {

        trayMover.setPosition(0);

    }
    public void trayRealese() {

        trayMover.setPosition(1);

    }

    public void rotateOut() {

        rotate.setPower(0.2);

    }

    public void rotateIn() {

        rotate.setPower(-0.2);

    }

    public void rotateStop() {

        rotate.setPower(0);
    }

    public DcMotor getMotor() {
        return lift;
    }
    public Servo getHand() {
        return hand;
    }

    public DcMotor getRotate() {
        return rotate;
    }
}


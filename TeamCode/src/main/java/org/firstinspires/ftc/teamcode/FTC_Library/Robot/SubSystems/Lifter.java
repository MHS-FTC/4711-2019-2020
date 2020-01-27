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

    private long stoppedTime;
    private final int STOP_WAIT = 200;//wait before engaging positioning


    private final double LIFT_SPEED = 1;






    @Override
    public boolean init(HardwareMap hardwareDevices) {



        hand = hardwareDevices.servo.get(handName);

        rotate = hardwareDevices.dcMotor.get(rotateName);

        trayMover = hardwareDevices.servo.get(trayMoverName);

        lift = hardwareDevices.dcMotor.get(liftName);

       // lift.setDirection(DcMotorSimple.Direction.REVERSE);

       lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setTargetPosition(0);
       lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       // lift.setPower(0.1);//this should be enough power to keep motor at the correct position

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

        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setPower(LIFT_SPEED);


    }

    public void liftDown() {

        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setPower(-LIFT_SPEED);
    }

    //kind of an artificial stop designed to work for hanging
    public void liftStop() {
        if (lift.getPower() != 0.1 && lift.getPower() != 0) {
            lift.setPower(0);
            stoppedTime = System.currentTimeMillis();
        }
        if (stoppedTime + STOP_WAIT < System.currentTimeMillis()) {//if has stopped

            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setTargetPosition(lift.getCurrentPosition());

            lift.setPower(0.1);//this should be enough power to keep motor at the correct position
        }
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


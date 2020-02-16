package org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.SubSystem;

public class Lifter extends SubSystem {

    private String liftName;
    private String handName;

    private String trayMover1Name;
    private String trayMover2Name;

    private String capName;

    private DcMotor lift;
    private Servo hand;

    private Servo cap;

    private Servo trayMover1;
    private Servo trayMover2;

    private long stoppedTime;
    private final int STOP_WAIT = 200;//wait before engaging positioning


    private final double LIFT_SPEED = 1;



    @Override
    public boolean init(HardwareMap hardwareDevices) {



        hand = hardwareDevices.servo.get(handName);

       // rotate = hardwareDevices.dcMotor.get(rotateName);

        trayMover1 = hardwareDevices.servo.get(trayMover1Name);
        trayMover2 = hardwareDevices.servo.get(trayMover2Name);
        cap = hardwareDevices.servo.get(capName);

        lift = hardwareDevices.dcMotor.get(liftName);

       // lift.setDirection(DcMotorSimple.Direction.REVERSE);

       lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setTargetPosition(1);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setPower(0.1);//this should be enough power to keep motor at the correct position

        // lift.setPower(0.1);//this should be enough power to keep motor at the correct position

        return true;
    }

    public Lifter setDeviceNames(String lift, String hand, String trayMover1, String trayMover2, String cap) {
        liftName = lift;
        handName = hand;
        capName = cap;
       // rotateName = rotate;
        trayMover1Name = trayMover1;
        trayMover2Name = trayMover2;
        return this;

    }

    public void liftUp() {

       lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setPower(LIFT_SPEED);


    }

    public void liftDown() {

        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setPower(-LIFT_SPEED);
       /* if(lift.getCurrentPosition() <= 1 ){
            liftStop();
        } */
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


            lift.setPower(-0.1);//this should be enough power to keep motor at the correct position
        }
    }
    public void handUp() {

        hand.setPosition(1);

    }
    public void handDown() {

        hand.setPosition(0);

    }

    public void trayGrab() {

        trayMover1.setPosition(0);
        trayMover2.setPosition(1);

    }
    public void trayRealese() {

        trayMover1.setPosition(.9);
        trayMover2.setPosition(.1);

    }
    public void capIn(){

        cap.setPosition(1);
    }

    public void capOut(){
        cap.setPosition(0.45);
    }

    public DcMotor getMotor() {
        return lift;
    }
    public Servo getHand() {
        return hand;
    }


}



package org.firstinspires.ftc.teamcode.FTC_Library.Robot.TestBotTeleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTC_Library.Robot.Robot;

@TeleOp(name = "MAIN Teleop")
public class TestBotTeleop extends OpMode {
    Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

        robot.drive.driveMecanum(gamepad1.left_stick_y, -gamepad1.right_stick_x, -gamepad1.left_stick_x);

        if (gamepad1.b) {
            robot.lifter.handUp();
        }
       else if(gamepad1.a){
            robot.lifter.handDown();
        }

       if (gamepad2.a) {
            robot.lifter.capIn();
        }
        else if(gamepad2.b){
            robot.lifter.capOut();
        }

        if (gamepad1.y) {
            robot.tapeMeasure.tapeIn();
        }
        else if(gamepad1.x){
            robot.tapeMeasure.tapeOut();
        }
        else {
            robot.tapeMeasure.tapeHold();
        }



        if (gamepad1.dpad_down) { // servo down
            robot.lifter.trayGrab();
        }
        else if(gamepad1.dpad_up){ //servos up
            robot.lifter.trayRealese();
        }

        if (gamepad2.x) {
            robot.lassieBoy.lassoUp();
        }
        else if(gamepad2.y){
            robot.lassieBoy.lassoDown();
        }
       /* if (gamepad1.x) {
            robot.lassieBoy.blockGrab();
        }
        else if(gamepad1.y){
            robot.lassieBoy.blockRealese();
        }
       */
        if (gamepad2.dpad_up) {
            robot.extender.rotateOut();
        }
        else if(gamepad2.dpad_down){
            robot.extender.rotateIn();
        }
       else{
           robot.extender.rotateStop();
        }

        if (gamepad1.left_bumper){
            robot.intake.intakeIn();
        }

       else if (gamepad1.right_bumper){
            robot.intake.intakeOut();
       }
       else{
            robot.intake.intakeStop();
        }

        if (gamepad2.left_bumper){
            robot.lifter.liftUp();

        }
        else if (gamepad2.right_bumper){
            robot.lifter.liftDown();
        }
        else {
            robot.lifter.liftStop();

        }


    }
}
//michael is objectively attractive ~ faith 2019
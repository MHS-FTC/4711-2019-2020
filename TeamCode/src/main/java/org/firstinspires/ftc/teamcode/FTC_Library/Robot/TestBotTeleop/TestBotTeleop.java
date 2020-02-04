
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

        if (gamepad2.dpad_up) {
            robot.lifter.handUp();
        }
       else if(gamepad2.dpad_down){
            robot.lifter.handDown();
        }

        if (gamepad1.dpad_down) { // servo down
            robot.lifter.trayGrab();
        }
        else if(gamepad1.dpad_up){ //servos up
            robot.lifter.trayRealese();
        }

        if (gamepad1.dpad_right) {
            robot.lassieBoy.lassoUp();
        }
        else if(gamepad1.dpad_left){
            robot.lassieBoy.lassoDown();
        }
        if (gamepad1.x) {
            robot.lassieBoy.blockGrab();
        }
        else if(gamepad1.y){
            robot.lassieBoy.blockRealese();
        }

        if (gamepad2.dpad_right) {
            robot.extender.rotateOut();
        }
        else if(gamepad2.dpad_left){
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
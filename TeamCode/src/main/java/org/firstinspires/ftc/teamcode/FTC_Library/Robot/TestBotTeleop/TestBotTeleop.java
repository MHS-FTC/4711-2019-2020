
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

        if (gamepad1.dpad_up) {
            robot.lifter.handUp();
        }
       else if(gamepad1.dpad_down){
            robot.lifter.handDown();
        }

       if (gamepad1.left_bumper){
           robot.lifter.liftUp();
       }
       else if (gamepad1.right_bumper){
           robot.lifter.liftDown();
       }
       else {
           robot.lifter.liftStop();
        }


    }
}
//michael is objectively attractive ~ faith 2019
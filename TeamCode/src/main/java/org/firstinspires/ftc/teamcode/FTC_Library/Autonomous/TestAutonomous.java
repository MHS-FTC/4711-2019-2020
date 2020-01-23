package org.firstinspires.ftc.teamcode.FTC_Library.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.FTC_Library.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.FTC_Library.Autonomous.Modules.Premade.DriveTime;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.Robot;

/**
 * Created by Ethan Hampton on 8/19/17.
 * Example Autonomous
 */
@Disabled
@Autonomous(name = "Test Autonomous")
public class TestAutonomous extends AutonomousBase {
    Robot robot = new Robot();
    private final Module[][] steps = new Module[][]{
            {new DriveTime().setSpeeds(1, 1).setTime(2000)},
           // {new FoundationLock()},
            {new DriveTime().setSpeeds(-0.5, -0.9).setTime(2000)},
            {new DriveTime().setSpeeds(1, 1).setTime(2000)},
            {new DriveTime().setSpeeds(-1, -1).setTime(2000)},
           // {new CallFunction().setFunction(() -> robot.drive.drive(1, 1))},
           // {new CallFunction().setFunction(() -> robot.drive.drive(0, 0))},

            //choose next step
           // {new RandomMultiPossibility()},
           // {new DriveTime().setSpeeds(1, 1).setTime(2500), new DriveTime().setSpeeds(0.5, 1).setTime(500)},
    };

    @Override
    public void init() {
        init(hardwareMap, robot, steps);
    }

    @Override
    public void tick() {
        telemetry.addLine("Wow this works!");
    }
}

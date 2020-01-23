package org.firstinspires.ftc.teamcode.FTC_Library.Robot;

import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.Intake;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.Lifter;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.MechanumDriveSubsystem;


public class Robot extends RobotBase {

    public Intake intake = new Intake().setDeviceNames("Intake");
    public Lifter lifter = new Lifter().setDeviceNames("lifter", "hand","rotate", "trayMover");
    public MechanumDriveSubsystem drive = new MechanumDriveSubsystem().setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");




    public Robot() {

        addSubSystem(lifter);
        addSubSystem(drive);
        addSubSystem(intake);
    }

}

// I just really want to see you guys kiss ~ faith 2019
package org.firstinspires.ftc.teamcode.FTC_Library.Robot;

import org.firstinspires.ftc.teamcode.FTC_Library.Autonomous.Modules.Premade.PIDEncoderDrive;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.RobotBase;

import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.Lifter;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.MechanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.intake;


public class Robot extends RobotBase {

    public intake intake = new intake().setDeviceNames("intake");
    public Lifter lifter = new Lifter().setDeviceNames("lifter", "hand");
    public MechanumDriveSubsystem drive = new MechanumDriveSubsystem().setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");
  //  public ElementFling fling = null;//for programs



    public Robot() {

        addSubSystem(lifter);
        addSubSystem(drive);
        addSubSystem(intake);
    }

}
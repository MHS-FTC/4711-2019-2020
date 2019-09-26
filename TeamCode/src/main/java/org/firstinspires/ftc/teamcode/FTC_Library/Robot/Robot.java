package org.firstinspires.ftc.teamcode.FTC_Library.Robot;

import org.firstinspires.ftc.teamcode.FTC_Library.Autonomous.Modules.Premade.PIDEncoderDrive;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.RobotBase;

import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.Lifter;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.MechanumDriveSubsystem;


public class Robot extends RobotBase {

 //   public Intake intake = new Intake().setMotorNames("arm", "lock", "release", "intake").setLimitName("armLimit");
    public Lifter lifter = new Lifter().setDeviceNames("lifter", "hand");
    public MechanumDriveSubsystem drive = new MechanumDriveSubsystem().setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");
  //  public ElementFling fling = null;//for programs



    public Robot() {

        addSubSystem(lifter);
        addSubSystem(drive);
       // addSubSystem(intake);
    }

}
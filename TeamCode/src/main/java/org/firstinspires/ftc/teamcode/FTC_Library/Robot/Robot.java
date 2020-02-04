package org.firstinspires.ftc.teamcode.FTC_Library.Robot;

import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.Intake;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.Lasso;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.Lifter;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.MechanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.clawExtender;


public class Robot extends RobotBase {

    public Intake intake = new Intake().setDeviceNames("Intake");
    public Lasso lassieBoy = new Lasso().setDeviceNames("lasso", "hold");
    public Lifter lifter = new Lifter().setDeviceNames("lifter", "hand", "trayMover1", "trayMover2");
    public MechanumDriveSubsystem drive = new MechanumDriveSubsystem().setMotorNames("leftFront", "rightFront", "leftBack", "rightBack");
    public clawExtender extender = new clawExtender().setDeviceNames("rotate");



    public Robot() {

        addSubSystem(lifter);
        addSubSystem(lassieBoy);
        addSubSystem(drive);
        addSubSystem(intake);
        addSubSystem(extender);
    }

}

// I just really want to see you guys kiss ~ faith 2019
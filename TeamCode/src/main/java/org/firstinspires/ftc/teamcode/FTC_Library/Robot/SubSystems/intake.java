package org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

//import org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems.SubSystem;

public class intake extends SubSystem {

    private String intakeName;

    private DcMotor intake;

    private final double INTAKE_SPEED = 1;


    @Override
    public boolean init(HardwareMap hardwareDevices) {

        intake = hardwareDevices.dcMotor.get(intakeName);

        return true;
    }

    public intake setDeviceNames(String intake) {
        intakeName = intake;

        return this;

    }

    public void intakeIn() {

        intake.setPower(INTAKE_SPEED);

    }

    public void intakeOut() {
        intake.setPower(-INTAKE_SPEED);
    }

    //kind of an artificial stop designed to work for hanging

    public void intakeStop() {
        intake.setPower(0);

    }



    public DcMotor getMotor() {
        return intake;
    }
}
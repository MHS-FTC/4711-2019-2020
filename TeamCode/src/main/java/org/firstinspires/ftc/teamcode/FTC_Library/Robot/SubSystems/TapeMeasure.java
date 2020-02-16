package org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TapeMeasure extends SubSystem {
    private String tapeName;

    private DcMotor tape;

    @Override
    public boolean init(HardwareMap hardwareDevices) {

        tape = hardwareDevices.dcMotor.get(tapeName);
        tape.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tape.setTargetPosition(1);

        return true;
    }

    public TapeMeasure setDeviceNames(String tape) {
        tapeName = tape;


        return this;

    }


    public void tapeOut() {
        tape.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tape.setPower(1);

        if (tape.getCurrentPosition() >= 2000){
            tape.setPower(0);
        }


    }

    public void tapeIn(){

        tape.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tape.setPower(-1);
        if (tape.getCurrentPosition() <= 1){
            tape.setPower(0);
        }

    }
    public void tapeHold(){

        tape.setPower(0);

    }
}

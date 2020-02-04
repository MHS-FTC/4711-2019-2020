package org.firstinspires.ftc.teamcode.FTC_Library.Robot.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class clawExtender extends SubSystem{

    private String rotateName;

    private DcMotor rotate;

   // private String bumpOutName;

    //private DigitalChannel bumpOut;


    //private String bumpInName;

    //private DigitalChannel bumpIn;

    @Override
    public boolean init(HardwareMap hardwareDevices) {
        rotate = hardwareDevices.dcMotor.get(rotateName);

       // bumpOut = hardwareDevices.digitalChannel.get(bumpOutName);
        //bumpOut.setMode(DigitalChannel.Mode.INPUT);//set limit switch to input

        //bumpIn = hardwareDevices.digitalChannel.get(bumpInName);
        //bumpIn.setMode(DigitalChannel.Mode.INPUT);//set limit switch to input
        return true;
    }

    public clawExtender setDeviceNames(String rotate) {

       // bumpOutName = bumpOut;
        rotateName = rotate;
       // bumpInName = bumpIn;
        return this;

    }


    public void rotateOut() {
             rotate.setPower(1);

     }

     public void rotateIn() {


             rotate.setPower(-1);


     }

     public void rotateStop() {

         rotate.setPower(0);
     }


   public DcMotor getRotate() {
        return rotate;
    }
}

package org.firstinspires.ftc.teamcode.FTC_Library.Autonomous.Modules;
import com.qualcomm.robotcore.hardware.Servo;
public class FoundationLock extends Module{


        private Servo elementHook;
        private double startTime;
        private final int DELAY = 1000;

        @Override
        public void start() {
            elementHook = robot.hardwareMap.servo.get("foundationLock");
            startTime = robot.getTimeMilliseconds();
            elementHook.setPosition(0.4);
        }

        @Override
        public boolean tick() {
            return startTime + DELAY < robot.getTimeMilliseconds();
        }

}

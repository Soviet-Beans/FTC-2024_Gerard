package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class GerardMk1 {

    // Drivetrain
    public DcMotor fl, bl, fr, br;

    // Main Arm
    public DcMotor al;
    public Servo cl, c;

    // Hang Arm
    public DcMotor ha;

    // Constructor
    public GerardMk1(HardwareMap hw) {

        // Hardware Map

        // Drivetrain
        fl = hw.get(DcMotor.class, "frontLeft");
        bl = hw.get(DcMotor.class, "backLeft");
        fr = hw.get(DcMotor.class, "frontRight");
        br = hw.get(DcMotor.class, "backRight");

        // Main Arm
        al = hw.get(DcMotor.class, "armLift");
        cl = hw.get(Servo.class, "clawLift");
        c = hw.get(Servo.class, "claw");

        // Hang Arm
        ha = hw.get(DcMotor.class, "hangArm");

        // Default Behaviour
        al.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ha.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}

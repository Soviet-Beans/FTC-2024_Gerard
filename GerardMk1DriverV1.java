package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp
public class GerardMk1DriverV1 extends LinearOpMode{

    GerardMk1 b;

    @Override
    public void runOpMode() {

        // Constant Variables
        b = new GerardMk1(hardwareMap);
        boolean clawPos = false;
        double open = 0.0;
        double close = 100.0;

        waitForStart();

        // Init actions
        b.c.setPosition(close);

        while(opModeIsActive()) {

            // Drivetrain
            // Assigns input to values
            double x = gamepad1.left_stick_x;
            double y = gamepad1.left_trigger - gamepad1.right_trigger;
            double r;
            if(gamepad1.left_bumper) r = -1;
            else if(gamepad1.right_bumper) r = 1;
            else r = 0;
            // Ensures motors maintain the same ratio
            double d = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(r), 1);
            // Calculates power for each motor
            double flp = (y + x + r) / d;
            double frp = (y - x - r) / d;
            double blp = (y -x +r) / d;
            double brp = (y + x - r) / d;
            // Runs motors at calculated power
            b.fl.setPower(flp);
            b.fr.setPower(frp);
            b.bl.setPower(blp);
            b.br.setPower(brp);

            // Main Arm
            // Sets arm lift motor to reverse of right stick y
            double armPos = -gamepad1.right_stick_y;
            b.al.setPower(armPos);
            // Changes claw lift servo position gradually
            if(gamepad1.y) b.cl.setPosition(b.cl.getPosition() + 1);
            if(gamepad1.a) b.cl.setPosition(b.cl.getPosition() - 1);
            // Sets claw to open or closed depending on current pos
            if(!clawPos && gamepad1.x) {

                b.c.setPosition(open);
                clawPos = true;
            }
            else if(clawPos && gamepad1.x) {

                b.c.setPosition(close);
                clawPos = false;
            }

            // Hang Arm
            // Sets power based on if a dpad button is pressed or not
            if(gamepad1.dpad_up) b.ha.setPower(1);
            if(gamepad1.dpad_down) b.ha.setPower(-1);
        }
    }
}

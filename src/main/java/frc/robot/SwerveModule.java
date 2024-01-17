package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;

import com.ctre.phoenix.sensors.WPI_CANCoder;

public class SwerveModule {
    private final TalonFX steerMotor;
    private final TalonFX driveMotor;

    private final PIDController steerController;
    private final WPI_CANCoder encoder;

    private final double KP;
    private final double KI;
    private final double KD;

    private final int OFFSET;

    public SwerveModule(int STEERID, int DRIVEID, int ENCODERID, int OFFSET) {
        steerMotor = new TalonFX(STEERID);
        driveMotor = new TalonFX(DRIVEID);

        KP = 0.005;
        KI = 0;
        KD = 0;

        this.OFFSET = OFFSET;

        steerController = new PIDController(KP, KI, KD);
        steerController.enableContinuousInput(-180, 180);
        encoder = new WPI_CANCoder(ENCODERID);
    }

    /*
    public double getEncoderPosition() {
        double angle = Math.toRadians(encoder.getAbsolutePosition());
        angle = Math.toDegrees(Math.atan2(Math.sin(angle), Math.cos(angle)));
        return angle;
    }
    */

    public void setSteerAngle(double angle) {        
        double output = steerController.calculate(encoder.getAbsolutePosition() + OFFSET, angle);
        steerMotor.set(ControlMode.PercentOutput, output);
    }

    public void setDriveSpeed(double speed) {
        driveMotor.set(ControlMode.PercentOutput, speed);
    }
}

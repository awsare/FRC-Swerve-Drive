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

    private double OFFSET;

    public SwerveModule(int STEERID, int DRIVEID, int ENCODERID, int OFFSET) {
        steerMotor = new TalonFX(STEERID);
        driveMotor = new TalonFX(DRIVEID);

        KP = 0.005;
        KI = 0;
        KD = 0.0001;

        this.OFFSET = OFFSET;

        steerController = new PIDController(KP, KI, KD);
        steerController.enableContinuousInput(-180, 180);
        encoder = new WPI_CANCoder(ENCODERID);
    }

    public void setConstants(double KP, double KI, double KD) {
        steerController.setP(KP);
        steerController.setI(KI);
        steerController.setD(KD);
    }

    public void setOffset(double OFFSET) {
        this.OFFSET = OFFSET;
    }

    public void setSteerAngle(double angle) {        
        double output = steerController.calculate(encoder.getAbsolutePosition() + OFFSET, angle);
        steerMotor.set(ControlMode.PercentOutput, output);
    }

    public void setDriveSpeed(double speed) {
        driveMotor.set(ControlMode.PercentOutput, speed);
    }
}

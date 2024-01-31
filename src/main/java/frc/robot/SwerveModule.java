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

    public SwerveModule(int STEERID, int DRIVEID, int ENCODERID, double OFFSET) {
        steerMotor = new TalonFX(STEERID);
        driveMotor = new TalonFX(DRIVEID);

        KP = 0.006;
        KI = 0;
        KD = 0.0001;

        steerController = new PIDController(KP, KI, KD);
        steerController.enableContinuousInput(-180, 180);
        encoder = new WPI_CANCoder(ENCODERID);
        encoder.configMagnetOffset(OFFSET);
        encoder.setPositionToAbsolute();
    }

    public void setConstants(double KP, double KI, double KD) {
        steerController.setP(KP);
        steerController.setI(KI);
        steerController.setD(KD);
    }

    public void setSteerAngle(double angle) {        
        double output = steerController.calculate(encoder.getPosition(), angle);
        steerMotor.set(ControlMode.PercentOutput, output);
    }

    public void setDriveSpeed(double speed) {
        driveMotor.set(ControlMode.PercentOutput, speed);
    }
}

package frc.robot.Hardware;

import com.ctre.phoenix6.controls.DutyCycleOut;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.ctre.phoenix6.hardware.TalonFX;

public class Climber {
    //private final TalonFX kraken;
    private final TalonFX kraken;
    private final DutyCycleOut out = new DutyCycleOut(0);

    public Climber() {
        kraken = new TalonFX(9);
    }

    public void setClimberSpeed(double speed) {
        out.Output = speed;
        kraken.setControl(out);
    }
}

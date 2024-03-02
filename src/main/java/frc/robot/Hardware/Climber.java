package frc.robot.Hardware;



// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.DutyCycleOut;

public class Climber {
    //private final TalonFX kraken;
    private final TalonFX kraken;

    public Climber() {
        kraken = new TalonFX(9);
    }

    public void setClimberSpeed(double speed) {
        kraken.set(speed);
    }
}

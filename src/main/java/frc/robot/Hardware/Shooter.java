package frc.robot.Hardware;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

public class Shooter {

    private CANSparkMax shooter;
    private CANSparkMax angle;

    public Shooter() {
    
        //shooter = new CANSparkMax(shooterDeviceID, MotorType.kBrushless); 
        //angle = new CANSparkMax(angleDeviceID, MotorType.kBrushless);

        shooter.restoreFactoryDefaults();
        angle.restoreFactoryDefaults();
    }
}

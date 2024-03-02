package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Hardware.Climber;
import frc.robot.Hardware.Shooter;
import frc.robot.Hardware.SwerveChassis;

public class Robot extends TimedRobot {
    Joystick driver = new Joystick(0);
    Joystick operator = new Joystick(1);

    //SwerveChassis swerveChassis = new SwerveChassis();
    //Shooter shooter = new Shooter();
    Climber climber = new Climber();

    @Override
    public void robotInit() {}

    @Override
    public void robotPeriodic() {}

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {}

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {
        double x = -driver.getRawAxis(0);
        double y = -driver.getRawAxis(1);
        double r = -driver.getRawAxis(4);
        //swerveChassis.drive(x, y, r);

        double climberSpeed = driver.getRawAxis(3) - driver.getRawAxis(2);
        climber.setClimberSpeed(climberSpeed);
    }
}

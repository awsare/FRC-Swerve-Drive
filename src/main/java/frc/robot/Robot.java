package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Hardware.SwerveChassis;

public class Robot extends TimedRobot {
    Joystick driver = new Joystick(0);
    
    SwerveChassis swerveChassis = new SwerveChassis();

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

        double a = 0.6;
        x = (a * Math.pow(x, 3)) + (x * (1 - a));
        y = (a * Math.pow(y, 3)) + (y * (1 - a));
        r = (a * Math.pow(r, 3)) + (r * (1 - a));
        
        swerveChassis.drive(x, y, r);
    }
}

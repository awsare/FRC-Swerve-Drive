package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveChassis {
    private final SwerveModule frontLeft;
    private final SwerveModule frontRight;
    private final SwerveModule backLeft;
    private final SwerveModule backRight;

    private final double L;
    private final double W;
    private final double radius;

    public SwerveChassis() {
        frontLeft = new SwerveModule(0, 1, 0, 0);
        frontRight = new SwerveModule(2, 3, 1, 0);
        backLeft = new SwerveModule(4, 5, 2, 0);
        backRight = new SwerveModule(6, 7, 3, 0);

        L = 19.5;
        W = 20.0;
        radius = Math.sqrt((L * L) + (W * W));

        SmartDashboard.putNumber("fl", 0);
        SmartDashboard.putNumber("fr", 0);
        SmartDashboard.putNumber("bl", 0);
        SmartDashboard.putNumber("br", 0);

        SmartDashboard.putNumber("kp", 0.005);
        SmartDashboard.putNumber("ki", 0);
        SmartDashboard.putNumber("kd", 0);
    }

    public void drive(double x, double y, double r) {
        frontLeft.setOffset(SmartDashboard.getNumber("fl", 0));
        frontRight.setOffset(SmartDashboard.getNumber("fr", 0));
        backLeft.setOffset(SmartDashboard.getNumber("bl", 0));
        backRight.setOffset(SmartDashboard.getNumber("br", 0));

        frontLeft.setConstants(SmartDashboard.getNumber("kp", 0.005), SmartDashboard.getNumber("ki", 0), SmartDashboard.getNumber("kd", 0.000100));
        frontRight.setConstants(SmartDashboard.getNumber("kp", 0.005), SmartDashboard.getNumber("ki", 0), SmartDashboard.getNumber("kd", 0.000100));
        backLeft.setConstants(SmartDashboard.getNumber("kp", 0.005), SmartDashboard.getNumber("ki", 0), SmartDashboard.getNumber("kd", 0.000100));
        backRight.setConstants(SmartDashboard.getNumber("kp", 0.005), SmartDashboard.getNumber("ki", 0), SmartDashboard.getNumber("kd", 0.000100));

        double a = x - r * (L / radius);
        double b = x + r * (L / radius);
        double c = y - r * (W / radius);
        double d = y + r * (W / radius);
    
        double frontLeftSpeed = Math.sqrt((b * b) + (c * c));
        double frontRightSpeed = Math.sqrt((b * b) + (d * d));
        double backLeftSpeed = Math.sqrt((a * a) + (c * c));
        double backRightSpeed = Math.sqrt((a * a) + (d * d));

        double frontLeftAngle = Math.atan2(b, c) / Math.PI;
        double frontRightAngle = Math.atan2(b, d) / Math.PI;
        double backLeftAngle = Math.atan2(a, c) / Math.PI;
        double backRightAngle = Math.atan2(a, d) / Math.PI;

        // frontLeft.setDriveSpeed(frontLeftSpeed);
        // frontRight.setDriveSpeed(frontRightSpeed);
        // backLeft.setDriveSpeed(backLeftSpeed);
        // backRight.setDriveSpeed(backRightSpeed);

        frontLeft.setSteerAngle(frontLeftAngle * 180);
        frontRight.setSteerAngle(frontRightAngle * 180);
        backLeft.setSteerAngle(backLeftAngle * 180);
        backRight.setSteerAngle(backRightAngle * 180);
    }
}
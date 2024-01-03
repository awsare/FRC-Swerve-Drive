package frc.robot;

public class SwerveChassis {
    private final SwerveModule frontRight;
    private final SwerveModule frontLeft;

    private final double L;
    private final double W;
    private final double radius;

    public SwerveChassis() {
        frontRight = new SwerveModule(0, 1, 2, 3);
        frontLeft = new SwerveModule(1, 4, 5, 6);

        L = 1.0;
        W = 1.0;
        radius = Math.sqrt((L * L) + (W * W));
    }

    public void drive(double x, double y, double r) {
        double a = x - r * (L / radius);
        double b = x + r * (L / radius);
        double c = y - r * (W / radius);
        double d = y + r * (W / radius);
    
        double backRightSpeed = Math.sqrt ((a * a) + (d * d));
        double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
        double frontRightSpeed = Math.sqrt ((b * b) + (d * d));
        double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));
    
        double backRightAngle = Math.atan2 (a, d) / Math.PI;
        double backLeftAngle = Math.atan2 (a, c) / Math.PI;
        double frontRightAngle = Math.atan2 (b, d) / Math.PI;
        double frontLeftAngle = Math.atan2 (b, c) / Math.PI;

        frontRight.setDriveSpeed(frontRightSpeed);
        frontLeft.setDriveSpeed(frontLeftSpeed);

        frontRight.setSteerAngle(frontRightAngle);
        frontLeft.setSteerAngle(frontLeftAngle);
    }
}
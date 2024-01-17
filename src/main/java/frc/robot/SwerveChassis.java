package frc.robot;

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
    }

    public void drive(double x, double y, double r) {
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

        // System.out.println("fl" + frontLeftAngle);
        // System.out.println("fr" + frontRightAngle);
        // System.out.println("bl" + backLeftAngle);
        // System.out.println("br" + backRightAngle);

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
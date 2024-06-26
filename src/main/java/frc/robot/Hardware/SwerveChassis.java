package frc.robot.Hardware;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class SwerveChassis {
    private final SwerveModule frontLeft;
    private final SwerveModule frontRight;
    private final SwerveModule backLeft;
    private final SwerveModule backRight;

    private final AHRS gyro;

    private final double L;
    private final double W;
    private final double radius;

    public SwerveChassis() {
        frontLeft = new SwerveModule(0, 1, 0, 65.830);
        frontRight = new SwerveModule(2, 3, 1, 112.852);
        backLeft = new SwerveModule(4, 5, 2, 109.248);
        backRight = new SwerveModule(6, 7, 3, 180.352);

        L = 19.5;
        W = 20.0;
        radius = Math.sqrt((L * L) + (W * W));

        gyro = new AHRS(SPI.Port.kMXP);
    }

    public void drive(double x, double y, double r) {
        //double heading = -Math.toRadians(gyro.getYaw());

        //x = (x * Math.cos(heading)) - (y * Math.sin(heading));
        //y = (x * Math.sin(heading)) + (y * Math.cos(heading));

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

        frontLeft.setDriveSpeed(frontLeftSpeed);
        frontRight.setDriveSpeed(frontRightSpeed);
        backLeft.setDriveSpeed(backLeftSpeed);
        backRight.setDriveSpeed(backRightSpeed);

        frontLeft.setSteerAngle((frontLeftAngle * 180) - 45);
        frontRight.setSteerAngle((frontRightAngle * 180) + 45);
        backLeft.setSteerAngle((backLeftAngle * 180) - 180);
        backRight.setSteerAngle((backRightAngle * 180));
    }
}

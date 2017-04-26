package org.usfirst.frc.team31415.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	
	public XboxController driverGamepad;

	public static org.usfirst.frc.team31415.robot.XboxController Xbox;
	
	//these numbers are arbitrary and must be replaced with Angle motor, Speed motor, Angle Encoder, respectively
	private WheelDrive backRight = new WheelDrive (0, 0, 0);
	private WheelDrive backLeft = new WheelDrive (0, 0, 0);
	private WheelDrive frontRight = new WheelDrive (0, 0, 0);
	private WheelDrive frontLeft = new WheelDrive (0, 0, 0);

	private SwerveDrive swerveDrive = new SwerveDrive (backRight, backLeft, frontRight, frontLeft);

	public void robotInit() {
		driverGamepad = new XboxController(0);
	}


	public void autonomousInit() {

	}

	public void autonomousPeriodic() {

	}


	public void teleopPeriodic() {
		swerveDrive.drive (Xbox.getRightXAxis(), Xbox.getRightYAxis(), Xbox.getLeftYAxis());
	}


	public void testPeriodic() {
	}
}


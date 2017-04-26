package org.usfirst.frc.team31415.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;

public class WheelDrive {

	private final double MAX_VOLTS = 4.95;

	private VictorSP angleMotor;
	private VictorSP speedMotor;
	private PIDController pidController;

	public WheelDrive (int angleMotor, int speedMotor, int encoder) {
		this.angleMotor = new VictorSP (angleMotor);
		this.speedMotor = new VictorSP (speedMotor);
		pidController = new PIDController (1, 0, 0, new AnalogInput (encoder), this.angleMotor);

		pidController.setOutputRange (-1, 1);
		pidController.setContinuous ();
		pidController.enable ();
	}

	public void drive (double speed, double angle) {
		speedMotor.set (speed);

		double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
		if (setpoint < 0) {
			setpoint = MAX_VOLTS + setpoint;
		}
		if (setpoint > MAX_VOLTS) {
			setpoint = setpoint - MAX_VOLTS;
		}

		pidController.setSetpoint (setpoint);
	}



}

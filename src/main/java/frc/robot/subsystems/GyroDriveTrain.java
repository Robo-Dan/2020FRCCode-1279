/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class GyroDriveTrain extends SubsystemBase
{
  int P, I, D = 1;
  int integral, previous_error, setpoint = 0;
  Gyro gyro;
  double rcw;
  /**
   * Creates a new GyroDriveTrain.
   */
  public GyroDriveTrain(Gyro g)
  {
    gyro = g;
  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }

  public void setSetpoint(int setpoint)
    {
        this.setpoint = setpoint;
    }

    public void PID()
    {
        double error = setpoint - gyro.getAngle(); // Error = Target - Actual
        this.integral += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        double derivative = (error - this.previous_error) / .02;
        this.rcw = P*error + I*this.integral + D*derivative;
    }

    public void execute()
    {
        PID();
        Robot.drive.arcadeDrive(0, rcw);
        Robot.drive.feed();
    }
}
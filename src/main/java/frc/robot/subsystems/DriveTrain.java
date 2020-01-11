/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveTrain extends SubsystemBase
{
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain()
  {

  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }
  private static int inverse = 1;
  private double modifier = 1;

  static Joystick driverStick = Constants.DriverAndOperatorJoystick.driverStick;

  /**
   * This command drives the robot
   */
  public void robotDrive()
  {
    double xSpeed = driverStick.getRawAxis(Constants.DriverAndOperatorJoystick.driverLeftXAxis) * -1 * inverse * modifier; // makes forward stick positive
    double zRotation =  driverStick.getRawAxis(Constants.DriverAndOperatorJoystick.driverRightYAxis) * modifier; // WPI Drivetrain uses positive=> right; right stick for left and right

    Robot.drive.arcadeDrive(xSpeed, zRotation);

    Robot.drive.feed();
  }

  public void flipDirection()
  {
    inverse = inverse * -1; // just flips the value between 1 and negative 1
  }

  /**
   * Sets the direction forward
   * Forward is the formalerly hatch side
   */
  public void setDirectionForward()
  { // hatch side
    inverse = 1;
  }

  /**
   * Sets the direction backwards
   * Backwards is the formaleryly cargo side
   */
  public void setDirectionBack()
  { // cargo side
    inverse = -1;
  }

  /**
   * This slows down the drive train
   * Slows it to 60%
   * Multiplies the drive train by 0.6
   */
  public void slowSpeed()
  {
    modifier = 0.6; // 60%
  }

  /**
   * This is the normal speed
   * This will allow for the values to be times 1
   */
  public void normalSpeed()
  {
    modifier = 1; // 100%
  }

  /**
   * Returns the direction of the drivetrain
   * @return false when not inverted (cargo side), true when inverted (hatch side)
   */
  public static boolean getDirection()
  {
    if(inverse == 1)
    {
      return false; // cargo side
    }

    if(inverse == -1)
    {
      return true; // hatch side
    }

    else return false;
  }

  public void driveAuto()
  {
    Robot.drive.arcadeDrive(.2, 0);
  }
}
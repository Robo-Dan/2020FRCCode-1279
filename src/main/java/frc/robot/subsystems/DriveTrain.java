/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
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

  // CHECK THIS HERE static Joystick driverStick = RobotMap.driverStick;

  /**
   * This command drives the robot
   */
  public void robotDrive()
  {
    //double xSpeed = driverStick.getRawAxis(RobotMap.DRIVER_LEFT_X_AXIS) * -1 * inverse * modifier; // makes forward stick positive
    //double zRotation =  driverStick.getRawAxis(RobotMap.DRIVER_RIGHT_Y_AXIS) * modifier; // WPI Drivetrain uses positive=> right; right stick for left and right

    //Robot.drive.arcadeDrive(xSpeed, zRotation);

    //Robot.drive.feed();
  }

}
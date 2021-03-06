/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ClimbingSubsystem extends SubsystemBase
{
  //TODO: POSSIBLY ADD LIMIT SWITCHES
  /**
   * Creates a new ClimbingSubsystem.
   */
  public ClimbingSubsystem()
  {

  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }

  public void movingArmUp()
  {
    Constants.TalonNames.raisingTheBarMotor.set(ControlMode.PercentOutput, -.75);
  }

  public void movingArmDown()
  {
    Constants.TalonNames.raisingTheBarMotor.set(ControlMode.PercentOutput, .75);
  }

  public void stopMovingArm()
  {
    Constants.TalonNames.raisingTheBarMotor.stopMotor();
  }

  public void pullingRobotUpWithWinch()
  {
    Constants.TalonNames.pullingRobotUpMotor.set(ControlMode.PercentOutput, .75);
  }

  public void stopPullingUpRobot()
  {
    Constants.TalonNames.pullingRobotUpMotor.stopMotor();
  }

  //public boolean limitSwitchForClimbingArm()
  //{
    //return Robot.limitSwitchForArm.get();
  //}
}
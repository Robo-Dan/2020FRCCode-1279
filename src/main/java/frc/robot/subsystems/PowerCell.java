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

public class PowerCell extends SubsystemBase
{
  public static boolean shooterIsOn = false;
  /**
   * Creates a new PowerCell.
   */
  public PowerCell()
  {

  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }

  public boolean isShooterOn()
  {
    return shooterIsOn;
  }

  public void changeShooterBoolean()
  {
    shooterIsOn = !shooterIsOn;
  }
  public void shootPowerCell() //currently, this method is for shooting the upper goal. will change the name of the method if we also do the lower goal
  {
    Constants.TalonNames.leftShooter.set(ControlMode.PercentOutput, 1);
    Constants.TalonNames.rightShooter.set(ControlMode.PercentOutput, -1);
    //Test
  }

  public void moveElevatorUpForIntake()
  {
    Constants.TalonNames.elevatorForIntakingPowerCell.set(ControlMode.PercentOutput, .5);
    //Constants.TalonNames.rightIntakeMotor.set(ControlMode.PercentOutput, .5);
  }

  public void moveElevatorDownForIntake()
  {
    Constants.TalonNames.elevatorForIntakingPowerCell.set(ControlMode.PercentOutput, -.5);
  }

  public void moveKickerIn()
  {
    Constants.TalonNames.kickerTalon.set(ControlMode.PercentOutput, .25);
  }

  public void moveKickerOut()
  {
    Constants.TalonNames.kickerTalon.set(ControlMode.PercentOutput, -.25);
  }

  public void intakeArmIn()
  {
    Constants.TalonNames.intakeArm.set(ControlMode.PercentOutput, -.30);
  }

  public void intakeArmOut()
  {
    Constants.TalonNames.intakeArm.set(ControlMode.PercentOutput, .30);
  }

  public void stopAll() //May have to change this later. I think I may change this to stopShooting and stopIntaking
  {
    Constants.TalonNames.leftShooter.stopMotor();
    Constants.TalonNames.rightShooter.stopMotor();
    Constants.TalonNames.elevatorForIntakingPowerCell.stopMotor();
    Constants.TalonNames.kickerTalon.stopMotor();
    //Constants.TalonNames.rightIntakeMotor.stopMotor();
  }

  public void stopShooting()
  {
    Constants.TalonNames.leftShooter.stopMotor();
    Constants.TalonNames.rightShooter.stopMotor();
  }

  public void stopIntaking()
  {
    Constants.TalonNames.elevatorForIntakingPowerCell.stopMotor();
    //Constants.TalonNames.rightIntakeMotor.stopMotor();
  }

  public void stopKicker()
  {
    Constants.TalonNames.kickerTalon.stopMotor();
  }

  public void stopIntakeArm()
  {
    Constants.TalonNames.intakeArm.stopMotor();
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import javax.lang.model.util.ElementScanner6;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PowerCell extends SubsystemBase
{
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

  public void shootPowerCell() //currently, this method is for shooting the upper goal. will change the name of the method if we also do the lower goal
  {
    Constants.TalonNames.leftShooter.set(ControlMode.PercentOutput, 1);
    Constants.TalonNames.rightShooter.set(ControlMode.PercentOutput, -1);
    //Test
  }

  public void moveElevatorUpForIntake()
  {
    Constants.TalonNames.elevatorForIntakingPowerCell.set(ControlMode.PercentOutput, -.5);
    //Constants.TalonNames.rightIntakeMotor.set(ControlMode.PercentOutput, .5);
  }

  public void moveElevatorDownForIntake()
  {
    Constants.TalonNames.elevatorForIntakingPowerCell.set(ControlMode.PercentOutput, .5); //TODO: if jammed, should this be slower? Ask Kedersha
  }

  public void moveKickerIn()
  {
    Constants.TalonNames.kickerTalon.set(ControlMode.PercentOutput, .5);
  }

  public void moveKickerOut()
  {
    Constants.TalonNames.kickerTalon.set(ControlMode.PercentOutput, -.5);
  }

  public void stopAll() //May have to change this later. I think I may change this to stopShooting and stopIntaking
  {
    Constants.TalonNames.leftShooter.stopMotor();
    Constants.TalonNames.rightShooter.stopMotor();
    Constants.TalonNames.elevatorForIntakingPowerCell.stopMotor();
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
}
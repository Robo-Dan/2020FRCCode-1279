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

public class ControlPanelSub extends SubsystemBase
{

  /**
   * Creates a new ControlPanelSub.
   */
  public ControlPanelSub()
  {

  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }

  public void turnControlPanel()
  {
    Constants.TalonNames.controlPanel.set(ControlMode.PercentOutput, .40);
  }

  public void stopControlPanel()
  {
    Constants.TalonNames.controlPanel.stopMotor();
  }
}
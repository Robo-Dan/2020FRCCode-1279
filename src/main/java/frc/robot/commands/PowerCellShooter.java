/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.PowerCell;

/**
 * DO NOT USE
 */
public class PowerCellShooter extends CommandBase
{
  //boolean shooterOn = true;
  private final PowerCell powerCellSystem;
  /**
   * Creates a new PowerCellShooter.
   */
  public PowerCellShooter(PowerCell system)
  {
    powerCellSystem = system;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.powerCell);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
      powerCellSystem.shootPowerCell();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
      powerCellSystem.stopShooting();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}

/**
 * when pressed
 * shooting = false
 * press button
 * shooting = true
 * shoot ball
 * press button
 * stop shooting
 * shooting = false
 * repeat
 */
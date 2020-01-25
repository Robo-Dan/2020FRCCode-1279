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

public class TriggerBasedPowerCellShooter extends CommandBase
{
  //TODO: ASK MR HARKINS TO HELP
  private final PowerCell powerCellSubSystem;
  public static boolean shooterIsOn = false;
  /**
   * Creates a new TriggerBasedPowerCellShooter.
   */
  public TriggerBasedPowerCellShooter(PowerCell powerCellSub)
  {
    powerCellSubSystem = powerCellSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.powerCell);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    if(shooterIsOn == false)
    {
      this.execute();
    }
    else
    {
      this.end(false);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    powerCellSubSystem.shootPowerCell();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    if(shooterIsOn == true)
    {
      shooterIsOn = !shooterIsOn;
      powerCellSubSystem.stopShooting();
    }
    else
    {
      shooterIsOn = !shooterIsOn;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}
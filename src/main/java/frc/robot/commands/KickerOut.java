/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.PowerCell;

public class KickerOut extends CommandBase
{
  private final PowerCell powerCellSystem;
  private final Timer timer = new Timer();

  int tester = 0;
  /**
   * Creates a new KickerOut.
   */
  public KickerOut(PowerCell system)
  {
    powerCellSystem = system;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.powerCell);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    if(timer.get() < .44 && tester == 0)
    {
      powerCellSystem.moveKickerOut();
    }
    else if(timer.get() == .44)
    {
      tester++;
    }
    else
    {
      this.end(false || true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    powerCellSystem.stopKicker();
    tester = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}

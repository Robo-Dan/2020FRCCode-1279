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

public class KickerIn extends CommandBase
{
  private final PowerCell powerCellSubSystem;

  private final Timer timer = new Timer();

  int tester = 0;
  double timeToMove = .4195;
  /**
   * Creates a new KickerIn. This is the motor that allows for the Power Cells to go to the shooter
   */
  public KickerIn(PowerCell systemForPowerCell)
  {
    powerCellSubSystem = systemForPowerCell;
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
    if(timer.get() < timeToMove && tester == 0)
    {
      powerCellSubSystem.moveKickerOut();
    }
    else if(timer.get() == timeToMove)
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
    powerCellSubSystem.stopKicker();
    tester = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}

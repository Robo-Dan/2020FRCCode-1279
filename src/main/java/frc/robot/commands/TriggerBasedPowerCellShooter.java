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

public class TriggerBasedPowerCellShooter extends CommandBase
{
  private final PowerCell powerCellSubSystem;
  private final Timer m_timer = new Timer();
  double endOfShooterTime = 0;
  double kickerTime = 0;
  double timeToMove = .4195;
  int counter = 0;
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
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    if(counter != 0)
    {
      m_timer.reset();
      m_timer.start();
      counter = 0;
      endOfShooterTime = kickerTime;
    }
    if(m_timer.get() < 1)
    { 
      //powerCellSubSystem.moveKickerOut();
      powerCellSubSystem.shootPowerCell();
    }
    else
    {
      powerCellSubSystem.moveKickerOut();
      powerCellSubSystem.shootPowerCell();
      powerCellSubSystem.moveElevatorUpForIntake();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    if(endOfShooterTime == kickerTime)
    {
      m_timer.reset();
      m_timer.start();
      kickerTime++;
    }
    while(m_timer.get() < timeToMove) //Hello
    {
      powerCellSubSystem.stopShooting();
      //powerCellSubSystem.moveKickerOut();
      powerCellSubSystem.stopIntaking();
    }
    System.out.println("YOU ARE HITTING ELSE");
    powerCellSubSystem.stopKicker();
    powerCellSubSystem.stopShooting();
    counter++;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PowerCell;

public class AutoSimpleLowScore extends CommandBase
{
  private final Timer m_timer = new Timer();

  private final DriveTrain driveTrainAuto;
  private final PowerCell shooting;
  /**
   * Creates a new AutoSimpleLowScore.
   */
  public AutoSimpleLowScore(DriveTrain driveTrainSubsystem, PowerCell testPowerCell)
  {
    driveTrainAuto = driveTrainSubsystem;
    shooting = testPowerCell;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.robotDriveTrain);
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
    if(m_timer.get() < 4)
    {
      driveTrainAuto.driveForward();
    }
    else if(m_timer.get() > 4 && m_timer.get() < 4.075)
    {
      shooting.moveKickerIn();
      shooting.shootPowerCell();
    }
    else if(m_timer.get() > 4.075 && m_timer.get() < 5.575)
    {
      shooting.shootPowerCell();
    }
    else if(m_timer.get() > 5.575 && m_timer.get() < 10.575)
    {
      shooting.moveKickerOut();
      shooting.shootPowerCell();
    }
    else
    {
      shooting.stopKicker();
      driveTrainAuto.stopDriving();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    shooting.stopShooting();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}

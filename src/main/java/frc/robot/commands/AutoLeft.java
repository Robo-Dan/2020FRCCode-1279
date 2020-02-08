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
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PowerCell;

public class AutoLeft extends CommandBase
{
  private final Timer m_timer = new Timer();

  private final DriveTrain driveTrainAuto;
  private final PowerCell shooting;
  /**
   * Creates a new AutoLeft.
   */
  public AutoLeft(DriveTrain driveTrainSubsystem, PowerCell testPowerCell)
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
  if(m_timer.get() < 1)
  {
    shooting.shootPowerCell(); 
    driveTrainAuto.turnRobotRight();   

  }
  else if(m_timer.get() < 2)
  {
    shooting.shootPowerCell();
    driveTrainAuto.driveForward();
  }
  else if(m_timer.get() < 3)
  {
    shooting.shootPowerCell();
    driveTrainAuto.turnRobotRight();
  }
  else if(m_timer.get() > 4 && m_timer.get() < 5)
  {
    shooting.shootPowerCell();
    shooting.moveKickerOut();
  }
  else if(m_timer.get() < 10)
  {
    shooting.shootPowerCell();
    shooting.stopKicker();
  }
  else if(m_timer.get() < 11)
  {
    shooting.stopShooting();
    shooting.moveKickerIn();
    driveTrainAuto.driveBackward();
  }
  else if(m_timer.get() < 12)
  {
    driveTrainAuto.driveBackward();
  }

}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}
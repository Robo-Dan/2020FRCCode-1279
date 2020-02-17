/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PowerCell;

public class AutoLeftWithGyro extends CommandBase
{
  private final Timer m_timer = new Timer();
  Gyro gyro;
  private final DriveTrain driveTrainAuto;
  private final PowerCell shooting;
  /**
   * Creates a new AutoLeftWithGyro.
   */
  public AutoLeftWithGyro(DriveTrain drive, PowerCell power)
  {
    driveTrainAuto = drive;
    shooting = power;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.robotDriveTrain);
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
    while(m_timer.get() < 13)
    {
      double time = 0;
      while(gyro.getAngle() < -90)
      {
        driveTrainAuto.turnRobotLeft();
        //shooting.moveKickerIn();
        shooting.shootPowerCell();
        time = m_timer.get();
      }
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
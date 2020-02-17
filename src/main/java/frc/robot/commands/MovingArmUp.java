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
import frc.robot.subsystems.ClimbingSubsystem;

public class MovingArmUp extends CommandBase
{
  private ClimbingSubsystem climberInSubsystem;
  private final Timer m_timer = new Timer();
  /**
   * Creates a new MovingArmUp.
   */
  public MovingArmUp(ClimbingSubsystem climb)
  {
    climberInSubsystem = climb;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.climber);
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
    //if(m_timer.get() < 1.1)
    //{
      climberInSubsystem.movingArmUp();
    //}
    //else if(m_timer.get() > 1.1 && m_timer.get() < 1.2)
    //{
     // climberInSubsystem.movingArmUpSlowly();
    //}
    //else
    //{
      //climberInSubsystem.stopMovingArm();
    //}
    //for(int i = 0; i < 8; i++)
    //{
      //m_timer.start();
      //Timer timer = new Timer();
      //if(timer.get() <= .5)
      //{
        //climberInSubsystem.movingArmUp();
      //}
      //climberInSubsystem.stopMovingArm();
    //}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    climberInSubsystem.stopMovingArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}
// loop for 100 ms for 100 tries
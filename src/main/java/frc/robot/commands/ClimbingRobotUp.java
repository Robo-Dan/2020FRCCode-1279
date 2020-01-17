/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbingSubsystem;

public class ClimbingRobotUp extends CommandBase
{
  private ClimbingSubsystem climberInSubsystem;
  /**
   * Creates a new ClimbingRobotUp.
   */
  public ClimbingRobotUp(ClimbingSubsystem climb) //we have to include the subsytem in the command this year. Have to remember to add subsystem to RobotContainer
  {
    climberInSubsystem = climb;
    addRequirements(Robot.climber);
    // Use addRequirements() here to declare subsystem dependencies.
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
    climberInSubsystem.pullingRobotUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    climberInSubsystem.stopPullingUpRobot();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}

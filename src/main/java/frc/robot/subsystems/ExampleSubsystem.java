/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase
{
  private static int inverse = 1;
  /**
   * Creates a new ExampleSubsystem.
   */
  public ExampleSubsystem()
  {

  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }

  /**public static void changeDirection()
  {
    if(inverse == 1)
    {
      inverse = -1;
    }
    else
    {
      inverse = 1;
    }
  }

  public static boolean getDirection()
  {
    if(inverse == 1)
    {
      return false;
    }
    else if(inverse == -1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }*/
}
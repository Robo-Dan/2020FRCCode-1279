/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * This is the DistanceSensor class. The purpose of this
 * Is so that we will be able to use the distance sensor in more ways
 * Than just telling us how far away we are
 * We would be able to use this for auto and possibly even teleop
 */
public class DistanceSensor 
{
    private static final double kHoldDistance = 12.0;
  // factor to convert sensor values to a distance in inches
    private static final double kValueToInches = 0.125;
  // proportional speed constant
    private static final double kP = 0.05;
    private static final int kUltrasonicPort = 0;

    public DistanceSensor()
    {
        
    }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static final class TalonIDs
    {
        //These names will be changed later. Just for placement know
        public static final int TALON_ONE = 1;
        public static final int TALON_TWO = 2;
        public static final int TALON_THREE = 3;
        public static final int TALON_FOUR = 4;
        public static final int TALON_FIVE = 5;
        public static final int TALON_SIX = 6;
        public static final int TALON_SEVEN = 7;
        public static final int TALON_EIGHT = 8;
        public static final int TALON_NINE = 9;
        public static final int TALON_TEN = 10;
    }

    public static final class JoystickButtonNumbers
    {
        public static final int BUTTON_ONE = 1;
        public static final int BUTTON_TWO = 2;
        public static final int BUTTON_THREE = 3;
        public static final int BUTTON_FOUR = 4;
        public static final int BUTTON_FIVE = 5;
    }

    public static final class DriverJoystick
    {
        public static Joystick driverStick = new Joystick(0);
        public static final int driverLeftXAxis = 1;
        public static final int driverRightYAxis = 4;
    }

    public static final class OperatorJoystick
    {
        public static Joystick operatorStick = new Joystick(1);
    }

    public static final class TalonNames
    {
        public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.TalonIDs.TALON_ONE);
        public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(Constants.TalonIDs.TALON_TWO);
        public static SpeedControllerGroup m_left = new SpeedControllerGroup(frontLeft, rearLeft);
        public static WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.TalonIDs.TALON_THREE);
        public static WPI_TalonSRX rearRight = new WPI_TalonSRX(Constants.TalonIDs.TALON_FOUR);
        public static SpeedControllerGroup m_right = new SpeedControllerGroup(frontRight, rearRight);
    }
}
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
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

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

    public static final class DriverAndOperatorJoystick
    {
        public static Joystick driverStick = new Joystick(0);
        public static Joystick operatorStick = new Joystick(1);
        public static final int driverLeftXAxis = 1;
        public static final int driverRightYAxis = 4;
        
        public static Joystick getGamepad(int stickId)
        {
            if (stickId == 0)
            {
                return driverStick;
            }
            if (stickId == 1)
            {
                return operatorStick;
            }
            return driverStick; // failsafe
        }

        static Button driver_A_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 1);
    }

    public static final class TalonNames
    {
        public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.TalonIDs.TALON_TEN);
        public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(Constants.TalonIDs.TALON_EIGHT);
        public static SpeedControllerGroup m_left = new SpeedControllerGroup(frontLeft, rearLeft);
        public static WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.TalonIDs.TALON_TWO);
        public static WPI_TalonSRX rearRight = new WPI_TalonSRX(Constants.TalonIDs.TALON_SEVEN);
        public static SpeedControllerGroup m_right = new SpeedControllerGroup(frontRight, rearRight);

        // This is the Talons for shooting the ball
        public static WPI_TalonSRX leftOffConveyorBelt = new WPI_TalonSRX(17); // left when 
        public static WPI_TalonSRX rightOffConveyorBelt = new WPI_TalonSRX(95);
        public static WPI_TalonSRX leftShooter = new WPI_TalonSRX(31);
        public static WPI_TalonSRX rightShooter = new WPI_TalonSRX(14);

        public static WPI_TalonSRX leftIntakeMotor = new WPI_TalonSRX(20);
        public static WPI_TalonSRX rightIntakeMotor = new WPI_TalonSRX(15);
    }

    public static final class AutoConstants
    {

    }
}
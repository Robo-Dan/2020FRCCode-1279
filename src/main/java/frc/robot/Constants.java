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
        public static final int TALON_ELEVEN = 11;
        public static final int TALON_TWELVE = 12;
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
        static Button driver_B_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 2);
        static Button driver_X_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 3);
        static Button driver_Y_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 4);
        static Button leftShoulderButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 5);
        static Button rightShoulderButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 6);
        static Button viewButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 7);
        static Button menuButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 8);
        static Button leftStickButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 9);
        static Button rightStickButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 10);

        
    }

    public static final class TalonNames
    {
        public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(100); //change to one //Talon 10
        public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(8); //change to two //Talon 8
        /**
         * This is the speed group for the left side of the robot for motors
         */
        public static SpeedControllerGroup m_left = new SpeedControllerGroup(frontLeft, rearLeft);
        public static WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.TalonIDs.TALON_SEVEN); //change to three //Talon 7
        public static WPI_TalonSRX rearRight = new WPI_TalonSRX(13); //change to four //Talon 13
        public static SpeedControllerGroup m_right = new SpeedControllerGroup(frontRight, rearRight);

        // This is the Talons for shooting the ball
        public static WPI_TalonSRX leftOffConveyorBelt = new WPI_TalonSRX(17); // change to 5
        public static WPI_TalonSRX rightOffConveyorBelt = new WPI_TalonSRX(95); // change to 6
        public static WPI_TalonSRX leftShooter = new WPI_TalonSRX(321); //change to 7
        public static WPI_TalonSRX rightShooter = new WPI_TalonSRX(32); // change to 8

        public static WPI_TalonSRX intakeMotor = new WPI_TalonSRX(20); // change to 9 THIS IS ORIGINALLY THE LEFT INTAKE MOTOR
        //^CHANGE THIS BACK TO LEFT IF NEEDED
        //public static WPI_TalonSRX rightIntakeMotor = new WPI_TalonSRX(15); // change to 10, if we use it

        public static WPI_TalonSRX raisingTheBarMotor = new WPI_TalonSRX(10);
        public static WPI_TalonSRX pullingRobotUpMotor = new WPI_TalonSRX(Constants.TalonIDs.TALON_ELEVEN);
    }
    //test

    public static final class AutoConstants
    {

    }
}
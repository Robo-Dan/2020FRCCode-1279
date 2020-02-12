/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

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
    /**
     * Contains the names of the Talon IDs
     */
    public static final class TalonIDs
    {
        //These names may be changed later. Just for placement know
        public static final int TALON_ONE = 1; // Name for the first talon
        public static final int TALON_TWO = 2; // Name for the second talon
        public static final int TALON_THREE = 3; // Name for the third talon
        public static final int TALON_FOUR = 4; // Name for the fourth talon
        public static final int TALON_FIVE = 5; // Name for the fifth talon
        public static final int TALON_SIX = 6; // Name for the sixth talon
        public static final int TALON_SEVEN = 7; // Name for the seventh talon
        public static final int TALON_EIGHT = 8; // name for the eighth talon
        public static final int TALON_NINE = 9; // Name for the ninth talon
        public static final int TALON_TEN = 10; // Name for the tenth talon
        public static final int TALON_ELEVEN = 11; // Name for the eleventh talon
        public static final int TALON_TWELVE = 12; // Name for the twelvth talon
    }

    /**
     * Class that contains the driver and operator buttons
     * Way to name the Buttons
     * static Button driver_ButtonName or operator_ButtonName = new JoystickButton(JoystickName, NumberOnController)
     */
    public static final class DriverAndOperatorJoystick
    {
        public static Joystick driverStick = new Joystick(0);
        public static Joystick operatorStick = new Joystick(1);
        public static final int driverLeftXAxis = 1; //look at axes on driver station
        public static final int driverRightYAxis = 4;
        
        public static final int operatorLeftTrigger = 2;
        public static final int operatorRightTrigger = 3;

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

        // Here is how the process for assigning buttons is
        // static Button driver_ButtonName or operator_ButtonName = new JoystickButton(JoystickName, NumberOnController)
        // static (allows for us to use in other classes)
        // Button (Name of class)
        // driver_ButtonName or operator_ButtonName (name of the button on the controller)
        // new JoystickButton (name of the class for the Button)
        // JoystickName (name of the joystick. will either be the driver or operator controller)
        // NumberOnController (number that corresponds to the button on the controller)
        static Button driver_A_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 1);
        static Button driver_B_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 2);
        static Button driver_X_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 3);
        static Button driver_Y_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 4);
        static Button driver_leftShoulderButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 5);
        static Button driver_rightShoulderButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 6);
        static Button driver_backButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 7);
        static Button driver_startButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 8);
        static Button driver_leftStickButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 9);
        static Button driver_rightStickButton = new JoystickButton(Constants.DriverAndOperatorJoystick.driverStick, 10);

        //triggers for driver
        static Trigger testTrigger = new Trigger();

        static Button operator_A_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 1);
        static Button operator_B_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 2);
        static Button operator_X_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 3);
        static Button operator_Y_Button = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 4);
        static Button operator_leftShoulderButton = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 5);
        static Button operator_rightShoulderButton = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 6);
        static Button operator_backButton = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 7);
        static Button operator_startButton = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 8);
        static Button operator_leftStickButton = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 9);
        static Button operator_rightStickButton = new JoystickButton(Constants.DriverAndOperatorJoystick.operatorStick, 10);

        //triggers for operator

    }

    /**
     * Contains the names of the Talon Names
     * Way to name Talons
     * public static WPI_TalonSRX nameOfTalon = new WPI_TalonSRX(TalonNumber);
     */
    public static final class TalonNames
    {
        //TALONS 7, 8, 10, 13 ARE FOR TESTING CURRENTLY
        public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.TalonIDs.TALON_SEVEN); //change to one //Talon 10
        public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(Constants.TalonIDs.TALON_ONE); //change to two //Talon 8
        /**
         * This is the speed group for the left side of the robot for motors
         */
        public static SpeedControllerGroup m_left = new SpeedControllerGroup(frontLeft, rearLeft);

        public static WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.TalonIDs.TALON_FIVE); //change to three //Talon 7
        public static WPI_TalonSRX rearRight = new WPI_TalonSRX(Constants.TalonIDs.TALON_SIX); //change to four //Talon 13

        public static SpeedControllerGroup m_right = new SpeedControllerGroup(frontRight, rearRight);

        // This is the Talons for shooting the ball
        public static WPI_TalonSRX leftShooter = new WPI_TalonSRX(Constants.TalonIDs.TALON_TEN); //change to 7
        public static WPI_TalonSRX rightShooter = new WPI_TalonSRX(Constants.TalonIDs.TALON_NINE); // change to 8

        public static WPI_TalonSRX elevatorForIntakingPowerCell = new WPI_TalonSRX(50000); // change to 9 THIS IS ORIGINALLY THE LEFT INTAKE MOTOR

        public static WPI_TalonSRX kickerTalon = new WPI_TalonSRX(Constants.TalonIDs.TALON_EIGHT);

        public static WPI_TalonSRX raisingTheBarMotor = new WPI_TalonSRX(15); //this will be the value for testing
        public static WPI_TalonSRX pullingRobotUpMotor = new WPI_TalonSRX(Constants.TalonIDs.TALON_ELEVEN);

        public static WPI_TalonSRX controlPanel = new WPI_TalonSRX(45);

        //public static WPI_TalonSRX intakeArm = new WPI_TalonSRX(10);
        //Island of Misfit Talons
        //public static WPI_TalonSRX leftOffConveyorBelt = new WPI_TalonSRX(17); // change to 5
        //TODO: REASON FOR COMMENTED OUT ^ ONLY ONE MOTOR
        //public static WPI_TalonSRX rightOffConveyorBelt = new WPI_TalonSRX(95); // change to 6
        //TODO: REASON FOR COMMENTED OUT ^ ONLY ONE MOTOR
        //^CHANGE THIS BACK TO LEFT IF NEEDED
        //public static WPI_TalonSRX rightIntakeMotor = new WPI_TalonSRX(15); // change to 10, if we use it
        //TODO: REASON FOR COMMENTED OUT ^ ONLY ONE MOTOR
    }

    public static final class LimitSwitch
    {
        public static int barArmDownLimitSwitch = 0;
    }

    /**public static final class AutoConstants
    {

    }*/
}
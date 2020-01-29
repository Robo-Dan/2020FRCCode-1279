/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ClimbingRobotUp;
import frc.robot.commands.ControlPanel;
import frc.robot.commands.DriveAuto;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.KickerIn;
import frc.robot.commands.KickerOut;
import frc.robot.commands.MovingArmDown;
import frc.robot.commands.MovingArmUp;
import frc.robot.commands.PowerCellElevatorDownIntake;
import frc.robot.commands.PowerCellElevatorUpIntake;
import frc.robot.commands.PowerCellShooter;
import frc.robot.commands.SlowDriveTrain;
import frc.robot.commands.TriggerBasedPowerCellShooter;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
  // The robot's subsystems and commands are defined here...

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final DriveTrain m_robotDrive = new DriveTrain();
  private final DriveAuto autoDriveCommand = new DriveAuto(Robot.robotDriveTrain, Robot.powerCell);

  private PowerCellShooter shooting = new PowerCellShooter(Robot.powerCell);
  private PowerCellElevatorUpIntake movingIntakeUp = new PowerCellElevatorUpIntake(Robot.powerCell);
  private PowerCellElevatorDownIntake movingIntakeDown = new PowerCellElevatorDownIntake(Robot.powerCell);
  
  private MovingArmUp armUp = new MovingArmUp(Robot.climber);
  private MovingArmDown armDown = new MovingArmDown(Robot.climber);
  
  private SlowDriveTrain slowDrive = new SlowDriveTrain();
  
  private ClimbingRobotUp winchRobotUp = new ClimbingRobotUp(Robot.climber);

  private KickerIn moveKickerIn = new KickerIn(Robot.powerCell);
  private KickerOut moveKickerOut = new KickerOut(Robot.powerCell);

  private ControlPanel controlPanel = new ControlPanel(Robot.controlPanelSubSystem);

  private TriggerBasedPowerCellShooter triggeredPowerCell = new TriggerBasedPowerCellShooter(Robot.powerCell);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer()
  {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings()
  {
    //operator buttons
    Constants.DriverAndOperatorJoystick.operator_A_Button.toggleWhenPressed(triggeredPowerCell); //TODO: toggleWhenPressed changes the activity from on to off
    Constants.DriverAndOperatorJoystick.operator_B_Button.whenHeld(movingIntakeUp);
    Constants.DriverAndOperatorJoystick.operator_Y_Button.whenPressed(armUp);
    Constants.DriverAndOperatorJoystick.operator_X_Button.whenHeld(armDown);
    Constants.DriverAndOperatorJoystick.operator_leftShoulderButton.whenHeld(movingIntakeDown);
    Constants.DriverAndOperatorJoystick.operator_rightShoulderButton.whenHeld(winchRobotUp);
    Constants.DriverAndOperatorJoystick.operator_backButton.toggleWhenPressed(moveKickerIn);
    Constants.DriverAndOperatorJoystick.operator_startButton.toggleWhenPressed(moveKickerOut);
    Constants.DriverAndOperatorJoystick.operator_leftStickButton.whenHeld(controlPanel);
    //Constants.DriverAndOperatorJoystick.testTrigger.whenActive(triggeredPowerCell);
    

    //TODO: TO GET MORE BUTTONS, if(trigger.get() == true) { commands} else {other commands};
    //if we were to do that, make the less important commands be if holding the trigger

    //driver buttons
    Constants.DriverAndOperatorJoystick.driver_leftShoulderButton.whenHeld(slowDrive);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {
    // An ExampleCommand will run in autonomous
    //return autoDriveCommand;
    return autoDriveCommand;
  }
}

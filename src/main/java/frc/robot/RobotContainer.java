/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveAuto;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MovingArmDown;
import frc.robot.commands.MovingArmUp;
import frc.robot.commands.PowerCellIntake;
import frc.robot.commands.PowerCellShooter;
import frc.robot.commands.SlowDriveTrain;
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
  private PowerCellIntake intakeThePowerCell = new PowerCellIntake(Robot.powerCell);
  private MovingArmUp armUp = new MovingArmUp(Robot.climber);
  private MovingArmDown armDown = new MovingArmDown(Robot.climber);
  private SlowDriveTrain slowDrive = new SlowDriveTrain();

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
    Constants.DriverAndOperatorJoystick.driver_A_Button.whenHeld(shooting);
    Constants.DriverAndOperatorJoystick.driver_B_Button.whenHeld(intakeThePowerCell);
    Constants.DriverAndOperatorJoystick.driver_Y_Button.whenHeld(armUp);
    Constants.DriverAndOperatorJoystick.driver_X_Button.whenHeld(armDown);
    Constants.DriverAndOperatorJoystick.leftShoulderButton.whenHeld(slowDrive);
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

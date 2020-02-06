/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveAuto;
import frc.robot.subsystems.ClimbingSubsystem;
import frc.robot.subsystems.CompressorSubsystem;
import frc.robot.subsystems.ControlPanelSub;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Piston;
import frc.robot.subsystems.PowerCell;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
  private Command m_autonomousCommand;
  private DriveAuto driveAuto = new DriveAuto(robotDriveTrain, powerCell);

  private RobotContainer m_robotContainer;

  //TODO: add pneumatics code for Joe

  //section for subsystems
  public static DriveTrain robotDriveTrain = new DriveTrain();
  public static PowerCell powerCell = new PowerCell();
  public static ClimbingSubsystem climber = new ClimbingSubsystem();
  public static ControlPanelSub controlPanelSubSystem = new ControlPanelSub();
  public static Piston piston = new Piston();
  public static CompressorSubsystem compressorSubsystem = new CompressorSubsystem();
  //^^section for subsystems
  public static DifferentialDrive drive = new DifferentialDrive(Constants.TalonNames.m_left, Constants.TalonNames.m_right);

  
  // distance in inches the robot wants to stay from an object
  private static final double kHoldDistance = 12.0;

  // factor to convert sensor values to a distance in inches
  private static final double kValueToInches = 0.125;

  // proportional speed constant
  private static final double kP = 0.05;
  private static final int kUltrasonicPort = 0;

  private final AnalogInput m_ultrasonic = new AnalogInput(kUltrasonicPort);
  //TODO: Possibly make own class just for the distance sensor. that way, can make it work for auto
  UsbCamera forwardCamera;
  UsbCamera backwardCamera;

  //public static Compressor compressor = new Compressor(0);
  //public static DoubleSolenoid joesDoubleSolenoid = new DoubleSolenoid(1, 2);

  
  public static DigitalInput limitSwitchForArm = new DigitalInput(Constants.LimitSwitch.barArmDownLimitSwitch);
  public static Counter counterForArm = new Counter(limitSwitchForArm);

  //private final I2C.Port i2cPort = I2C.Port.kOnboard;
  //private final ColorMatch m_colorMatcher = new ColorMatch();
  //private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  /**private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);*/
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit()
  {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    forwardCamera = CameraServer.getInstance().startAutomaticCapture(0);
    backwardCamera = CameraServer.getInstance().startAutomaticCapture(1);
    //server = CameraServer.getInstance().addServer("Switched camera");
    //server = CameraServer.getInstance().addSwitchedCamera("Switched camera");
    forwardCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kAutoManage);
    forwardCamera.setFPS(60);
    forwardCamera.setResolution(320, 240);
    
    backwardCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kAutoManage);
    backwardCamera.setFPS(60);
    backwardCamera.setResolution(320, 240);

    //compressor.setClosedLoopControl(true);
    //compressor.setClosedLoopControl(false);

    //boolean enabled = compressor.enabled();
    //boolean pressureSwitch = compressor.getPressureSwitchValue();
    //double current = compressor.getCompressorCurrent();

    //compressor.start();

    //compressor.start();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic()
  {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    //compressor.start();
    
    // sensor returns a value from 0-4095 that is scaled to inches
    
    // convert distance error to a motor speed
    double currentDistance = (m_ultrasonic.getValue() * kValueToInches) / 2.54;
  
    double currentSpeed = (kHoldDistance - currentDistance) * kP;

    //double possibleFixToErrorInDistance = kHoldDistance - currentDistance;

    SmartDashboard.putNumber("Distance (in inches):", currentDistance); //Outputs 
    SmartDashboard.putNumber("CurrentSpeed: ", currentSpeed);
    //SmartDashboard.putNumber("Possible Fix for Distance (in inches)", possibleFixToErrorInDistance);

    double autoNumber = SmartDashboard.getNumber("Autonomous Number", 0); //the zero is the default value. make that the just shoot and back up
    
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    gameData.toUpperCase(); //this makes it so that the gamedata that we get is capitalized and the code returned works
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
        //Blue case code
        //when blue sent, do this
        SmartDashboard.putString("Spin the Control Panel to color: ", "BLUE");
        break;
        case 'G' :
        SmartDashboard.putString("Spin the Control Panel to color: ", "GREEN");
        //Green case code
        //when green sent, do this
        break;
        case 'R' :
        SmartDashboard.putString("Spin the Control Panel to color: ", "RED");
        //Red case code
        //when red sent, do this
        break;
        case 'Y' :
        SmartDashboard.putString("Spin the Control Panel to color: ", "YELLOW");
        //Yellow case code
        //when yellow sent, do this
        break;
        default :
        SmartDashboard.putString("Spin the Control Panel to color: ", "UNKNOWN COLOR");
       //This is corrupt data
       //when field sents a value not one of the above
        break;
        }
    }
    else
    {
      SmartDashboard.putString("Spin the Control Panel to color: ", "NOTHING YET");
      //Code for no data received yet
    }

    //Color detectedColor = m_colorSensor.getColor();

   // double IR = m_colorSensor.getIR();

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    /*SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);*/

  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit()
  {
    //compressor.stop();
  }

  @Override
  public void disabledPeriodic()
  {

  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit()
  {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null)
    {
      m_autonomousCommand.schedule();

    }

    Constants.TalonNames.frontLeft.configFactoryDefault();
    Constants.TalonNames.frontRight.configFactoryDefault();
    Constants.TalonNames.rearLeft.configFactoryDefault();
    Constants.TalonNames.rearRight.configFactoryDefault();

    // adjust these so that when the stick is forward both of these are green
    Constants.TalonNames.frontLeft.setInverted(false);
    Constants.TalonNames.rearLeft.setInverted(false);
    Constants.TalonNames.frontRight.setInverted(true); 
    Constants.TalonNames.rearRight.setInverted(true);
    // DO NOT TOUCH THIS OR YOU WILL GRENADE THE TRANSMISSION

    drive.setRightSideInverted(false); // don't change this

    drive.setSafetyEnabled(false);
        // end of drivetrain stuff

    drive.setExpiration(2);
    drive.setSafetyEnabled(false);
    
    Constants.TalonNames.frontLeft.setSafetyEnabled(false);
    Constants.TalonNames.rearLeft.setSafetyEnabled(false);
    Constants.TalonNames.frontRight.setSafetyEnabled(false);
    Constants.TalonNames.rearRight.setSafetyEnabled(false);

    //Constants.TalonNames.hatchTalon.setSafetyEnabled(false);

    //robotDriveTrain.setDirectionBack(); // starts the match with hatch as forward
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic()
  {
    //robotDriveTrain.driveAuto();

    //SmartDashboard.putNumber("Distance (in inches):", currentDistance); //Outputs 
    //SmartDashboard.putString("Test", "Hello");
  }

  @Override
  public void teleopInit()
  {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null)
    {
      m_autonomousCommand.cancel();
    }

    Constants.TalonNames.frontLeft.configFactoryDefault();
    Constants.TalonNames.frontRight.configFactoryDefault();
    Constants.TalonNames.rearLeft.configFactoryDefault();
    Constants.TalonNames.rearRight.configFactoryDefault();

    // adjust these so that when the stick is forward both of these are green
    Constants.TalonNames.frontLeft.setInverted(false);
    Constants.TalonNames.rearLeft.setInverted(false);
    Constants.TalonNames.frontRight.setInverted(true); 
    Constants.TalonNames.rearRight.setInverted(true);
    // DO NOT TOUCH THIS OR YOU WILL GRENADE THE TRANSMISSION

    drive.setRightSideInverted(false); // don't change this

    drive.setSafetyEnabled(false);
        // end of drivetrain stuff

    drive.setExpiration(2);
    drive.setSafetyEnabled(false);
    
    Constants.TalonNames.frontLeft.setSafetyEnabled(false);
    Constants.TalonNames.rearLeft.setSafetyEnabled(false);
    Constants.TalonNames.frontRight.setSafetyEnabled(false);
    Constants.TalonNames.rearRight.setSafetyEnabled(false);

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {

    
    robotDriveTrain.robotDrive();

  }

  @Override
  public void testInit()
  {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic()
  {

  }
}

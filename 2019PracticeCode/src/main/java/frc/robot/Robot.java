package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.GyroPrint;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TurnFunction;
import frc.robot.subsystems.DriveTrain;
// import frc.robot.subsystems.ExampleIntake;
import frc.robot.subsystems.GyroSubsystem;

public class Robot extends TimedRobot {
  // public static ExampleIntake intake;
  public static TurnFunction turnFunction;
  public static GyroSubsystem gyroSub;
  public static DriveTrain driveTrain;
  public static OI oi;
  public static ArcadeDrive arcadeDrive;
  public static TankDrive tankDrive;
  public static GyroPrint gyroPrint;


  @Override
  public void robotInit() {

    
    driveTrain = new DriveTrain();
    gyroSub = new GyroSubsystem();
    oi = new OI();
    tankDrive = new TankDrive();
    arcadeDrive = new ArcadeDrive();
    turnFunction = new TurnFunction();
    // intake = new ExampleIntake();
    gyroPrint = new GyroPrint();
    
    System.out.println("Robot Initialized");
  }

  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();

  }
  
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {  
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() { 
    //arcadeDrive.start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }

  @Override
    public void testPeriodic() {
  }
}

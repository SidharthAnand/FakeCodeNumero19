package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ArcadeDrive extends Command {
  
  private boolean isFinished = false;

  public ArcadeDrive() {
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    // The actual code for the arcade drive
    
    Robot.driveTrain.setLeftMotors(Robot.oi.getRightX()+Robot.oi.getLeftY());
    Robot.driveTrain.setRightMotors(-Robot.oi.getRightX()+Robot.oi.getLeftY());
    SmartDashboard.putString("Command active", " Arcade Drive");

    //Robot.oi.joystickX.cancelWhenPressed(this);
  }             

  @Override
  protected boolean isFinished() {
    
    return isFinished;
  }

  @Override
  protected void end() {
    Robot.driveTrain.turnController.disable();

    Robot.driveTrain.setLeftMotors(0);
    Robot.driveTrain.setRightMotors(0);
    System.out.println("End Arcade Command");

    //Robot.tankDrive.start();
    
  }

  @Override
  protected void interrupted() {
    this.end();
  }
}

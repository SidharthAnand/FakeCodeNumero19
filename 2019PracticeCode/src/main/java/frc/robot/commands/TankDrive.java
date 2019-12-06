package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class TankDrive extends Command {

  private boolean isFinished = false;
  

  public TankDrive() {
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.driveTrain.setLeftMotors(Robot.oi.getLeftY());
    Robot.driveTrain.setRightMotors(Robot.oi.getRightY());
    SmartDashboard.putString("Command active", " Tank Drive");

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
    System.out.println("End Tank Drive Command");

    //Robot.arcadeDrive.start();
  }

  @Override
  protected void interrupted() {
    this.end();
  }
}

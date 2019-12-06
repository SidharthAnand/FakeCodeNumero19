package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.lang.Math;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class TurnFunction extends Command {
  
    boolean isFinished = false;
    int count = 0;

    public TurnFunction() {
        SmartDashboard.putString("turn", "Starting Instantiating contructor");
        requires(new DriveTrain());
        
    }
    
    @Override
    protected void initialize() {
        SmartDashboard.putString("turn", "rotate degrees");
        Robot.driveTrain.rotateDegrees(45.0);
    }

    @Override
    protected void execute() {
    SmartDashboard.putString("turn", "getting error");
    double error = Robot.driveTrain.turnController.getError();

    if (Math.abs(error) < 2.0) {
        count++;
        isFinished = count >= 5;
    } 
    else {
        count = 0;
    }

    }
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        SmartDashboard.putString("turn", "quit");
        return isFinished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        SmartDashboard.putString("turn", "pid controller quit");
        Robot.driveTrain.turnController.disable();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
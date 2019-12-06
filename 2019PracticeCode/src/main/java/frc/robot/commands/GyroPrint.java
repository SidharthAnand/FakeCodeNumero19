package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class GyroPrint extends Command {

    public GyroPrint() {
        requires(Robot.gyroSub);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Gyro Roll", Robot.gyroSub.getGyroValues("roll"));
        SmartDashboard.putNumber("Gyro Yaw", Robot.gyroSub.getGyroValues("yaw"));
        SmartDashboard.putNumber("Gyro Pitch", Robot.gyroSub.getGyroValues("pitch"));
        SmartDashboard.putNumber("Horizontal Angle", Robot.gyroSub.getAngle());
    
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.gyroSub.resetGyro();
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}

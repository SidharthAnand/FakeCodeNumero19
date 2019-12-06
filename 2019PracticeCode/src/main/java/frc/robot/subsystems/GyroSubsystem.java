package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.GyroPrint;

public class GyroSubsystem extends Subsystem {

    public AHRS ahrs;

    private double gyroBasePitch = 0.0;
    private double gyroBaseRoll = 0.0;

    public GyroSubsystem() {
    ahrs = new AHRS(Port.kUSB);
  }

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new GyroPrint());
  }

  public double getAngle(){
    double ang = Math.round(ahrs.getAngle());
    return ang;
  }

  public double getGyroValues(String measurement){
    double pitch = ahrs.getPitch() - gyroBasePitch;
    double roll = ahrs.getRoll() - gyroBaseRoll;
    double yaw = ahrs.getYaw();

    if (measurement.toLowerCase().equals("pitch")){
      return pitch;
    }
    if (measurement.toLowerCase().equals("roll")){
      return roll;
    }
    else{
      return yaw;
    }
    
  }

  public void resetGyro(){
    ahrs.reset();
  }

}


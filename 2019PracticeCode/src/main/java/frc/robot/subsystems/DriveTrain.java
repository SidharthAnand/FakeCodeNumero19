/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

public class DriveTrain extends Subsystem implements PIDOutput{

  private TalonSRX leftMotor1;
  private VictorSPX leftMotor2;
  //private VictorSPX leftMotor3;
  private TalonSRX rightMotor1;
  private VictorSPX rightMotor2;
  //private VictorSPX rightMotor3;

  public final PIDController turnController;

  private double kP = 0.001;
  private double kI = 0;
  private double kD = 0;
  private double tolerance = 2.0;

  private double percentSpeed = 0.4;

  public DriveTrain(){
    leftMotor1 = new TalonSRX(RobotMap.LEFT_MOTOR_9419_1);
    leftMotor2 = new VictorSPX(RobotMap.LEFT_MOTOR_9419_2);
    //leftMotor3 = new VictorSPX(RobotMap.LEFT_MOTOR_3);
    rightMotor1 = new TalonSRX(RobotMap.RIGHT_MOTOR_9419_1);
    rightMotor2 = new VictorSPX(RobotMap.RIGHT_MOTOR_9419_2);
    //rightMotor3 = new VictorSPX(RobotMap.RIGHT_MOTOR_3);

    leftMotor1.setInverted(true);
    leftMotor2.setInverted(true);
    //leftMotor3.setInverted(true);

    turnController = new PIDController(kP, kI, kD, Robot.gyroSub.ahrs, this);
    
    turnController.setInputRange(-180, 180);
    turnController.setOutputRange(-0.5,0.5);
    turnController.setAbsoluteTolerance(tolerance);
    turnController.setContinuous();

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(Robot.arcadeDrive);

  }

  public void setLeftMotors(double speed){
    leftMotor1.set(ControlMode.PercentOutput, speed*percentSpeed);
    leftMotor2.set(ControlMode.PercentOutput, speed*percentSpeed);
    //leftMotor3.set(ControlMode.PercentOutput, speed*percentSpeed);

  }

  public void setRightMotors(double speed){
    rightMotor1.set(ControlMode.PercentOutput, speed*percentSpeed);
    rightMotor2.set(ControlMode.PercentOutput, speed*percentSpeed);
    //rightMotor3.set(ControlMode.PercentOutput, speed*percentSpeed);

  }

  @Override
  public void pidWrite(double output){
    setRightMotors(output);
    setLeftMotors(-output);
  }

  public void rotateDegrees(double angle){
    Robot.gyroSub.resetGyro();
    turnController.setPID(kP, kI, kD);
    turnController.reset();
    turnController.setSetpoint(angle);
    turnController.enable();


  }

}

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;

public class OI {

  public JoystickButton joystickX;
  public JoystickButton shoulderLeft;

  public OI() {
    joystickX = new JoystickButton(controllerOne, RobotMap.GamePadButtonX);
    shoulderLeft = new JoystickButton(controllerOne, RobotMap.ShoulderLeft);

    joystickX.toggleWhenPressed(Robot.arcadeDrive);
    joystickX.toggleWhenPressed(Robot.tankDrive);
    shoulderLeft.whenPressed(Robot.turnFunction);
  }
  
  private XboxController controllerOne = new XboxController(RobotMap.CONTROLLER_ONE);
  //XboxController controllerTwo = new XboxController(RobotMap.CONTROLLER_TWO);

  public boolean getButtonA() {
		return controllerOne.getRawButton(RobotMap.GamePadButtonA);
  }
  
  // public boolean getShoulderLeft(){
  //   return controllerOne.getRawButton(RobotMap.ShoulderLeft);
  // }

  public boolean getButtonB() {
		return controllerOne.getRawButton(RobotMap.GamePadButtonB);
  }

  // public boolean getButtonX(){
  //   return controllerOne.getRawButton(RobotMap.GamePadButtonX);
  // }

  public double getRightX() {
    double val = controllerOne.getRawAxis(RobotMap.RIGHT_STICK_X);
    if (Math.abs(val)<0.07){
      val = 0;
    }
    return val;
  }

  public double getRightY() {
    double val = controllerOne.getRawAxis(RobotMap.RIGHT_STICK_Y);
    if (Math.abs(val)<0.07){
      val = 0;
    }
    return val;
  }

  public double getLeftY() {
    double val = controllerOne.getRawAxis(RobotMap.LEFT_STICK_Y);
    if (Math.abs(val)<0.07){
      val = 0;
    }
    return val;
  }

  public double getLeftX() {
    double val = controllerOne.getRawAxis(RobotMap.LEFT_STICK_X);
    if (Math.abs(val)<0.07){
      val = 0;
    }
    return val;
  }
  
}
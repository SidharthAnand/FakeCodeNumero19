// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.VictorSPX;
// import edu.wpi.first.wpilibj.Talon;
// import edu.wpi.first.wpilibj.command.Subsystem;
// import frc.robot.RobotMap;
// import frc.robot.commands.ExampleIntakeCommand;

// public class ExampleIntake extends Subsystem {
//   // Put methods for controlling this subsystem
//   // here. Call these from Commands.
  
//   private VictorSPX intakeMotor;

//   public ExampleIntake(){
//     intakeMotor = new VictorSPX(RobotMap.INTAKE_MOTOR);
//   }

//   @Override
//   public void initDefaultCommand() {
//     setDefaultCommand(new ExampleIntakeCommand());
//   }

//   public void inputCargo(double speed){
//     intakeMotor.set(ControlMode.PercentOutput, speed);

//   }

//   public void outputCargo(double speed){
//     intakeMotor.set(ControlMode.PercentOutput, -speed);

//   }

// }

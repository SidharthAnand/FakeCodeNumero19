// package frc.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;

// /**
//  * An example command.  You can replace me with your own command.
//  */
// public class ExampleIntakeCommand extends Command {
//   public ExampleIntakeCommand() {
//     // Use requires() here to declare subsystem dependencies
//     requires(Robot.intake);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
  
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {

//     if (Robot.oi.getButtonA()){
//       Robot.intake.inputCargo(0.5);
//     }

//     else{
//       Robot.intake.inputCargo(0);
//       Robot.intake.inputCargo(0);
//     }

//     if (Robot.oi.getButtonB()){
//       Robot.intake.outputCargo(0.5);
//     }

//     else{
//       Robot.intake.inputCargo(0);
//       Robot.intake.outputCargo(0);
//     }

//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   protected boolean isFinished() {
//     return false;
//   }

//   // Called once after isFinished returns true
//   @Override
//   protected void end() {
//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//   }
// }

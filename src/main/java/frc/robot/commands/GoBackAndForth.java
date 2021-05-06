// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class GoBackAndForth extends CommandBase {
  //makes robot go backwards and forwards for 3 times
  private final DriveTrain drivetrain;
  private final Timer timer;

  /** Creates a new GoBackAndForth. */
  public GoBackAndForth(DriveTrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    int direction = 1;
    
    for(int i = 0; i < 6; i++){
      timer.reset();
      timer.start();
      while(timer.get() < 2){
        drivetrain.drive(direction*0.5, direction*0.5);
        direction *= -1;
      }
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

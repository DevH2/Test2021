// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsytems.DriveTrain;


public class DriveStraight extends CommandBase {

  private final DriveTrain drivetrain;
  private Timer timer;

  
  
  /** Creates a new DriveStraight. */
  public DriveStraight(DriveTrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    timer = new Timer();
    drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    while(timer.get() < 2){
      drivetrain.drive(0.5, 0.5);
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
    return true;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnAround extends CommandBase {
  //makes robot do 188 degree turn
  private final DriveTrain drivetrain;

  /** Creates a new DriveCwCircle. */
  public TurnAround(DriveTrain drivetrain) {
    this.drivetrain = drivetrain;

    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double initialAngle = drivetrain.getAngle();
    while(drivetrain.getAngle() < initialAngle+180){
      drivetrain.drive(0.5,-0.5);
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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Spin extends CommandBase {
  //spins in place 4 times
  private final DriveTrain drivetrain;
  private int numSpins;

  /** Creates a new DriveCwCircle. */
  public Spin(DriveTrain drivetrain) {
    this.drivetrain = drivetrain;

    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double targetDegrees = 359;
    for(numSpins = 0; numSpins < 4; numSpins ++){
      while(drivetrain.getAngle() < targetDegrees){
        drivetrain.drive(0.5,-0.5);
      }
      targetDegrees --;
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
    return numSpins == 4;
  }
}

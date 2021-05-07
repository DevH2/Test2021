// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveForward extends CommandBase {
  //makes robot go forward

  private final DriveTrain drivetrain;
  private final Timer timer;

  /** Creates a new DriveCwCircle. */
  public DriveForward(DriveTrain drivetrain) {
    this.drivetrain = drivetrain;
    timer  = new Timer();
    addRequirements(this.drivetrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < 2){
      drivetrain.drive(0.5,0.5);
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

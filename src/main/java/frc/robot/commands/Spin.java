// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsytems.DriveTrain;

public class Spin extends CommandBase {
  private final DriveTrain m_drivetrain;
  private double m_targetDegree;

  /** Creates a new Spin. */
  public Spin(double turnDegrees, DriveTrain drivetrain, GyroScope gyroscope) {
    m_drivetrain = drivetrain;

    m_targetDegree = turnDegrees + m_drivetrain.getAngle();

    addRequirements(m_drivetrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    while(m_drivetrain.getAngle() < m_targetDegree){
      m_drivetrain.rotateDegrees();
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

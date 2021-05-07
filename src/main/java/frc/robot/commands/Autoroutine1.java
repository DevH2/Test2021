// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;


public class Autoroutine1 extends SequentialCommandGroup {
  //drives in circles and spins a lot
  /** Creates a new Autoroutine1. */
  public Autoroutine1(DriveTrain drivetrain) {

    addCommands(
      new DriveCwCircle(drivetrain),
      new DriveForward(drivetrain),
      new DriveCcwCircle(drivetrain),
      new Spin(drivetrain),
      new TurnAround(drivetrain),
      new DriveForward(drivetrain),
      new TurnAround(drivetrain),
      new Spin(drivetrain)
    );
  }
}
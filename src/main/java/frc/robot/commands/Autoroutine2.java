// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Autoroutine2 extends SequentialCommandGroup {
  //Does a lot of arm moving up and down and also moves a bit
  /** Creates a new Autoroutine2. */
  public Autoroutine2(DriveTrain drivetrain, Arm arm) {

    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ArmWiggle(arm),
      new DriveForward(drivetrain),
      new ArmWiggle(arm),
      new TurnAround(drivetrain),
      new ArmWiggle(arm),
      new DriveForward(drivetrain),
      new TurnAround(drivetrain),
      new ArmWiggle(arm)
    );
  }
}

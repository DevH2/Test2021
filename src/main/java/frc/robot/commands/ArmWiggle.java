// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmWiggle extends CommandBase {

//moves arm up and down twice

private final Arm arm;
private final Timer timer;

  /** Creates a new DriveCwCircle. */
  public ArmWiggle(Arm arm) {
    timer = new Timer();
    addRequirements(arm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    for(int i = 0, i < 2; i++){
      while(!arm.getLimitSwitch() && timer.get() < 2){
        arm.moveUp();
      }
      while(timer.get() >= 2 && timer.get()< 4){
        arm.moveDown();
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


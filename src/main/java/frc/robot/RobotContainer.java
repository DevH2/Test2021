// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmWiggle;
import frc.robot.commands.Autoroutine1;
import frc.robot.commands.Autoroutine2;
import frc.robot.commands.DriveCcwCircle;
import frc.robot.commands.GoBackAndForth;
import frc.robot.commands.RotateArm;
import frc.robot.commands.Spin;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public static Joystick leftJoystick = new Joystick(Constants.LEFT_JOY_USB_PORT), rightJoystick = new Joystick(Constants.RIGHT_JOY_USB_PORT);
  private final Arm arm;
  private final DriveTrain driveTrain;

  private final RotateArm rotateArm;
  private final Autoroutine1 autoroutine1;
  private final Autoroutine2 autoroutine2;
  
  private SendableChooser<Command> sendableChooser;

  public RobotContainer() {

    driveTrain = new DriveTrain();
    arm = new Arm();

    rotateArm = new RotateArm(arm);

    arm.setDefaultCommand(rotateArm);
    driveTrain.setDefaultCommand(new RunCommand(() -> driveTrain.drive(leftJoystick.getRawAxis(Constants.LEFT_JOY_AXIS), rightJoystick.getRawAxis(Constants.RIGHT_JOY_AXIS))));

    autoroutine1 = new Autoroutine1(driveTrain);
    autoroutine2 = new Autoroutine2(driveTrain, arm);
    sendableChooser = new SendableChooser<>();
    sendableChooser.addOption("Autoroutine1", autoroutine1);
    sendableChooser.addOption("Autoroutine2", autoroutine2);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(leftJoystick, Constants.LEFT_JOY_BUTTON_WIGGLE_ARM)
      .whenPressed(new ArmWiggle(arm));

    new JoystickButton(leftJoystick, Constants.LEFT_JOY_BUTTON_SPIN)
      .whenPressed(new Spin(driveTrain));

    new JoystickButton(rightJoystick, Constants.RIGHT_JOY_BUTTON_DRIVE_CIRCLE)
      .whenPressed(new DriveCcwCircle(driveTrain));

    new JoystickButton(rightJoystick, Constants.RIGHT_JOY_BUTTON_GO_BACK_AND_FORTH)
      .whenPressed(new GoBackAndForth(driveTrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return sendableChooser.getSelected();
  }
}

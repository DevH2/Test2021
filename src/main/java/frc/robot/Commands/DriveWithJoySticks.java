package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.Drivetrain;

public class DriveWithJoysticks extends CommandBase{
    private Drivetrain driveTrain;

    public DriveWithJoysticks(Drivetrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        driveTrain.driveWithJoysticks(RobotContainer.leftJoystick.getRawAxis(Constants.LEFT_JOYSTICK_AXIS),RobotContainer.rightJoystick.getRawAxis(Constants.RIGHT_JOYSTICK_AXIS));
    }
    @Override
    public void end(boolean interrupted){
        driveTrain.stop();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

//File not necessary.
public class DriveWithJoysticks extends CommandBase {
    private DriveTrain driveTrain;

    public DriveWithJoysticks(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        addRequirements(this.driveTrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveTrain.drive(RobotContainer.leftJoystick.getRawAxis(Constants.LEFT_JOY_AXIS), RobotContainer.rightJoystick.getRawAxis(Constants.RIGHT_JOY_AXIS));
    }

    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}

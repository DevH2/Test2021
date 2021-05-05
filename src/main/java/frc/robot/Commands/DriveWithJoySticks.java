package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

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
        driveTrain.driveWithJoysticks();

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
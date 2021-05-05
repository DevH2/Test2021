package frc.robot.commands;

public class RotateArm extends CommandBase {
    private Arm am;
    public RotateArm(Arm arm){
        this.arm = arm;
        addRequirements(arm);
    }
    @Override
    public void execute(){
        if (arm.getLimitSwitch()) {
            arm.stopRotate();
        } else {
            arm.rotate(RobotContainer.leftJoystick, RobotContainer.rightJoystick);
        }
    } 
    
    @Override
    public void end(boolean interrupted){
        
    }

    @Override 
    public boolean isFinished(){
        return false;
    }
}

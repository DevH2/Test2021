package frc.robot.commands;

public class RotateArm extends CommandBase {
    private Arm am;
    public RotateArm(Arm arm){
        this.arm = arm;
        addRequirements(arm);
    }
    @Override
    public void execute(){
        boolean leftTriggered = RobotContainer.leftJoystick.getTriggerPressed()
        boolean rightTriggered = RobotContainer.rightJoystick.getTriggerPressed()
    
        public void rotate(leftTriggered, rightTriggered){
            if (leftTriggered && !rightTriggered) {
                armMotor.moveUp();
            } else if (rightTriggered && leftTriggered) {
                armMotor.moveDown();
            } else {
                armMotor.setSpeed(0);
            }
        }
        
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

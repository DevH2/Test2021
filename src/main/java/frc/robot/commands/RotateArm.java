package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;

public class RotateArm extends CommandBase {

    private Arm arm;

    public RotateArm(Arm arm){
        this.arm = arm;
        addRequirements(this.arm);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        boolean LTriggerPressed = RobotContainer.leftJoystick.getTriggerPressed();
        boolean RTriggerPressed = RobotContainer.rightJoystick.getTriggerPressed();

        if(arm.getLimitSwitch()){
           arm.stopMove();
        } else if(LTriggerPressed && !RTriggerPressed){ 
            arm.moveUp();
        } else if(RTriggerPressed && !LTriggerPressed){ 
            arm.moveDown();
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

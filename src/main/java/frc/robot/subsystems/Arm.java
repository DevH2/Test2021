package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    private VictorSP armMotor;
    private DigitalInput topLimitSwitch;
    public Arm(){
        armMotor = new VictorSP(Constants.ARM_MOTOR_CAN_ID);

        topLimitSwitch = new DigitalInput(Constants.LIMIT_SWITCH_DIO);
    }

    public boolean getLimitSwitch(){return topLimitSwitch.get();}

    public void moveUp(){
        if(!topLimitSwitch.get()){
            armMotor.setSpeed(Constants.ARM_UP_SPEED);
        }
    }

    public void moveDown(){
        if(!topLimitSwitch.get()){
            armMotor.setSpeed(Constants.ARM_DOWN_SPEED);
        }
    }
    
    public void stopMove(){
        armMotor.setSpeed(0);
    }
}

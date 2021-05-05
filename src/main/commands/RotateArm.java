import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    private VictorSP armMotor;
    private DigitalInput limitSwitch;

    public Arm(){
        armMotor = new VictorSP(Constants.ARM_MOTOR_CAN_ID)
        limitSwitch = new DigitalInput(Constants.ARM_MOTOR_SWITCH_ID);
    }

    public boolean getLimitSwitch(){
        return limitSwitch.get();
    }

    public void rotate(Joystick leftJoy, Joystick rightJoy){
        if (leftJoy.getTrigger() && !rightJoy.getTrigger()) {
            armMotor.setSpeed(Constants.moveUp);
        } else if (rightJoy.getTrigger() && !leftJoy.getTrigger()) {
            armMotor.setSpeed(Constants.moveDown);
        } else {
            armMotor.setSpeed(Constants.stop);
        }
    }

    public void stopRotate(){
        armMotor.setSpeed(Constants.stop);
    }
}

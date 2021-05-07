package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{

    private VictorSP leftFront, leftRear, rightFront, rightRear;
    private SpeedControllerGroup leftMotors, rightMotors;
    private DifferentialDrive drive;

    private AnalogGyro gyroscope;
    private Ultrasonic distanceSensor;

    public DriveTrain(){
    
        leftFront = new VictorSP(Constants.LEFT_FRONT_MOTOR_CAN_ID);
        leftRear = new VictorSP(Constants.LEFT_REAR_MOTOR_CAN_ID);
        rightFront = new VictorSP(Constants.RIGHT_FRONT_MOTOR_CAN_ID);
        rightRear = new VictorSP(Constants.RIGHT_REAR_MOTOR_CAN_ID);

        leftMotors = new SpeedControllerGroup(leftFront,leftRear);
        rightMotors = new SpeedControllerGroup(rightFront, rightRear);
        rightMotors.setInverted(true);
        leftMotors.setInverted(false);

        drive = new DifferentialDrive(leftMotors, rightMotors);

        gyroscope = new AnalogGyro(Constants.GYRO_ANALOG_INPUT);
        distanceSensor = new Ultrasonic(Constants.DISTANCE_SENSOR_PING,Constants.DISTANCE_SENSOR_ECHO);
        Ultrasonic.setAutomaticMode(true);

    }

    public void drive(double leftSpeed, double rightSpeed){
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    //Get distance sensor values;
    public double getRangeInches(){return distanceSensor.getRangeInches();}

    //Get gyroscope values;
    public double getAngle(){return gyroscope.getAngle();}

    public int getCenter(){return gyroscope.getCenter();}

    public double getRotationRate(){return gyroscope.getRate();}
    
    public double getOffset(){return gyroscope.getOffset();}

    public Ultrasonic.Unit getDistanceUnits(){return distanceSensor.getDistanceUnits();}

    @Override
    public void periodic(){
       //Update Smartdashboard
       SmartDashboard.putNumber("Current Angle: ", gyroscope.getAngle());
       SmartDashboard.putNumber("Gyro Center: ", gyroscope.getCenter());
       SmartDashboard.putNumber("Rate of Rotation: ", gyroscope.getRate());
       SmartDashboard.putNumber("Distance to Target", distanceSensor.getRangeInches());
       
    }
}

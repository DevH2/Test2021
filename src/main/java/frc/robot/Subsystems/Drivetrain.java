package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {
    private VictorSP leftFront, rightFront, leftRear, rightRear;
    private SpeedControllerGroup leftMotors, rightMotors;
    private DifferentialDrive drive;
    private AnalogGyro gyro;
    private Ultrasonic distanceSensor;
    
    public Drivetrain(){
        leftFront = new VictorSP(Constants.LEFT_FRONT_MOTOR_CAN_ID);
        rightFront = new VictorSP(Constants.RIGHT_REAR_MOTOR_CAN_ID);
        leftRear = new VictorSP(Constants.LEFT_REAR_MOTOR_CAN_ID);
        rightRear = new VictorSP(Constants.LEFT_REAR_MOTOR_CAN_ID);
        
        leftMotors = new SpeedControllerGroup(leftFront,leftRear);
        rightMotors = new SpeedControllerGroup(rightFront,rightRear);
        drive = new DifferentialDrive (leftMotors,rightMotors);

        leftMotors.setInverted(true);
        rightMotors.setInverted(false);

        gyro = new AnalogGyro(Constants.GYRO_ID);
        distanceSensor = new Ultrasonic(Constants.DISTANCE_SENSORE_PING_CHANNEL, Constants.DISTANCE_SENSORE_ECHO_CHANNEL);
        Ultrasonic.setAutomaticMode(true);

    }
    @Override
    public void periodic() {
    }
    //Driving
    public void driveWithJoysticks(double leftSpeed, double rightSpeed){
        drive.tankDrive(leftSpeed,rightSpeed);
    }

    public void stop(){
        drive.stopMotor();
    }

    //Gyro Sensor
    public void initializeGyro(){
        gyro.initGyro();
    }

    public double getGyroAngle(){
        return gyro.getAngle();
    }

    public double getGyroRate(){
        return gyro.getRate();
    }

    public double getGyroCenter(){
        return gyro.getCenter();
    }

    public double getGyroOffset(){
        return gyro.getOffset();
    }
    public void stopGyro(){
        gyro.reset();
    }

    //Distance Sensor
    public double getRangeInches(){
        return distanceSensor.getRangeInches();
    }

    public void enableDistanceSensor(boolean enable){
        distanceSensor.setEnabled(enable);
    }

    public void setDistanceUnits(Ultrasonic.Unit units){
        distanceSensor.setDistanceUnits(units);
    }

    public Ultrasonic.Unit getDistanceUnit(){
        return distanceSensor.getDistanceUnits();
    }

    public void stopDistanceSensor(){
        distanceSensor.close();
    }
}   

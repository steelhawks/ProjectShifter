/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steelhawks.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import steelhawks.Constants;
import steelhawks.commands.Drive;

/**
 *
 * @author Neil
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final double Kp = 1.0, Ki = 0.0, Kd = 0.0;
    private Talon leftFront, leftMiddle, leftBack,
                rightFront, rightMiddle, rightBack;
    private Relay relay;
    private Encoder leftEncoder, rightEncoder;
    private Compressor compressor;
    
    public Drivetrain(){
        //super("Drivetrain", Kp, Ki, Kd);
        //setA 
        leftFront = new Talon(Constants.leftFront);
        leftMiddle = new Talon(Constants.leftMiddle);
        leftBack = new Talon(Constants.leftBack);
        rightFront = new Talon(Constants.rightFront);
        rightMiddle = new Talon(Constants.rightMiddle);
        rightBack = new Talon(Constants.rightBack);
        relay = new Relay(Constants.shifter);
        compressor = new Compressor(Constants.pressureGauge, Constants.compressor);
        compressor.start();
        
        leftEncoder = new Encoder(Constants.leftEncoderA, Constants.leftEncoderB);
        rightEncoder = new Encoder(Constants.rightEncoderA, Constants.rightEncoderB);
        leftEncoder.setDistancePerPulse(Constants.DISTANCE_PER_PULSE);
        rightEncoder.setDistancePerPulse(Constants.DISTANCE_PER_PULSE);
        leftEncoder.start();
        rightEncoder.start();
    }   
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Drive());
    }
    
    public void simpleTankDrive(Joystick leftStick, Joystick rightStick){
        double left = leftStick.getY();
        double right = -rightStick.getY();
        if(left>-0.075&&left<0.075) left = 0;
        if(right>-0.075&&right<0.075) right = 0;
        left = left*left*left;
        right = right*right*right;
        leftFront.set(left);
        leftMiddle.set(left);
        leftBack.set(left);
        rightFront.set(right);
        rightMiddle.set(right);
        rightBack.set(right);
        System.out.println("leftEncoder: " + leftEncoder.getDistance() + ", rightEncoder: " + rightEncoder.getDistance());
    }
    
    public void shiftHigh(){
        relay.set(Relay.Value.kForward);
    }
    
    public void shiftLow(){
        relay.set(Relay.Value.kReverse);
    }
    
    public void reset(){
        leftEncoder.reset();
        rightEncoder.reset();
    }
}
;
package steelhawks;

/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //Constants
    public static final int DISTANCE_PER_PULSE = 384 ;//63R128, 3:1
    
    //Drivetrain
    public static final int rightFront = 1;
    public static final int rightMiddle = 2;
    public static final int rightBack = 3;
    public static final int leftFront = 4;
    public static final int leftMiddle = 5;
    public static final int leftBack = 6;
    public static final int leftEncoderA = 1;
    public static final int leftEncoderB = 2;
    public static final int rightEncoderA = 3;
    public static final int rightEncoderB = 4;
    
    //Pneumatics
    public static final int compressor = 3;
    public static final int pressureGauge = 12;
    public static final int shifter = 6;
    
}

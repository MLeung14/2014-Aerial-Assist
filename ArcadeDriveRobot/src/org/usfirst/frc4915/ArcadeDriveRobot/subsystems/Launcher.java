// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4915.ArcadeDriveRobot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4915.ArcadeDriveRobot.RobotMap;
import org.usfirst.frc4915.ArcadeDriveRobot.commands.StopWindingMotor;
/**
 *
 */
public class Launcher extends Subsystem {
    private boolean hasLaunched = true;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController windingMotor = RobotMap.launcherWindingMotor;
    DoubleSolenoid pneumaticPistonDoubleSolenoid = RobotMap.launcherPneumaticPistonDoubleSolenoid;
    DigitalInput limitSwitchForLauncherDown = RobotMap.launcherLimitSwitchForLauncherDown;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new StopWindingMotor());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * extendPneumatics
     *
     * Pushes the pneumatic cylinder out
     */
    public void pneumaticsForward() {
        pneumaticPistonDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    /**
     * pneumaticsStop
     *
     * Stops filling the cylinder. Will not retract it, but will allow it to be
     * pushed back
     */
    public void pneumaticsStop() {
        pneumaticPistonDoubleSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    public void pneumaticsReverse() {
        pneumaticPistonDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void startWindingMotor(double speed) {
        windingMotor.set(speed);
    }
    public void stopWindingMotor() {
        windingMotor.set(0.0);
    }
    public double getWindingSpeed() {
        return windingMotor.get();
    }
    // Limit switch returns true when pushed
    public boolean getLimitSwitchForLauncherDownValue() {
        return limitSwitchForLauncherDown.get();
    }
    public boolean hasLaunchedBall() {
        return hasLaunched;
    }
    public void setLaunchedBall(boolean value) { //if this is true, we've just launched and the launcher is up
        hasLaunched = value;
    }
    
    public SpeedController getWindingMotor() {
        return windingMotor;
    }
}

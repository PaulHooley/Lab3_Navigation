package Navigation.src.ca.mcgill.ecse211;

import Navigation.src.ca.mcgill.ecse211.Display;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

public class Navigation {

	
	private static final Port usPort = LocalEV3.get().getPort("S1");
	public static final EV3LargeRegulatedMotor leftMotor =
	      new EV3LargeRegulatedMotor(LocalEV3.get().getPort("A"));
	public static final EV3LargeRegulatedMotor rightMotor =
	      new EV3LargeRegulatedMotor(LocalEV3.get().getPort("D"));
	private static final TextLCD lcd = LocalEV3.get().getTextLCD();

	//Coordinates on the ground that the robot goes towards
	private static int xpts[] = {1,0,2,2,1};
	private static int ypts[] = {0,0,1,2,1};
	
	private static int motorHigh = 150;
	private static int motorLow = 100;
	

	public static void main(String[] args) {
		//Initialization of the car 
		leftMotor.setSpeed(motorHigh);
		rightMotor.setSpeed(motorHigh);
		leftMotor.forward();
		rightMotor.forward();
		
		Navigation navigator = new Navigation(xpts, ypts);
	}

	public Navigation(int[] x, int[] y) {
		for (int i = 0; i < x.length; i++) {
			destinationPoint(x[i], y[i]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		

	}

	private void destinationPoint(int xpt, int ypt) {
		
		if(theta - ****){//Current angle - destination angle < 180
			leftMotor.setSpeed(motorHigh);
			rightMotor.setSpeed(motorHigh);
			leftMotor.forward();
			rightMotor.backward();
		}else{
			leftMotor.setSpeed(motorHigh);
			rightMotor.setSpeed(motorHigh);
			leftMotor.forward();
			rightMotor.backward();
		}
	}
}

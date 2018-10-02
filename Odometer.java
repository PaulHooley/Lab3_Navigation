package Navigation.src.ca.mcgill.ecse211;

import lejos.hardware.motor.EV3LargeRegulatedMotor;

public class Odometer {

	private int leftMotorTachoCount;
	private int rightMotorTachoCount;
	private EV3LargeRegulatedMotor leftMotor;
	private EV3LargeRegulatedMotor rightMotor;
	
	private volatile double x; // x-axis position
	private volatile double y; // y-axis position
	private volatile double theta; // Head angle
	
	public static int tachoCountL;
	public static int tachoCountR;
	
	public static final double WHEEL_RADIUS = 2.1;
	public static final double TRACK = 10;


	public static Odometer getOdometer() {
		
		return null;
	}

	public double[] getXYT() {
		double[] position = new double[3];
		
	    position[0] = x;
	    position[1] = y;
	    position[2] = theta;
	    
	    return position;
		
	}
	public void update(double dx, double dy, double dtheta) {
	    
	      x += dx;
	      y += dy;
	      theta = (theta + (360 + dtheta) % 360) % 360;
	    
	}
	public void run() {

	    while (true) {

	      leftMotorTachoCount = leftMotor.getTachoCount();
	      rightMotorTachoCount = rightMotor.getTachoCount();

	      // TODO Calculate new robot position based on tachometer counts
	      double distL, distR, deltaD, deltaT, dX, dY;
	      double theta = 0;
	      distL = 3.141592*(leftMotorTachoCount - tachoCountL)/180;
	      distR = 3.141592*(rightMotorTachoCount - tachoCountR)/180;
	      tachoCountL = leftMotorTachoCount;
	      tachoCountR = rightMotorTachoCount;
	      deltaD = 0.5*(distL + distR);
	      deltaT = (distL - distR)/WHEEL_RADIUS;
	      theta += deltaT;
	      dX = deltaD * Math.sin(theta);
	      dY = deltaD * Math.cos(theta);
	      
	      update(dX, dY, deltaT);
	      
	      try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    }
	}
}

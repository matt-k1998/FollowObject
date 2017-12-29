//In this first attempt of the program, the finch follows the object - turns left and right accordingly, or just moves straight
//However, the finch does not stop if the object stops and no statistics are yet calculated

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FollowObject {
	
	static Finch finch = new Finch();
	static boolean upsideDown = false;
	
	public static void followObject(){
		
		while (upsideDown == false){
			
			if (finch.isFinchUpsideDown()){
				upsideDown = true;
				stop();
			}
			else{	
				if ((finch.isObstacleLeftSide()) && (finch.isObstacleRightSide() == false)){
					moveLeft();
				}
				else if ((finch.isObstacleRightSide()) && (finch.isObstacleLeftSide() == false)){
					moveRight();
				}
				else if (finch.isObstacle()){
					moveStraight();
				}
				else{
					stop();
				}
			}
		}
	}
	
	public static void moveStraight(){
		finch.setWheelVelocities(200, 200);
		finch.setLED(0, 255, 0);
		finch.buzz(500, 1000);
	}
	
	public static void moveLeft(){
		finch.setWheelVelocities(100, 255);
		finch.setLED(0, 255, 0);
		finch.buzz(500, 1000);
	}
	
	public static void moveRight(){
		finch.setWheelVelocities(255, 100);
		finch.setLED(0, 255, 0);
		finch.buzz(500, 1000);
	}
	
	public static void stop(){
		finch.setWheelVelocities(0, 0);
		finch.setLED(255, 0, 0);
		finch.buzz(500, 1000);
	}
	
	
	public static void main(String[] args) {
		
		finch.setLED(255,0,0);
		//if(finch.isObstacle() && finch.isTapped()){
			followObject();
	//	}
	}
}

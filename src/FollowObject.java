//In this first attempt of the program, the finch follows the object - turns left and right accordingly, or just moves straight
//However, the finch does not stop if the object stops and no statistics are yet calculated

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FollowObject {
	
	static Finch finch = new Finch();
	
	public static void followObject(){
		
		boolean notifyEx = false;
		
		finch.setLED(0, 255, 0); //green
		// buzz starts here
		while(finch.isObstacleLeftSide() || finch.isObstacleRightSide() && !notifyEx) {
			if(!finch.isShaken() && !finch.isTapped()) {
				if(finch.isObstacleLeftSide() && !finch.isObstacleRightSide()) {
					finch.setWheelVelocities(50,150);
					// left obstacle => moves left => rightVelocity > leftVelocity
				}
				else if(!finch.isObstacleLeftSide() && finch.isObstacleRightSide()) {
					finch.setWheelVelocities(150,50);
					// right obstacle => moves right => rightVelocity < leftVelocity
				}
				else if(finch.isObstacleLeftSide() && finch.isObstacleRightSide()){
					finch.setWheelVelocities(75,75);
					// obstacle both sides => moves straight forward => leftVelocity = rightVelocity
				}
				finch.stopWheels();
			} else {
				notifyEx = true;
			}
		}
		// buzz ends here
		finch.setLED(255, 0, 0);
	}
	
	
	public static void main(String[] args){
		finch.setLED(255,0,0); //red
	
		if (finch.isObstacle() && finch.isTapped()){
			followObject();
		}
		main(args);
	}
}

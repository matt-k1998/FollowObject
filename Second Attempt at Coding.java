import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FollowObject {
	
	static Finch finch = new Finch();
	static boolean upsideDown = false;
	static int counter = 0;
	
	public static void followObject(){
		
		while (upsideDown == false){
			
			if (finch.isFinchUpsideDown()){
				upsideDown = true;
				stop();
			}
			else{
			//try{Thread.sleep(1000);}catch(InterruptedException e)(System.out.println(e)); //Timer
				if ((finch.isObstacleLeftSide()) && (finch.isObstacleRightSide() == false)){
					moveLeft();
					finch.setLED(0, 255, 0);
				}
				else if ((finch.isObstacleRightSide()) && (finch.isObstacleLeftSide() == false)){
					moveRight();
					finch.setLED(0, 255, 0);

				}
				else if (finch.isObstacle()==true){
					moveStraight();
					finch.setLED(0, 255, 0);
				}
				else{
					stop();
				}
			}
		}
	}
		
	public static void moveStraight(){
		finch.setWheelVelocities(75, 75, 500);
		finch.setLED(0, 255, 0);
		finch.buzz(500, 1000);
		while(finch.isObstacle() == true){
			finch.stop();
			finch.setLED(255, 0, 0);
			counter++;
		}
	}
	
	public static void moveLeft(){
		finch.setWheelVelocities(50, 150, 500);
		finch.setLED(0, 255, 0);
		finch.buzz(500, 1000);
		while(finch.isObstacleLeftSide() == true){
			finch.stop();
			finch.setLED(255, 0, 0);
			counter++;
		}
	}
	
	public static void moveRight(){
		finch.setWheelVelocities(150, 50, 500);
		finch.setLED(0, 255, 0);
		finch.buzz(500, 1000);
		while(finch.isObstacleRightSide() == true){
			finch.stop();
			finch.setLED(255, 0, 0);
			counter++;
		}
	}
	
	public static void stop(){
		finch.setWheelVelocities(0, 0);
		finch.setLED(255, 0, 0);
		counter++;
	}
	
	
	public static void main(String[] args){
		finch.setLED(255,0,0);
	
		if (finch.isObstacle() && finch.isTapped()){
			followObject();
		}
		main(args);
	}
	
}

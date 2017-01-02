package lasttime.window;

import lasttime.window.framework.GameObject;

public class Camera {

	private float x, y;
	
	public Camera(float x,float y)
	{
		this.x=x;
		this.y=y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}      

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void tick(GameObject player) {
		
		
		if(player.getX()>160&&player.getX()<1600)
		x=-player.getX()+Game.WIDTH/2-250;
		
		
	}
	
	
}

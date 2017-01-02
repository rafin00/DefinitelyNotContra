package lasttime.window.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {
	public int hp=15; public int pdem=1;
	protected int facing=1;
	private boolean alive=true;
	public int getFacing() {
		return facing;
	}

	public int getPdem() {
		return pdem;
	}

	protected boolean falling=true,jumping = false,shooting=false;
	public boolean isFalling() {
		return falling;
	}
	public boolean isShooting() {
		return shooting;
	}
	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	protected float x,y;
	protected float velx=0,vely=0;
	protected ObjectId id;
	
	public GameObject(float x, float y,ObjectId id)
	{
		this.x=x;
		this.y=y;
		this.id=id;
	}
	public abstract Rectangle getBounds();
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	
	
	
	public  float getX()
	{
		return x;
	}

	public  float getY()
	{
		return y;
	}
		

	public  void setY(float y)
	{
		this.y=y;
	}
		

	public float getVelx() 
	{
		return velx;
	}
	

	public  void setVelx(float velx)
	{
		this.velx=velx;
	}
	

	public  float getVety()
	{
		return vely;
	}

	public  void setVely(float vely)
	{
		this.vely=vely;
	}

	public  void setX(float x)
	{
		this.x=x;
	}
		
	public  ObjectId getId()
	{
		return id;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
}

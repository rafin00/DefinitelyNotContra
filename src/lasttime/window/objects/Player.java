package lasttime.window.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import lasttime.window.Animation1;
import lasttime.window.Camera;
import lasttime.window.Game;
import lasttime.window.Handler;
import lasttime.window.framework.GameObject;
import lasttime.window.framework.ObjectId;
import lasttime.window.gfx.Animation;
import lasttime.window.gfx.Texture;

public class Player extends GameObject {
   private Animation playerWalk;
   
	private Handler handler;
	public boolean isShooting() {
		return shooting;
	}
	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	Animation anim,anim1,animlr;
	public Player(float x, float y,Handler handler, Camera cam, ObjectId id) {
		super(x, y, id);
		this.handler=handler; this.cam=cam;
		anim=new Animation(5,tex.player[0],tex.player[1],tex.player[2],tex.player[3],tex.player[4],tex.player[5]);
		animlr=new Animation(5,tex.player[6],tex.player[7],tex.player[8],tex.player[9],tex.player[10],tex.player[11]);
		anim1=new Animation(5,tex.jump[0],tex.jump[1],tex.jump[2],tex.jump[3]);
		//playerWalk=new Animation(2,tex.player[0],tex.player[1],tex.player[2],tex.player[3],tex.player[4],tex.player[5]);
	}

	private float width=20,height=36,grav=.1f;
	Texture tex = Game.getInstance();
	

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+width/2-width/2/2),(int) ((int)y+height/2),(int)width/2,(int)height/2);
	}
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+width/2-width/2/2),(int)y,(int)width/2,(int)height/2);
	}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+width-5),(int)y+5,(int)5,(int)height-10);
	}
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		
		x+=velx;
		y+=vely;
		
		if(velx<0) facing=-1;
		else if(velx>0) facing =1;
		if(falling ||jumping)
		{
			vely+=grav;
		}
		Collision(object);
		//playerWalk.runAnimation();
		anim.runAnimation(); anim1.runAnimation(); animlr.runAnimation();
	}
private Camera cam;
public static int ph=15;
	private void Collision(LinkedList<GameObject> object) {
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject= handler.object.get(i);
			
			if(tempObject.getId()==ObjectId.Block)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y=tempObject.getY()+height;
					
					vely=0;
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					y=tempObject.getY()-height;
					
					vely=0;
					falling =false;
					jumping = false;
				}
				else
				{
					falling=true;
				}
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					x=tempObject.getX()-width;
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
				x=tempObject.getX()+35;
				}
			}
			else if(tempObject.getId()==ObjectId.Flag)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{	handler.removeObject((Player.this));
				    Player.this.setX(110);
				    Player.this.setY(50);
					handler.clearlevel();
					handler.removeObject((tempObject));
					handler.switchLevel();
					cam.setX(0);
				}
				//cam.setX(0);
			}
		}
		
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		
		 Font fnt0= new Font("arial",Font.BOLD,10);
			g.setFont(fnt0);
			g.setColor(Color.red);
			g.drawString("Player 1",                    (int)(cam.getX()*(-1)+Game.WIDTH-165), 100);
			if(pdem==2)
			{
				g.setColor(Color.white);
			g.drawString("Press and Hold Shoot to Rapid Fire",(int)(cam.getX()*(-1)), 120);
			g.drawString("Weapon Type: MachineGun(Hit"+pdem+")",  (int)(cam.getX()*(-1)+Game.WIDTH-165), 120);
			}
			else
				g.drawString("Weapon Type: Rifle(Hit"+pdem+")",  (int)(cam.getX()*(-1)+Game.WIDTH-165), 120);
			g.drawString("Alive Statue:"+isAlive(),     (int)(cam.getX()*(-1)+Game.WIDTH-165), 140);
			//g.drawString("weapon damage: ", Game.WIDTH/2-100, 0100);
		
	 if(jumping)
		{
			anim1.drawAnimation(g,	 x, y, 0);
		}
	 else if(velx!=0)
		{
		 if(facing==1)
			anim.drawAnimation(g,	 x, y, 0);
		 else
			 animlr.drawAnimation(g,	 x, y, 0);
		}
		
		else
		{
			if(facing==1)
			g.drawImage(tex.player[0], (int)x, (int)y, null);
			else
				g.drawImage(tex.player[6], (int)x, (int)y, null);	
		
		}	/*Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());*/
	}
	
}

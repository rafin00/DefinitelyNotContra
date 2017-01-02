package lasttime.window.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import lasttime.window.Game;
import lasttime.window.Handler;
import lasttime.window.MouseInput;
import lasttime.window.framework.GameObject;
import lasttime.window.framework.ObjectId;
import lasttime.window.gfx.Animation;
import lasttime.window.gfx.Texture;
import lasttime.window.music.MusicPlayer2;

public class Enemy extends GameObject {
	 private Animation enwalk;
	private Handler handler;
	
	Texture tex = Game.getInstance();
	public Enemy(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler=handler;
		enwalk=new Animation(5,tex.enemy[0],tex.enemy[1],tex.enemy[2],tex.enemy[3],tex.enemy[4],tex.enemy[5],tex.enemy[6],tex.enemy[7],tex.enemy[8],tex.enemy[9],tex.enemy[10],tex.enemy[11]);
		// TODO Auto-generated constructor stub
	}

	private float width=32,height=32,grav=.1f;
	@Override
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
		if(falling ||jumping)
		{
			vely+=grav;
		}
		x--;
		Collision(object);
		enwalk.runAnimation();
	}

	private void Collision(LinkedList<GameObject> object) {
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject= handler.object.get(i);
			
			if(tempObject.getId()==ObjectId.Block)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y=tempObject.getY()+height/2;
					if(jumping)
					{
						
					}else
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
					x=tempObject.getX()-width; jumping = true; vely=7;
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
				x=tempObject.getX()+35;
				jumping = true; vely=7;
				}
			}
			
			if(tempObject.getId()==ObjectId.Player)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;
						handler.clearlevel();
						
					}
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4; handler.clearlevel();
					}
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				}
			}
			
			if(tempObject.getId()==ObjectId.Player1)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; 
					
					tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				}
			}
			/*if(tempObject.getId()==ObjectId.Bullet)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}
			}*/
			
		}
		
	}
	@Override
	public void render(Graphics g) {
	
		enwalk.drawAnimation(g,	 x, y, 0);
		/*
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,(int)width,(int)height);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());*/
	}

}

package lasttime.window.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import lasttime.window.BufferedImageLoader;
import lasttime.window.Camera;
import lasttime.window.Game;
import lasttime.window.Handler;
import lasttime.window.MouseInput;
import lasttime.window.framework.GameObject;
import lasttime.window.framework.ObjectId;
import lasttime.window.gfx.Texture;
import lasttime.window.music.MusicPlayer2;

public class Bullet extends GameObject {
	Texture tex = Game.getInstance();
	private Handler handler;
	
	public Bullet(float x, float y,Handler handler, ObjectId id,int sed,int velx) {
		super(x, y, id); this.sed=sed;
		this.handler=handler; this.velx=velx;
		// TODO Auto-generated constructor stub
	}

	private float width=8,height=8,grav=.1f;
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		//return new Rectangle((int) ((int)x+width/2-width/2/2),(int) ((int)y+height/2),(int)width/2,(int)height/2);
		return new Rectangle((int) (int)x, ((int)y),25,25);
	}
	public int sed;
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int) (int)x, ((int)y),(int)width,(int)height);
		//return new Rectangle((int) ((int)x+width/2-width/2/2),(int)y,(int)width/2,(int)height/2);
	}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
	//	return new Rectangle((int) ((int)x+width-5),(int)y+5,(int)5,(int)height-10);
		return new Rectangle((int) (int)x, ((int)y),(int)width,(int)height);
	}
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
//		return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);
		return new Rectangle((int) (int)x, ((int)y),(int)width,(int)height);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		
		
		if(sed==0)
		{
			if(facing==1)
			x+=velx;
			else
				x+=(velx);
		}
		else if(sed==1)
			x=x-7;
		Collision(object);
		
		
		
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject= handler.object.get(i);
			
			if(tempObject.getId()==ObjectId.Player&&tempObject.isAlive()==true)
			{
				float dis = (tempObject.getX()-x);
				if(dis<0) dis=dis*(-1);
				if(dis>Game.WIDTH-100)
				{
					handler.removeObject((Bullet.this));
				}
			}
			else if(tempObject.getId()==ObjectId.Player1&&tempObject.isAlive()==true)
			{
				float dis = (tempObject.getX()-x);
				if(dis<0) dis=dis*(-1);
				if(dis>Game.WIDTH-100)
				{
					handler.removeObject((Bullet.this));
				}
			}
		}
		
	}

	private void Collision(LinkedList<GameObject> object) {
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject= handler.object.get(i);
			
			if(tempObject.getId()==ObjectId.Block)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((Bullet.this));
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					y=tempObject.getY()-height;
					
					handler.removeObject((Bullet.this));
				}
				else
				{
					falling=true;
				}
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((Bullet.this));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((Bullet.this));
				}
			}
			
			if(tempObject.getId()==ObjectId.Enemy&&Bullet.this.sed==0)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
			}
			if(tempObject.getId()==ObjectId.Enemy1&&Bullet.this.sed==0)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
					
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
			}if(tempObject.getId()==ObjectId.Boss&&Bullet.this.sed==0)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{ tempObject.hp--;
					if(tempObject.hp==0)
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{tempObject.hp--;
				if(tempObject.hp==0)
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{tempObject.hp--;
				if(tempObject.hp==0)
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{tempObject.hp--;
				if(tempObject.hp==0)
				
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
			}
			
			if(tempObject.getId()==ObjectId.Boss1&&Bullet.this.sed==0)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{ tempObject.hp--;
					if(tempObject.hp==0)
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{tempObject.hp--;
				if(tempObject.hp==0)
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{tempObject.hp--;
				if(tempObject.hp==0)
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{tempObject.hp--;
				if(tempObject.hp==0)
				
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
				}
			}
			
			
			if(tempObject.getId()==ObjectId.Player&&Bullet.this.sed==1)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
				
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null; tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
			
				handler.removeObject((tempObject));
				handler.removeObject((Bullet.this));
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
				handler.removeObject((Bullet.this));
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
				handler.removeObject((Bullet.this));
				MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
				shoot.run(); shoot=null; tempObject.setAlive(false);
			
				Game.dc++;
				if(Game.dc==2)
				{
					MouseInput.pnum=4;handler.clearlevel();
				}
			}
			}
			
			if(tempObject.getId()==ObjectId.Player1&&Bullet.this.sed==1)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
				
					handler.removeObject((tempObject));
					handler.removeObject((Bullet.this));
					MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
					shoot.run(); shoot=null;   tempObject.setAlive(false);
					Game.dc++;
					if(Game.dc==2)
					{
						MouseInput.pnum=4;handler.clearlevel();
					}
				
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
			
				handler.removeObject((tempObject));
				handler.removeObject((Bullet.this));
				MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
				shoot.run(); shoot=null;  tempObject.setAlive(false);
				Game.dc++;
				if(Game.dc==2)
				{
					MouseInput.pnum=4;handler.clearlevel();
				}
			
			}
				
				
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
			
				handler.removeObject((tempObject));
				handler.removeObject((Bullet.this));
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
				handler.removeObject((Bullet.this));
				MusicPlayer2 shoot = new MusicPlayer2("dead.wav");
				shoot.run(); shoot=null; tempObject.setAlive(false);
				Game.dc++;
				if(Game.dc==2)
				{
					MouseInput.pnum=4;handler.clearlevel();
				}
			
			}
			}
			
		}
		
	}
	@Override
	public void render(Graphics g) {
		//g.setColor(Color.yellow);
		//g.fillRect((int)x,(int)y,(int)width,(int)height);
		/*
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());*/
		g.drawImage(tex.bullet, (int)x, (int)y, null);
	}

}

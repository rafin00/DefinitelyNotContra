package lasttime.window.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import lasttime.window.Camera;
import lasttime.window.Game;
import lasttime.window.Handler;
import lasttime.window.MouseInput;
import lasttime.window.framework.GameObject;
import lasttime.window.framework.ObjectId;
import lasttime.window.gfx.Animation;
import lasttime.window.gfx.Texture;
import lasttime.window.music.MusicPlayer2;

public class Enemy1 extends GameObject {
	int eid;
	 int fps=60;
		double timePerTick=1000000000/fps,delta=0;
		long now,lastTime=System.nanoTime();
		long timer=0;
		int ticks=0;
	public int b=1;
	Texture tex = Game.getInstance();  private Animation enwalk;
	private Handler handler;
	
	
	public Enemy1(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id); 
		this.handler=handler;
		
		fps=60;
	     timePerTick=1000000000/fps;delta=0;
			 lastTime=System.nanoTime();
			 timer=0;
			 ticks=0;
		
		enwalk=new Animation(5,tex.enemy1[0],tex.enemy1[1],tex.enemy1[2],tex.enemy1[3],tex.enemy1[4],tex.enemy1[5],tex.enemy1[6],tex.enemy1[7],tex.enemy1[8],tex.enemy1[9],tex.enemy1[10],tex.enemy1[11]);
	}

	private float width=32,height=32,grav=.1f;
	
	public Rectangle getBounds() {
		
		return new Rectangle((int) ((int)x+width/2-width/2/2),(int) ((int)y+height/2),(int)width/2,(int)height/2);
	}
	public Rectangle getBoundsTop() {
		
		return new Rectangle((int) ((int)x+width/2-width/2/2),(int)y,(int)width/2,(int)height/2);
	}
	public Rectangle getBoundsRight() {
		
		return new Rectangle((int) ((int)x+width-5),(int)y+5,(int)5,(int)height-10);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);
	}

	
	public void tick(LinkedList<GameObject> object) {
		now=System.nanoTime();
		delta+=(now-lastTime)/timePerTick;
		timer+=(now-lastTime);
		lastTime=now;
		
		if(delta>=60)
		{
			for(int i=0;i<handler.object.size();i++)
			{
				GameObject tempObject= handler.object.get(i);
				
				if(tempObject.getId()==ObjectId.Player&&tempObject.isAlive()==true)
				{
				if(tempObject.getX()>100f)
				{
					System.out.println(tempObject.getX());
					handler.addObject(new Bullet(this.getX()-10,this.getY(),handler,ObjectId.Bullet,1,-1));
				}
				}
				else if(tempObject.getId()==ObjectId.Player1&&tempObject.isAlive()==true)
				{
				if(tempObject.getX()>100f)
				{
					System.out.println(tempObject.getX());
					handler.addObject(new Bullet(this.getX()-10,this.getY(),handler,ObjectId.Bullet,1,-1));
				}
				}
				}
		ticks++;
		delta=delta-60;
		}
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
						MouseInput.pnum=4; handler.clearlevel();
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
			
			if(tempObject.getId()==ObjectId.Player1)
			{
				if(getBoundsTop().intersects(tempObject.getBounds()))
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
		//g.setColor(Color.pink);
		//g.fillRect((int)x,(int)y,(int)width,(int)height);
		//g.drawImage(tex.enemy[2], (int)x, (int)y, null);
		//Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.red);
		//g2d.draw(getBounds());
		//g2d.draw(getBoundsTop());
		//g2d.draw(getBoundsRight());
		//g2d.draw(getBoundsLeft());
		enwalk.drawAnimation(g,	 x, y, 0);
	}

}

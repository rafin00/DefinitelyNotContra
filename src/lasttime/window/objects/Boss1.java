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
import lasttime.window.gfx.Texture;
import lasttime.window.music.MusicPlayer2;

public class Boss1 extends GameObject {
  public int health=15,a=1;
  Texture tex = Game.getInstance();
 int fps=60;
	double timePerTick=1000000000/fps,delta=0;
	long now,lastTime=System.nanoTime();
	long timer=0;
	int ticks=0;
 
   private Camera cam;
	private Handler handler;
	public Boss1(float x, float y,Handler handler, ObjectId id,Camera cam) {
		super(x, y, id);
	    
		this.handler=handler;
		this.cam=cam;
		
		 fps=60;
     timePerTick=1000000000/fps;delta=0;
		 lastTime=System.nanoTime();
		 timer=0;
		 ticks=0;
		
		// TODO Auto-generated constructor stub
	}
int b=5;
	private float width=32,height=200,grav=.1f;
	@Override
	/*public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+width/2-width/2/2),(int) ((int)y+height/2),(int)width/2,(int)height/2);
	}*/
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}
	/*public Rectangle getBoundsTop() {
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
*/
	@Override
	public void tick(LinkedList<GameObject> object) {
		
		
		//while(running)
		
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			timer+=(now-lastTime);
			lastTime=now;
			
			if(delta>=60)
			{
				if(a==3)
				{
					b=b*(-1);
				}
				y=y+b;
				
				for(int i=0;i<handler.object.size();i++)
				{
					GameObject tempObject= handler.object.get(i);
					
					if(tempObject.getId()==ObjectId.Player&&tempObject.isAlive()==true)
					{
					if(tempObject.getX()>1000f)
					{
						System.out.println(tempObject.getX());
						if(a==1)
				handler.addObject(new Bullet(this.getX()-20,this.getY()-15,handler,ObjectId.Bullet,1,-1));
				if(a==2)handler.addObject(new Bullet(this.getX()-20,this.getY()+75,handler,ObjectId.Bullet,1,-1));
				if(a==3)handler.addObject(new Bullet(this.getX()-20,this.getY()+110,handler,ObjectId.Bullet,1,-1));
				if(a==4)handler.addObject(new Bullet(this.getX()-20,this.getY()+145,handler,ObjectId.Bullet,1,-1));
				if(a==5)handler.addObject(new Bullet(this.getX()-20,this.getY()+180,handler,ObjectId.Bullet,1,-1));
				if(a==6)handler.addObject(new Bullet(this.getX()-20,this.getY()+215,handler,ObjectId.Bullet,1,-1));
				  a++;
				  if(a>6)
					  a=1;
				  
				  
					}
					}
					else if(tempObject.getId()==ObjectId.Player1&&tempObject.isAlive()==true)
					{
					if(tempObject.getX()>1000f)
					{
						System.out.println(tempObject.getX());
						if(a==1)
				handler.addObject(new Bullet(this.getX()-20,this.getY()-15,handler,ObjectId.Bullet,1,-1));
				if(a==2)handler.addObject(new Bullet(this.getX()-20,this.getY()+75,handler,ObjectId.Bullet,1,-1));
				if(a==3)handler.addObject(new Bullet(this.getX()-20,this.getY()+110,handler,ObjectId.Bullet,1,-1));
				  a++;
				  if(a>3)
					  a=1;
				  
					}
					}
					
			
				}
				ticks++;
				delta=delta-60;
			}
		//handler.addObject(new Bullet(this.getX(),this.getY(),handler,ObjectId.Bullet));
		
		Collision(object);
		
	}

	private void Collision(LinkedList<GameObject> object) {
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject= handler.object.get(i);
			
			if(tempObject.getId()==ObjectId.Block)
			{
				/*if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y=tempObject.getY()+height/2;
					
					vely=0;
				}*/
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
				/*if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					x=tempObject.getX()-width;
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
				x=tempObject.getX()+35;
				}*/
			}
			
			if(tempObject.getId()==ObjectId.Player)
			{
				/*if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}*/
				if(getBounds().intersects(tempObject.getBounds()))
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
				
				/*if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}*/
			}
			
			if(tempObject.getId()==ObjectId.Player1)
			{
				/*if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}*/
				if(getBounds().intersects(tempObject.getBounds()))
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
				
				/*if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					handler.removeObject((tempObject));
				}*/
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
		g.setColor(Color.green);
		g.drawImage(tex.lboss1, (int)x, (int)y, null);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		//g2d.draw(getBounds());
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject= handler.object.get(i);
			
			if(tempObject.getId()==ObjectId.Player&&tempObject.isAlive()==true)
			{
			if(tempObject.getX()>1000f)
			{
				g.setColor(Color.gray);
				g.fillRect((int)((cam.getX())*(-1))+90+5	, 60, 90, 20);
				
				g.setColor(Color.red);
				g.fillRect((int)((cam.getX())*(-1))+90+5	, 60, Boss1.this.hp*6, 20);
				
				g.setColor(Color.red);
				g.drawRect((int)((cam.getX())*(-1))	+90+5, 60, 90, 20);
				g.drawString("Boss1 HP",(int)(cam.getX())*(-1)+90+5, 40);
			}
			}
			else if(tempObject.getId()==ObjectId.Player1&&tempObject.isAlive()==true)
			{
			if(tempObject.getX()>1000f)
			{
				g.setColor(Color.gray);
				g.fillRect((int)((cam.getX())*(-1))+90+5	, 60, 90, 20);
				
				g.setColor(Color.red);
				g.fillRect((int)((cam.getX())*(-1))+90+5	, 60, Boss1.this.hp*6, 20);
				
				g.setColor(Color.red);
				g.drawRect((int)((cam.getX())*(-1))	+90+5, 60, 90, 20);
				g.drawString("Boss1 HP",(int)(cam.getX())*(-1)+90+5, 40);
			}
			}
		}
		//g2d.draw(getBoundsTop());
		//g2d.draw(getBoundsRight());
		//g2d.draw(getBoundsLeft());
	}

}

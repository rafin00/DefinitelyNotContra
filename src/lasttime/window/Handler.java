package lasttime.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import lasttime.window.Game.STATE;
import lasttime.window.framework.GameObject;
import lasttime.window.framework.ObjectId;
import lasttime.window.objects.Block;
import lasttime.window.objects.Boss;
import lasttime.window.objects.Boss1;
import lasttime.window.objects.Enemy;
import lasttime.window.objects.Enemy1;
import lasttime.window.objects.Flag;
import lasttime.window.objects.Player;
import lasttime.window.objects.Player1;
import lasttime.window.objects.wep;
public class Handler {
    
	
	private static final int WIDTH = 0;
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;
	public void tick()
	{
	for(int i=0;i<object.size();i++)
	{
		tempObject=object.get(i);
		tempObject.tick(object);
	}
	
	}
	private Camera cam;
	private BufferedImage level2=null,level=null;
	public Handler(Camera cam)
	{ this.cam=cam;
		BufferedImageLoader loader=new BufferedImageLoader();
	
			//bg=loader.loadImage("/textures/bg.jpg");
		try
		{
		level=loader.loadImage("/textures/level2.png");
		level2=loader.loadImage("/textures/level.png");
		}
		catch (Exception e) {
				
				e.printStackTrace();
		}
		}
		
		
		

	public void switchLevel()
	{
		//clearlevel();
		cam.setX(0); 
		switch(Game.LEVEL)
		{
		case 1:
			LoadImageLevel(level);
			break;
		case 2:
			LoadImageLevel(level2);
			break;
		}
		
		Game.LEVEL++;
	}
	public void LoadImageLevel(BufferedImage image)
	{
		int w=image.getWidth();
		int h=image.getHeight();
		//System.out.println(w+" " +h);
		System.out.println("sdkfhkdsj");
		for(int xx=0;xx<h;xx++)
		{
			for(int yy=0;yy<h;yy++)
			{
				int pixel = image.getRGB(xx, yy);
				int red = (pixel>>16) &0xff;
				int green = (pixel>>8)&0xff;
				int blue = (pixel)&0xff;
				try{
				if(red==255 &&green==255&&blue==255)
					addObject(new Block(xx*32,yy*32,0,ObjectId.Block));
				if(red==255 &&green==0&&blue==220)
					addObject(new Block(xx*32,yy*32,1,ObjectId.Block));
			
				if(red==0 &&green==0&&blue==255)
					{addObject(new Player((float)xx*32,(float)yy*32,this,cam,ObjectId.Player));System.out.println(MouseInput.pnum);
					if(MouseInput.pnum==2){ 
						Game.dc=0;
				addObject(new Player1((float)xx*32+30,(float)yy*32,this,cam,ObjectId.Player1));
					}
					}
				if(red==255 &&green==0&&blue==0)
					addObject(new Enemy(xx*32,yy*32,this,ObjectId.Enemy));
				if(red==255 &&green==216&&blue==0)
					addObject(new Enemy1(xx*32,yy*32,this,ObjectId.Enemy1));
				if(red==0 &&green==255&&blue==33)
					addObject(new Boss(xx*32,yy*32,this,ObjectId.Boss,cam));
				if(red==0 &&green==255&&blue==0)
					addObject(new Boss1(xx*32,yy*32,this,ObjectId.Boss1,cam));
				if(red==255 &&green==106&&blue==0)
					addObject(new Flag(xx*32,yy*32,ObjectId.Flag));
				if(red==91 &&green==127&&blue==0)
					addObject(new Block(xx*32,yy*32,2,ObjectId.Block));
				if(red==192 &&green==192&&blue==192){
					addObject(new wep(xx*32,yy*32,this,ObjectId.wep));
				}
				}
				catch (Exception e) {
					e.printStackTrace();
			}
			
			}
		}
	}
	
	public  void clearlevel()
	{
	object.clear();
	}
/*	public void CreateLevel()
	{
		for(int xx=0;xx<Game.WIDTH-32;xx+=32)
		{
			addObject(new Block(xx,Game.HEIGHT-32,ObjectId.Block));
			if(xx>32*4&&xx<32*8)
			addObject(new Block(xx,Game.HEIGHT-32*6,ObjectId.Block));
		}
		for(int yy=0;yy<Game.HEIGHT-32;yy+=32)
		{
			addObject(new Block(00,Game.HEIGHT-yy,ObjectId.Block));
			addObject(new Block(Game.WIDTH-32,Game.HEIGHT-yy,ObjectId.Block));
		}
	}*/
	public void render(Graphics g)
	{
		for(int i=0;i<object.size();i++)
		{
			tempObject=object.get(i);
			tempObject.render(g);
		}
		
	}
	
	
	
    public void addObject(GameObject object)
    {
    	this.object.addLast(object);
    }
    public void removeObject(GameObject object)
    {
    	this.object.remove(object);
    }

}

package lasttime.window.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import lasttime.window.Handler;
import lasttime.window.music.MusicPlayer1;
import lasttime.window.music.MusicPlayer2;
//import lasttime.window.music.PlaySoundApplet;
import lasttime.window.objects.Bullet;
import lasttime.window.objects.Bulletp;
import lasttime.window.objects.Enemy1;


public class KeyInput extends KeyAdapter {
	private enum STATE
	{
		MENU,
		GAME
	};
	
	public void keyPressed(KeyEvent e) {
	int key= e.getKeyCode();
	
	{
	for(int i=0;i<handler.object.size();i++)
	{
		GameObject tempObject= handler.object.get(i);
		if(tempObject.getId()==ObjectId.Player)
		{
			if(key==KeyEvent.VK_D)
			{
				tempObject.setVelx(3);
				
				MusicPlayer2 shoot = new MusicPlayer2("walk1.wav");
				/*if(!shoot.isRunning())
				{ shoot.setRunning(running);
				shoot.run();  shoot=null; 
				shoot.setRunning(false);
				}*/
			}
			if(key==KeyEvent.VK_A)
			{
				tempObject.setVelx(-3);
				MusicPlayer2 shoot = new MusicPlayer2("walk1.wav");
				/*if(!shoot.isRunning())
				{
				shoot.run();  shoot=null; 
				shoot.setRunning(false);
				}*/
			}
			if(key==KeyEvent.VK_F && !tempObject.isJumping())
			{
				tempObject.setJumping(true);
				
				tempObject.setVely(-4);
				MusicPlayer2 shoot = new MusicPlayer2("jump.wav");
				shoot.run(); shoot=null; 
			}
			if(key==KeyEvent.VK_G && !tempObject.isShooting())
			{
				if(tempObject.pdem!=2)
				tempObject.setShooting(true);
			
				handler.addObject(new Bulletp(tempObject.getX()+10,tempObject.getY()+5,handler,ObjectId.Bulletp,0,tempObject.getFacing()*10,tempObject.getPdem()));
				MusicPlayer2 shoot = new MusicPlayer2("shoot.wav");
				shoot.run(); shoot=null; 
			}
			
			
		}
		if(tempObject.getId()==ObjectId.Player1)
		{
			if(key==KeyEvent.VK_I)
			{
				tempObject.setVelx(3);/* MusicPlayer2 shoot = new MusicPlayer2("walk1.wav");
				shoot.run(); shoot=null;*/ 
				
			}
			if(key==KeyEvent.VK_Y)
			{
				tempObject.setVelx(-3);   /*MusicPlayer2 shoot = new MusicPlayer2("walk1.wav");
				shoot.run(); shoot=null; */
			}
			if(key==KeyEvent.VK_O && !tempObject.isJumping())
			{
				tempObject.setJumping(true);
				
				tempObject.setVely(-4);
				MusicPlayer2 shoot = new MusicPlayer2("jump.wav");
				shoot.run(); shoot=null; 
			}
			if(key==KeyEvent.VK_P && !tempObject.isShooting())
			{ if(tempObject.pdem!=2)
				tempObject.setShooting(true);
			handler.addObject(new Bulletp(tempObject.getX()+10,tempObject.getY()+5,handler,ObjectId.Bulletp,0,tempObject.getFacing()*10,tempObject.getPdem()));
				MusicPlayer2 shoot = new MusicPlayer2("shoot.wav");
				shoot.run(); shoot=null; 
			}
			
			
		}
		
	}
	
	if(key==KeyEvent.VK_ESCAPE)
	{
		System.exit(1);
	}
	}
}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		int key= e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject= handler.object.get(i);
			if(tempObject.getId()==ObjectId.Player)
			{
				if(key==KeyEvent.VK_D)
				{
					tempObject.setVelx(0);
				}
				if(key==KeyEvent.VK_D&&key==KeyEvent.VK_J)
					
				{
					//tempObject.setVelx(0);
					System.out.println("ds");
				}
				
				if(key==KeyEvent.VK_A)
				{
					tempObject.setVelx(0);
				}
				if(key==KeyEvent.VK_G)
				{
					tempObject.setShooting(false);
				}
				
				
			}
			if(tempObject.getId()==ObjectId.Player1)
			{
				if(key==KeyEvent.VK_I)
				{
					tempObject.setVelx(0);
				}
				if(key==KeyEvent.VK_D&&key==KeyEvent.VK_J)
					
				{
					//tempObject.setVelx(0);
					System.out.println("ds");
				}
				
				if(key==KeyEvent.VK_Y)
				{
					tempObject.setVelx(0);
				}
				if(key==KeyEvent.VK_P)
				{
					tempObject.setShooting(false);
				}
				
				
			}
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

Handler handler;

public KeyInput(Handler handler)
{
	this.handler=handler;
}
}

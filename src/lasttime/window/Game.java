package lasttime.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;






//import javaGame.Game.STATE;






//import javaGame.Menu;
//import javaGame.MouseInput;
//import javaGame.Game.STATE;
import lasttime.window.framework.KeyInput;
import lasttime.window.framework.ObjectId;
import lasttime.window.gfx.Texture;
import lasttime.window.music.MusicPlayer1;
import lasttime.window.music.MusicPlayer2;
//import lasttime.window.music.PlaySoundApplet;
import lasttime.window.objects.Block;
import lasttime.window.objects.Boss;
import lasttime.window.objects.Enemy;
import lasttime.window.objects.Enemy1;
import lasttime.window.objects.Flag;
import lasttime.window.objects.Player;


public class Game extends Canvas implements Runnable
{
   
	public  BufferedImage level=null,level2=null,clouds=null;
	public static int LEVEL=1;
	private BufferedImage bg,ins,fin;
	Handler handler;
	//PlaySoundApplet ps;
	private static final long serialVersionUID = -1297421196069933925L;
      static Texture tex;
	private boolean running=false;
	private Thread thread;
	private Menu menu;
	private Finish finish;
	public static int WIDTH,HEIGHT;
	public static enum STATE{
		MENU,
		GAME,
		GAME2,
		DEAD,
		FINISH
	};
	public static STATE State = STATE.MENU;
	/*public synchronized void start()
	{
		if(running)
			return;
		running =true;
		thread=new Thread(this);
		thread.start();
	}*/
	public synchronized void stop()
	{
		if(!running) return;
		running = false;
	}
	
	
	
	
	public void run() {
		running=true;
		init();
		this.requestFocus();
		int fps=60;
		double timePerTick=1000000000/fps,delta=0;
		long now,lastTime=System.nanoTime();
		long timer=0;
		int ticks=0;
		
		while(running)
		{
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			timer+=(now-lastTime);
			lastTime=now;
			
			if(delta>=1)
			{
			tick();
			try {
				render();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ticks++;
			delta--;
			}
			if(timer>=1000000000)
			{
				//System.out.println("Ticks and Frames: "+ticks);
				ticks=0;
				timer=0;
			}
		}
		
	}
	
	private void init() {
		//ps.init();
		WIDTH=getWidth();
		HEIGHT=getHeight();
		
		tex=new Texture();
		BufferedImageLoader loader=new BufferedImageLoader();
		
			bg=loader.loadImage("/textures/go.jpg");
			ins=loader.loadImage("/textures/ins.jpg");
			fin=loader.loadImage("/textures/fin.png");
		/*try
		{
		level=loader.loadImage("/textures/level.png");
		level2=loader.loadImage("/textures/level.png");
		}
		catch (Exception e) {
				
				e.printStackTrace();
		}*/
		//level2=loader.loadImage("/textures/level2.png");
		//clouds=loader.loadImage("/textures/bg.jpg");
		
		
		
		cam= new Camera (0,0);
		handler=new Handler(cam);
		menu = new Menu();
		finish = new Finish();
		this.addMouseListener(new MouseInput());
		
		//handler.addObject(new Player(160,100,handler,ObjectId.Player));
		//handler.CreateLevel();
		//handler.LoadImageLevel(level);
		
		this.addKeyListener(new KeyInput(handler));
	}
	private void tick() {
		
		if(State ==STATE.GAME||State ==STATE.GAME2)
		{
		handler.tick();
		
		for(int i=0;i<handler.object.size();i++)
		{
			if(handler.object.get(i).getId()==ObjectId.Player&&handler.object.get(i).isAlive()==true)
			{
				cam.tick(handler.object.get(i)); break;
			}
			else if(handler.object.get(i).getId()==ObjectId.Player1&&handler.object.get(i).isAlive()==true)
			{
				cam.tick(handler.object.get(i));// break;
			}
			else
			{ 
				
				//MouseInput.pnum=4;
			}
			
		}
		}
		
		
	}
	
	public static Texture getInstance()
	{
		return tex;
	}
	
	
	
	Camera cam;
	 static boolean once=false;
	public static int dc=1;
	private void render() throws InterruptedException {
		  if(once==true)
		  {
		handler.switchLevel();
		  once=false;
		  }
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		if(State==STATE.GAME||State ==STATE.GAME2)
		{
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		 g.drawImage(ins,00,0,null);
		 
		
		 
		g2d.translate(cam.getX(), cam.getY());
		handler.render(g);
		g2d.translate(-cam.getX(), -cam.getY());
		}
		
		else if(State==STATE.MENU)
		{
			menu.render(g);
		}
		else if(State==STATE.FINISH)
		{
			finish.render(g);
			System.out.println("f");
		}
		
		if(MouseInput.pnum==4)
		{    
			State=STATE.FINISH; MouseInput.pnum=0;
			 //g.drawImage(bg,0,0,null); Thread.sleep(5);
			
				/*MusicPlayer2 shoot = new MusicPlayer2("game_over.wav");
				shoot.run(); shoot=null;  Thread.sleep(700);*/

		}
		if(LEVEL==4)
		{
			State=STATE.FINISH;
			//g.setColor(Color.white);
			//g.fillRect(0, 0, Game.WIDTH,Game.HEIGHT);
			// g.drawImage(fin,0,0,null); Thread.sleep(5);
			    
				/*MusicPlayer2 shoot = new MusicPlayer2("game_over.wav");
				if(!shoot.isRunning())
				{
				shoot.run(); shoot=null; shoot.setRunning(true);g
				}Thread.sleep(700); */
				
                 
		}
		
		g.dispose();
		bs.show();
	
	}
	
	
	
	public static void main(String arg[])
	{   
		new Window(800,600,"Le game",new Game());
	}

}

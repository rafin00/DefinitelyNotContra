package lasttime.window.gfx;

import java.applet.AudioClip;
import java.awt.image.BufferedImage;

import lasttime.window.BufferedImageLoader;

public class Texture {
SpriteSheet bs,ps,en,en1,boss;

static AudioClip bg1m,jumpm,shootm,deadm;

private BufferedImage block_sheet=null;
public BufferedImage player_sheet=null,Enemy_sheet=null,bullet,wep1,wep2,wep,lboss,lboss1,door,spl;

public BufferedImage[] block =new BufferedImage[4];
public BufferedImage[] player =new BufferedImage[12];
public BufferedImage[] player1 =new BufferedImage[12];
public BufferedImage[] enemy =new BufferedImage[12];
public BufferedImage[] enemy1 =new BufferedImage[12];
public BufferedImage[] jump =new BufferedImage[4];
public Texture()
{
	BufferedImageLoader loader = new BufferedImageLoader();
	try{
		
	block_sheet=loader.loadImage("/textures/map.png");
	player_sheet=loader.loadImage("/textures/pwr.png");
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	ps= new SpriteSheet(player_sheet);
    bs= new SpriteSheet(block_sheet);
	
	
	
	getTextures();
}

private void getTextures() {
	BufferedImageLoader loader1 = new BufferedImageLoader();
	// TODO Auto-generated method stub
	block[0]=bs.grabImage(1,1,32,32);
	block[1]=bs.grabImage(2,1,32,32);
	block[2]=loader1.loadImage("/textures/Untitled.png");
	player[0]=loader1.loadImage("/textures/walkR/pwr (0).png");
	player[1]=loader1.loadImage("/textures/walkR/pwr (1).png");
	player[2]=loader1.loadImage("/textures/walkR/pwr (2).png");
	player[3]=loader1.loadImage("/textures/walkR/pwr (3).png");
	player[4]=loader1.loadImage("/textures/walkR/pwr (4).png");
	player[5]=loader1.loadImage("/textures/walkR/pwr (5).png");
	player[6]=loader1.loadImage("/textures/walkL/pwl (1).png");
	player[7]=loader1.loadImage("/textures/walkL/pwl (2).png");
	player[8]=loader1.loadImage("/textures/walkL/pwl (3).png");
	player[9]=loader1.loadImage("/textures/walkL/pwl (4).png");
	player[10]=loader1.loadImage("/textures/walkL/pwl (5).png");
	player[11]=loader1.loadImage("/textures/walkL/pwl (6).png");
	
	player1[0]=loader1.loadImage("/textures/bwr/bwr (1).gif");
	player1[1]=loader1.loadImage("/textures/bwr/bwr (2).gif");
	player1[2]=loader1.loadImage("/textures/bwr/bwr (3).gif");
	player1[3]=loader1.loadImage("/textures/bwr/bwr (4).gif");
	player1[4]=loader1.loadImage("/textures/bwr/bwr (5).gif");
	player1[5]=loader1.loadImage("/textures/bwr/bwr (6).gif");
	player1[6]=loader1.loadImage("/textures/bwl/bwl (1).gif");
	player1[7]=loader1.loadImage("/textures/bwl/bwl (2).gif");
	player1[8]=loader1.loadImage("/textures/bwl/bwl (3).gif");
	player1[9]=loader1.loadImage("/textures/bwl/bwl (4).gif");
	player1[10]=loader1.loadImage("/textures/bwl/bwl (5).gif");
	player1[11]=loader1.loadImage("/textures/bwl/bwl (6).gif");
	
	bullet=loader1.loadImage("/textures/bullet.png");
	lboss=loader1.loadImage("/textures/boss.png");
	lboss1=loader1.loadImage("/textures/boss1.png");
	door=loader1.loadImage("/textures/door.jpg");
	enemy1[0]=loader1.loadImage("/textures/r (1).gif");
	enemy1[1]=loader1.loadImage("/textures/r (2).gif");
    enemy1[2]=loader1.loadImage("/textures/r (3).gif");
    enemy1[3]=loader1.loadImage("/textures/r (4).gif");
	enemy1[4]=loader1.loadImage("/textures/r (5).gif");
    enemy1[5]=loader1.loadImage("/textures/r (6).gif");
    enemy1[6]=loader1.loadImage("/textures/r (7).gif");
	enemy1[7]=loader1.loadImage("/textures/r (8).gif");
    enemy1[8]=loader1.loadImage("/textures/r (9).gif");
    enemy1[9]=loader1.loadImage("/textures/r (10).gif");
	enemy1[10]=loader1.loadImage("/textures/r (11).gif");
    enemy1[11]=loader1.loadImage("/textures/r (12).gif");
    wep=loader1.loadImage("/textures/wep.png");
    wep2=loader1.loadImage("/textures/wep2.png");
    spl=loader1.loadImage("/textures/splash2.jpg");
    wep1=loader1.loadImage("/textures/wep1.png");
    enemy[0]=loader1.loadImage("/textures/enemyr/r (1).gif");
	enemy[1]=loader1.loadImage("/textures/enemyr/r (2).gif");
    enemy[2]=loader1.loadImage("/textures/enemyr/r (3).gif");
    enemy[3]=loader1.loadImage("/textures/enemyr/r (4).gif");
	enemy[4]=loader1.loadImage("/textures/enemyr/r (5).gif");
    enemy[5]=loader1.loadImage("/textures/enemyr/r (6).gif");
    enemy[6]=loader1.loadImage("/textures/enemyr/r (7).gif");
	enemy[7]=loader1.loadImage("/textures/enemyr/r (8).gif");
    enemy[8]=loader1.loadImage("/textures/enemyr/r (9).gif");
    enemy[9]=loader1.loadImage("/textures/enemyr/r (10).gif");
	enemy[10]=loader1.loadImage("/textures/enemyr/r (11).gif");
    enemy[11]=loader1.loadImage("/textures/enemyr/r (12).gif");
    
    jump[0]=loader1.loadImage("/textures/jump/jump.png");
    jump[1]=loader1.loadImage("/textures/jump/jump1.png");
    jump[02]=loader1.loadImage("/textures/jump/jump2.png");
    jump[03]=loader1.loadImage("/textures/jump/jump3.png");
    
    //bg1m = new AudioClip()
   // audioClip = getAudioClip(getCodeBase(), "Sound.wav");
    
}
/*public void pictures(StartingPoint sp)
{
	
}*/

}

package lasttime.window.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import lasttime.window.Game;
import lasttime.window.framework.GameObject;
import lasttime.window.framework.ObjectId;
import lasttime.window.gfx.Texture;

public class Block extends GameObject
{
	private int type;
	Texture tex= Game.getInstance();
	public Block(float x, float y,int type,ObjectId id)
	{
		super(x,y,id);
		this.type=type;
	}
	public void render(Graphics g)
	{
		if(type==0)
		{
			g.drawImage(tex.block[0], (int)x, (int)y,null);
		}
		if(type==1)
		{
			g.drawImage(tex.block[1], (int)x, (int)y,null);
		}
		if(type==2)
		{
			g.drawImage(tex.block[2], (int)x, (int)y,null);
		}
		
	}
	
	public void tick(LinkedList<GameObject> object)
	{
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32);
	}
	
}
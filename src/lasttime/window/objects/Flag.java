package lasttime.window.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import lasttime.window.Game;
import lasttime.window.Handler;
import lasttime.window.framework.GameObject;
import lasttime.window.framework.ObjectId;
import lasttime.window.gfx.Texture;

public class Flag extends GameObject {
	Texture tex = Game.getInstance();
	private Handler handler;
	public Flag(float x, float y, ObjectId id) {
		super(x, y, id); 
		
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		//return new Rectangle((int) ((int)x+width/2-width/2/2),(int) ((int)y+height/2),(int)width/2,(int)height/2);
		return new Rectangle((int) (int)x, ((int)y),100,150);
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int)y,100,150);
		g.drawImage(tex.door, (int)x, (int)y, null);
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g.drawString("Next Level", (int)x, (int)y-20);
		//g2d.draw(getBounds());
		
		//g.drawImage(tex.bullet, (int)x, (int)y, null);
	}


	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

}

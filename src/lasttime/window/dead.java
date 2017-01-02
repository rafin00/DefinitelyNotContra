package lasttime.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class dead {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH/2+120,150,140,50);
	public Rectangle play2pButton = new Rectangle(Game.WIDTH/2+120,250,190,50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2+120,350,100,50);
	
public void render(Graphics g)
{
	Graphics2D g2d = (Graphics2D) g;
	Font fnt0= new Font("arial",Font.BOLD,050);
	g.setFont(fnt0);
	g.setColor(Color.red);
	g.drawString("Deffinately Not Contra", Game.WIDTH/2-100, 0100);
	
	Font fnt1= new Font("arial",Font.BOLD,030);
	g.setFont(fnt1);
	g.drawString("Play Solo",playButton.x+19,playButton.y+30);
	g2d.draw(playButton);
	g.drawString("Play 2Players",play2pButton.x+19,play2pButton.y+30);
	g2d.draw(play2pButton);
	g.drawString("Quit",quitButton.x+19,quitButton.y+30);
	g2d.draw(quitButton);
	
}
}

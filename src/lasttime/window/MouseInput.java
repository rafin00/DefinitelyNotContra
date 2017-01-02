package lasttime.window;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lasttime.window.Game.STATE;

public class MouseInput implements MouseListener {
	public static int pnum=5;
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		
		
		int mx=e.getX(),my=e.getY();
		if(Game.State==STATE.MENU)
		{
		if(mx>=Game.WIDTH/ 2 +125&&mx<=Game.WIDTH + 220)
		{
			if(my>=150&&my<=200)
			{
				Game.State=Game.STATE.GAME; pnum=1;Game.once=true; Game.LEVEL=1; Game.dc=1;
			}
		}
		
		if(mx>=Game.WIDTH/ 2 +125&&mx<=Game.WIDTH + 220)
		{
			if(my>=250&&my<=300)
			{
				Game.State=Game.STATE.GAME2; pnum=2; Game.once=true;Game.LEVEL=1;
			}
		}
		
		if(mx>=Game.WIDTH/ 2 +125&&mx<=Game.WIDTH + 220)
		{
			if(my>=350&&my<=400)
			{
				System.exit(1);
			}
		}
		}
		else if(Game.State==STATE.FINISH)
		{
		if(mx>=Game.WIDTH/ 2 +125&&mx<=Game.WIDTH + 220)
		{
			if(my>=150&&my<=200)
			{
				Game.State=Game.STATE.MENU;Game.LEVEL=1;
			}
		}
		
		if(mx>=Game.WIDTH/ 2 +125&&mx<=Game.WIDTH + 220)
		{
			if(my>=250&&my<=300)
			{
				System.exit(2);
				//Game.State=Game.STATE.GAME2; pnum=2; Game.once=true;//System.out.println(MouseInput.pnum);
			}
		}
		
		/*if(mx>=Game.WIDTH/ 2 +125&&mx<=Game.WIDTH + 220)
		{
			if(my>=350&&my<=400)
			{
				System.exit(1);
			}
		}*/
		}
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

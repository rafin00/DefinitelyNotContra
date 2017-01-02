package lasttime.window;

import java.awt.Dimension;

import javax.swing.JFrame;

import lasttime.window.music.MusicPlayer1;
import lasttime.window.threads.ThreadPool;

public class Window {

	public Window(int w,int h, String title,Game game)
	{
		 ThreadPool pool = new ThreadPool(3);
		game.setPreferredSize(new Dimension(w,h));
		game.setMinimumSize(new Dimension(w,h));
		game.setMaximumSize(new Dimension(w,h));
		
		JFrame frame = new JFrame(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//game.start();
		
		MusicPlayer1 player = new MusicPlayer1("bg1.wav");
		//MusicPlayer2 shoot = new MusicPlayer1("shoot.wav");
		pool.runTask(player);
		
		pool.runTask(game);
		pool.join();
		
	}
}

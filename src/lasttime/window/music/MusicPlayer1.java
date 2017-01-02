
package lasttime.window.music;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

public class MusicPlayer1 implements Runnable {
    
   public ArrayList<AudioFile> musicFiles;
    public int currentSongIndex;
    private boolean running;
    public MusicPlayer1(String... files){
    	
        musicFiles = new ArrayList<AudioFile>();
        for(String file : files)
            musicFiles.add(new AudioFile("res/textures/" +file));
        //addKeyListener(this);
        //setFocausable(true);
       // setFocusTraversalKeysEnabled(false);
    }
    
    

    
    public boolean isRunning() {
		return running;
	}




	public void setRunning(boolean running) {
		this.running = running;
	}




	public void run() {
    	running=true;
    	AudioFile song=musicFiles.get(currentSongIndex);
        song.play();
    	while (running)
        {
        	if(!song.isPlaying())
        	{
        		currentSongIndex++;
        		if(currentSongIndex>=musicFiles.size())
        		{
        			currentSongIndex=0;
        			song=musicFiles.get(currentSongIndex);
        			song.play();
        		}
        		try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
    }




	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	

}


package lasttime.window.music;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import java.io.File;
import java.util.ArrayList;

public class MusicPlayer2 implements Runnable {
    
    private ArrayList<AudioFile> musicFiles;
    private int currentSongIndex;
    private boolean running=false;
    public MusicPlayer2(String... files){
        musicFiles = new ArrayList<AudioFile>();
        for(String file : files)
            musicFiles.add(new AudioFile("res/textures/" +file));
    }
    
    

    
    public void run() {
    	running=true;
    	AudioFile song=musicFiles.get(currentSongIndex);
        song.play();
    	/*while (running)
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
        }*/
    }




	public boolean isRunning() {
		return running;
	}




	public void setRunning(boolean running) {
		this.running = running;
	}

}

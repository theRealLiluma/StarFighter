package GUI.soundPlayer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

public class SoundPlayer {
    private static SoundPlayer instance;
    private AudioInputStream audioStream;
    private Clip clip;
    private int soundLevel;
    private FloatControl gainControl;
    private boolean playing;
    private boolean initialized;
    
    private SoundPlayer(){
    	//playing = false;
    	soundLevel = 4;
        playing = false;
        initialized = false;
    }
    
    public void initSound(String filename){	         
        try{
            InputStream in = getClass().getResourceAsStream(filename);
            InputStream bufferedIn = new BufferedInputStream(in);
            audioStream = AudioSystem.getAudioInputStream(bufferedIn);   	
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            setSound(soundLevel);
        }catch(LineUnavailableException lue){
        	lue.printStackTrace();
        }catch(IOException ioe){
        	ioe.printStackTrace();
        }catch(Exception e){
        	e.printStackTrace();
        }
        initialized = true;
    }
    
    public void stopPlaying(){
    	clip.stop();
        playing = false;
    }
    
    public void resetPlayer(){
        if(clip != null){
            if(playing){
                stopPlaying();
            }
            clip = null;
            initialized = false;
        }
    }
    
    public boolean isInitialized(){
        return initialized;
    }
    
    public boolean isPlaying(){
        return playing;
    }
    
    public void startPlaying(){
        playing = true;
    	clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void setSound(int soundLevel){
    	gainControl.setValue(soundLevel);
    	this.soundLevel = soundLevel;
    }
    
    public void mute(){
    	stopPlaying();
    }
    
    public int getSoundLevel(){
    	return soundLevel;
    }
    
    public static SoundPlayer getInstance(){
    	if(instance == null)
    		instance = new SoundPlayer();
    	
    	return instance;
    }
}
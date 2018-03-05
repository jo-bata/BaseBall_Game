package kr.ac.skuniv.model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Gamesound {
	AudioClip sound;
	
	@SuppressWarnings("deprecation")
	public Gamesound(String url) {
		try {
			File file = new File(url);
			sound = Applet.newAudioClip(file.toURL());
			sound.play();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void nothing() { }
	public void stopSound() { sound.stop(); }
}

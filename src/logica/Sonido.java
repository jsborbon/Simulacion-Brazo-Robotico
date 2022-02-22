package logica;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Sonido {

	private String filepath;
	private File musicPath;
	private AudioInputStream audioInput;
	private Clip clip;
        private boolean error;

	public Sonido() {
		filepath = "src/resources/error.wav";
		musicPath = new File(filepath);
                error=false;
        }

	public void play() {
		try {
			if (musicPath.exists()) {
				audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();

			} else {
                            if(!error){
                                JOptionPane.showMessageDialog(null, "No se puede reproducir el audio, por favor ejecute este programa en Eclipse y asegurese de que el audio se encuentra en la carpeta Resources");
                                error=true;
                            }
			}

		} catch (Exception ex) {
			if(!error){
                                JOptionPane.showMessageDialog(null, "No se puede reproducir el audio, por favor ejecute este programa en Eclipse y asegurese de que el audio se encuentra en la carpeta Resources");
                            error=true;
                        }
		}

	}

	public void stop(boolean IsSound) {
		try {
			if (IsSound) {
				clip.stop();
				clip.close();
			}
		} catch (Exception ex) {
			if(!error){   error=true;
                                JOptionPane.showMessageDialog(null, "No se puede reproducir el audio, por favor ejecute este programa en Eclipse y asegurese de que el audio se encuentra en la carpeta Resources");
                            }
		}
	}
}

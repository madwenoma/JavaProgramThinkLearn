package learn.others;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class JavaSoundDemo {
	public static void main(String[] args) {
		new JavaSoundDemo().playClip("effect_p3.wav");
	}
	public void playClip(String audioFile) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream(audioFile));
			DataLine.Info info = new DataLine.Info(Clip.class,
					audioInputStream.getFormat());
			final Clip clip = (Clip) AudioSystem.getLine(info);
			clip.addLineListener(new LineListener() {
				public void update(LineEvent e) {
					if (e.getType() == LineEvent.Type.STOP) {
						synchronized (clip) {
							clip.notify();
						}
					}
				}
			});
			clip.open(audioInputStream);

			clip.setFramePosition(0);

			clip.start();
			synchronized (clip) {
				clip.wait();
			}
			clip.drain();
			clip.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

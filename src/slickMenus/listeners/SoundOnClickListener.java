package slickMenus.listeners;

import org.newdawn.slick.Sound;

import slickMenus.elements.Element;

public class SoundOnClickListener implements ActionListener {

	private Sound _sound;
	
	public SoundOnClickListener(Sound s) {
		_sound = s;
	}
	
	@Override
	public void mousePressed(int button, int x, int y, Element e) {
		if (e.inRect(x, y)) _sound.play();
	}

	@Override
	public void mouseReleased(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
	}

	@Override
	public void update(int delta, Element e) {
	}

}

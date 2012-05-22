package slickMenus.listeners;

import org.newdawn.slick.Sound;

import slickMenus.elements.Element;

public class SoundOnHoverListener implements ActionListener {

	private Sound _sound;
	
	public SoundOnHoverListener(Sound s) {
		_sound = s;
	}
	
	@Override
	public void mousePressed(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseReleased(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
		if (!e.inRect(oldX, oldY) && e.inRect(newX, newY)) _sound.play();
	}

	@Override
	public void update(int delta, Element e) {
	}

}

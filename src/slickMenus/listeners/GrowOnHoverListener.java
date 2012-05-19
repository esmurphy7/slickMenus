package slickMenus.listeners;

import org.newdawn.slick.GameContainer;

import slickMenus.elements.Element;

public class GrowOnHoverListener implements ActionListener {

	private float _maxScale;
	
	private float _scaleStep;
	
	public GrowOnHoverListener(float maxScale, float scaleStep) {
		_maxScale = maxScale;
		_scaleStep = scaleStep;
	}
	
	@Override
	public void mousePressed(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseReleased(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
		e.setIsOver(e.inRect(newX, newY));
	}

	@Override
	public void update(int delta, Element e) {
		float scale = e.getScale();
		if (scale > 1.0f && !e.isOver()) {
			e.setScale(scale - _scaleStep * delta);
			if (e.getScale() < 1.0f) e.setScale(1.0f);
		}
		else if (e.isOver() && scale < _maxScale) {
			e.setScale(scale + _scaleStep * delta);
			if (e.getScale() > _maxScale) e.setScale(_maxScale);
		}
	}

}

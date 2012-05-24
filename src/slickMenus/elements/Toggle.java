package slickMenus.elements;

import org.newdawn.slick.Image;

public class Toggle extends Element {
	
	/**
	 * Image to be shown when the state of this toggle is true
	 */
	private Image _trueImage;
	
	/**
	 * Image to be shown when the state of this toggle is false
	 */
	private Image _falseImage;
	
	/**
	 * Current state of the toggle
	 */
	private boolean _state;

	public Toggle(Image trueImage, Image falseImage, boolean initState) {
		_trueImage = trueImage;
		_falseImage = falseImage;
		_state = initState;
		if (_state) {
			_width = _trueImage.getWidth();
			_height = _trueImage.getHeight();
		}
		else {
			_width = _falseImage.getWidth();
			_height = _falseImage.getHeight();
		}
	}
	
	@Override
	public void draw(float frameX, float frameY) {
		super.draw(frameX, frameY);
		if (_state) _trueImage.draw(frameX + _xPos, frameY +_yPos);
		else _falseImage.draw(frameX + _xPos, frameY + _yPos);
	}

}

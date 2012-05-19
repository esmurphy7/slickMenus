package slickMenus.elements;

import java.util.HashSet;

import org.newdawn.slick.Image;

import slickMenus.listeners.ActionListener;

/**
 * The interface for elements which can be added to a frame.
 */
public abstract class Element {
	
	/**
	 * x coordinate of top left corner
	 */
	protected float _xPos;
	
	/**
	 * y coordinate of top left corner
	 */
	protected float _yPos;
	
	/**
	 * padding in the y direction. Default value is 0.
	 */
	protected float _padX = 0f;
	
	/**
	 * padding in the x direction. Default value is 0.
	 */
	protected float _padY = 0f;
	
	/**
	 * width of this element
	 */
	protected float _width;
	
	/**
	 * height of this element
	 */
	protected float _height;
	
	/**
	 * background image of this element
	 */
	protected Image _backgroundImage;
	
	/**
	 * background image's scale
	 */
	protected float _scale = 1.0f;
	
	/**
	 * HashSet of ActionListeners on this element
	 */
	protected HashSet<ActionListener> _listeners = new HashSet<ActionListener>();
	
	/**
	 * Tracks whether mouse is over this element
	 */
	private boolean _isOver;
	
	/**
	 * Returns _width of this element
	 * @return the _width of this element
	 */
	public float getWidth() {
		return _width;
	}
	
	/**
	 * Returns _height of this element
	 * @return the _height of this element
	 */
	public float getHeight() {
		return _height;
	}
	
	/**
	 * Set x position to be drawn at
	 * @param x x coordinate of top left corner
	 */
	public void setPosX(float x) {
		_xPos = x;
	}
	
	/**
	 * Set y position to be drawn at
	 * @param y y coordinate of top left corner
	 */
	public void setPosY(float y) {
		_yPos = y;
	}
	
	public void setPosition(float x, float y) {
		_xPos = x;
		_yPos = y;
	}
	
	/**
	 * Set background image for this element
	 * @param image new background image
	 */
	public void setBackground(Image image) {
		_backgroundImage = image;
	}
	
	/**
	 * Return scale of this background image
	 * @return scale of this background image
	 */
	public float getScale() {
		return _scale;
	}
	
	/**
	 * Set scale of background image
	 * @param scale new scale
	 */
	public void setScale(float scale) {
		_scale = scale;
	}
	
	/**
	 * Draw background image
	 */
	public void draw() {
		if (_backgroundImage != null) _backgroundImage.draw(_xPos - (_scale - 1 ) * _width / 2,
				_yPos - (_scale - 1) * _height / 2,
				_scale);
	}
	
	/**
	 * Set _padX for this element
	 */
	public void setPadX(float x) {
		_padX = x;
	}
	
	/**
	 * Set _padY for this element
	 */
	public void setPadY(float y) {
		_padY = y;
	}
	
	/**
	 * Get x padding of this element
	 * @return Value of _padX
	 */
	public float getPadX() {
		return _padX;
	}
	
	/**
	 * Get y padding of this element
	 * @return Value of _padY
	 */
	public float getPadY() {
		return _padY;
	}
	
	public void addActionListener(ActionListener listener) {
		_listeners.add(listener);
	}
	
	/**
	 * Calls mousePressed on each of this elements actionListener
	 * @param button button which is pressed
	 * @param x x position
	 * @param y y position
	 */
	public void mousePressed(int button, int x, int y) {
		for (ActionListener l : _listeners) {
			l.mousePressed(button, x, y, this);
		}
	}
	
	/**
	 * Calls mouseReleased on each of this elements actionListeners
	 * @param button button which is pressed
	 * @param x x position
	 * @param y y position
	 */
	public void mouseReleased(int button, int x, int y) {
		for (ActionListener l : _listeners) {
			l.mouseReleased(button, x, y, this);
		}
	}
	
	/**
	 * Calls mouseHover on each of this elements actionListeners
	 * @param oldX
	 * @param oldY
	 * @param newX
	 * @param newY
	 */
	public void mouseMoved(int oldX, int oldY, int newX, int newY) {
		for (ActionListener l : _listeners) {
			l.mouseMoved(oldX, oldY, newX, newY, this);
		}
	}
	
	public void update(int delta) {
		for (ActionListener l :_listeners) {
			l.update(delta, this);
		}
	}
	
	/**
	 * Checks if position is in this element
	 * @param xPos
	 * @param yPos
	 * @return 
	 */
	public boolean inRect(int xPos, int yPos) {
		return ((xPos > _xPos && xPos < _xPos + _width) && (yPos > _yPos && yPos < _yPos + _height));
	}
	
	public boolean isOver() {
		return _isOver;
	}
	
	public void setIsOver(boolean val) {
		_isOver = val;
	}

}

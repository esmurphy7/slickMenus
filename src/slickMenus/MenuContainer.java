package slickMenus;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import slickMenus.elements.Element;

/**
 * A container which consists of other elements. Organization of the elements
 * is controlled by a layout manager.
 */
public class MenuContainer extends slickMenus.elements.Frame{
	
	/**
	 * determines if this menu should be updated
	 */
	private boolean _acceptingInput;
	
	/**
	 * GameContainer that this menu belongs to
	 */
	private GameContainer _gc;
	
	/**
	 * Constructs a new menu container at the specified position
	 * @param x x coordinate of top left corner
	 * @param y y coordinate of top left corner 
	 */
	public MenuContainer(float x, float y, GameContainer gc) {
		_xPos = x;
		_yPos = y;
		_gc = gc;
		_gc.getInput().addMouseListener(new MenuListener(this));
	}
	
	public void enter() {
		_acceptingInput = true;
	}
	
	public void leave() {
		_acceptingInput = false;
	}
	
	private class MenuListener implements MouseListener {

		private MenuContainer _container;
		
		public MenuListener(MenuContainer mc) {
			_container = mc;
		}
		
		@Override
		public void inputEnded() {
		}

		@Override
		public void inputStarted() {
		}

		@Override
		public boolean isAcceptingInput() {
			return _acceptingInput;
		}

		@Override
		public void setInput(Input arg0) {
		}

		@Override
		public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		}

		@Override
		public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		}

		@Override
		public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
			_container.mouseMoved(arg0, arg1, arg2, arg3);
		}

		@Override
		public void mousePressed(int arg0, int arg1, int arg2) {
			_container.mousePressed(arg0, arg1, arg2);
		}

		@Override
		public void mouseReleased(int arg0, int arg1, int arg2) {
			_container.mouseReleased(arg0, arg1, arg2);
		}

		@Override
		public void mouseWheelMoved(int arg0) {
		}
		
	}
	
}


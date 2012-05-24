package slickMenus.layouts;

import java.util.LinkedList;
import slickMenus.elements.Element;

/**
 * This LayoutManager organizes elements in a vertical column
 */
public class VerticalLayout implements LayoutManager {

	/**
	 * Value which indicates left alignment
	 */
	public static final int LEFT = 0;
	
	/**
	 * Value which indicates center alignment
	 */
	public static final int CENTER = 1;
	
	/**
	 * Value which indicates right alignment
	 */
	public static final int RIGHT = 2;
	
	private int _alignment;
	
	/**
	 * VerticalLayout constructor with a default alignment of CENTER
	 */
	public VerticalLayout() {
		this(1);
	}
	
	/**
	 * VerticalLayout constructor with a specified alignment value
	 * @param alignment Alignment to use. A value of 0 is left aligned, a 
	 * value of 1 is centered, a value of 2 is right aligned. If the given 
	 * alignment is not one of these values, this layout manager will not 
	 * adjust the position of any elements.
	 */
	public VerticalLayout(int alignment) {
		_alignment = alignment;
	}
	
	/**
	 * Set the new alignment for this VerticalLayout
	 * @param alignment Alignment to use. A value of 0 is left aligned, a 
	 * value of 1 is centered, a value of 2 is right aligned.
	 */
	public void setAlignment(int alignment) {
		_alignment = alignment;
	}
	
	/**
	 * Update the position of all elements passed to this manager.
	 * @param list List of elements
	 * @param x X coordinate of top left corner
	 * @param y Y coordinate of top let corner
	 * @return Returns the width and height of this layout
	 */
	@Override
	public float[] updateLayout(LinkedList<Element> list) {
		float width = 0f;
		float height = 0f;
		switch(_alignment) {
		case LEFT: 
			for (Element e: list) {
				e.setPosY(height + e.getPadY());
				height += e.getHeight() + 2 * e.getPadY();
				e.setPosX(e.getPadX());
				float tempWidth = e.getWidth() + 2 * e.getPadX();
				if (tempWidth > width) width = tempWidth;
			}
		break;
		case CENTER: 
			for (Element e : list) {
				e.setPosY(height + e.getPadY());
				height += e.getHeight() + 2 * e.getPadY();
				float tempWidth = e.getWidth() + 2 * e.getPadX();
				if (tempWidth > width) width = tempWidth;
			}
			for (Element e : list) {
				e.setPosX((width - e.getWidth()) / 2);
			}
			break;
		case RIGHT: 
			for (Element e : list) {
				e.setPosY(height + e.getPadY());
				height += e.getHeight() + 2 * e.getPadY();
				float tempWidth = e.getWidth() + 2 * e.getPadX();
				if (tempWidth > width) width = tempWidth;
			}
			for (Element e : list) {
				e.setPosX(width - (e.getWidth() + e.getPadX()));
			}
			break;
		default: break;
		}
		return new float[] {width, height};
	}

}

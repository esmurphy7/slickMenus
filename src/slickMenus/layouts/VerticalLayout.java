package slickMenus.layouts;

import java.util.LinkedList;
import slickMenus.elements.Element;

/**
 * This LayoutManager organizes elements in a vertical column
 */
public class VerticalLayout implements LayoutManager {

	/**
	 * Update the position of all elements passed to this manager.
	 * @param list List of elements
	 * @param x X coordinate of top left corner
	 * @param y Y coordinate of top let corner
	 * @return Returns the width and height of this layout
	 */
	@Override
	public float[] updateLayout(LinkedList<Element> list, float x, float y) {
		float width = 0f;
		float height = 0f;
		for (Element e : list) {
			e.setPosY(y + e.getPadY());
			height += e.getHeight() + 2 * e.getPadY();
			y += e.getHeight() + 2 * e.getPadY();
			float tempWidth = e.getWidth() + 2 * e.getPadX();
			if (tempWidth > width) width = tempWidth;
		}
		for (Element e : list) {
			e.setPosX(x + (width - e.getWidth()) / 2);
		}
		return new float[] {width, height};
	}

}

package Snake;

import javafx.scene.canvas.GraphicsContext;

//шаг 3
/*Этот класс нам нужен для отображения нашей игры
 * Здесь нужно сделать:
 * 1. метод ресовки в котором с помощю Graphiccontext отобразим нашу сетку
 * 
 * */
public class Painter {

	
	public static void draw(Grid grid , GraphicsContext context) {
		
		context.setFill(grid.color);
		context.fillRect(0, 0, grid.getWidth(), grid.getHeight());
		
	}
	
	
}

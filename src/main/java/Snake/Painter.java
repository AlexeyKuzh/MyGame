package Snake;

import static Snake.Grid.SIZE;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//шаг 3
/*Этот класс нам нужен для отображения нашей игры
 * Здесь нужно сделать:
 * 1. метод ресовки в котором с помощю Graphiccontext отобразим нашу сетку
 * 2.спомощю context(Graphiccontext) вызовем метод setFill() где закрашиваем или задаем цвет, а потом fillRect для  
 * 3.Нужно создать метод для рисовки точки paintPoint(), где спомощю метода fillRect() мы указываем позицыю точки                     
 * 4.
 * 
 * */
public class Painter {
	
	
	public static void draw(Grid grid , GraphicsContext context) {
		
		context.setFill(grid.color);
		context.fillRect(0, 0, grid.getWidth(), grid.getHeight());
		
		context.setFill(Food.color);
		paintPoint(grid.getFood().getPoint(), context);
		
		
		SnakeClass snake = grid.getSnake();
		context.setFill(snake.colorLife);
		snake.getBody().forEach(point -> paintPoint(point, context));
		if(!snake.isLife()==true) {
			context.setFill(snake.colorDead);
			paintPoint(snake.getHead(), context);
			
		}
		context.setFill(Color.BEIGE);
		context.fillText("Score : "+100*snake.getBody().size(),10,490);
		
	}
	
	public static void paintPoint(Point point, GraphicsContext graphicsContext) {
		
		graphicsContext.fillRect(point.getX()*SIZE,point.getY()*SIZE,SIZE,SIZE);
		
		
	}

	public static void paintResetMessage(GraphicsContext context) {
		context.setFill(Color.AQUAMARINE);
		context.fillText("Hit RETURN to reset.", 10, 10);
	}

	
	
}

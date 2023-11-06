package Snake;

import javafx.scene.paint.Color;

//шаг 5 созданее Еды посути на базе точки 
/*//1: Сначала даем цвет нашей Еде(точке)
//2: Потом Сылочную переменую Класса точки для работы с ней
 *3: Конструктор класса Food куда ложим в параметры point(точку) типа сылки Point(Точки)  с вязываем с this. точки 
 *4: делаем Get и Set Point (Точки)
*/
public class Food {

	public static final Color color = Color.CRIMSON; 
	
	private Point point;
	
	
	public Food(Point point) {
		this.point=point;
	}
	
	
	
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
}

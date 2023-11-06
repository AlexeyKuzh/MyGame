package Snake;

import java.util.Random;

//шаг 2 
import javafx.scene.paint.Color;

/*Это класс Сетка для токого чтобы можно было понять где размещять наши обекты/детали игры(яблоки, голову змии) своего рода поле 
 * Что нам нужно зделать сначала: 
 * 1.Задать Цвет( именно этого цвета будет наша игра), так же нужно создать статическую переменную размера одной клетки (поставим 10) 
 * 2.Нам нужны переменные Колон и Строк для того чтобы их начертить и сделать клетки, и так же сделать их get что бы их можна будет вернуть новыми после обработки 
 * 3.Колон и Строк инцилизируем(зададим значение) в конструкторе класса 
 * 4.Нужно сделать метод wrap() для того чтобы были границы. Для написания этого метода потребуеться класс Точка(Point)
 * 						 потому что именно идет опредиление по точке где она может быть а где нет 
 * 5.Так же нам нужен будет метод RandomPoint()  чтобы мы могли рандомна добавлять точку на нашу Сетку
 * 6.Нам нужно сделать get класса Food для того что бы его можна было потом отрисавать 
 * 7.Тоже самое что и Food но теперь с классом Snake
 * 8.В классе RanddomPoint надо реализовать также и голову змеи, сделав сравнение с точкой 
 * */

public class Grid {

	// для цвета мы отоброзим это потом спомощю другого класса
	public static final Color color = Color.ANTIQUEWHITE;
	// параметер размера клеток
	public static final int SIZE = 10;

	private final int rows;// ряды
	private final int cols;// столбцы
	
	private Food food;
	private SnakeClass snake;
	
	public Grid(int WIDTH, int HEIGHT) {
		rows = WIDTH / SIZE;
		cols = HEIGHT / SIZE;

		snake = new SnakeClass(this, new Point(rows/2,cols/2));
		// ложим сюда нашу еду потом через GetFood() возвращяем новый обект

		food = new Food(randomPoint());

	}

	public Point wrap(Point point) {

		int x = point.getX();
		int y = point.getY();

		if (x >= rows)
			x = 0;
		if (y >= cols)
			y = 0;
		if (x < 0)
			x = rows - 1;
		if (y < 0)
			y = cols - 1;
		return new Point(x,y);

	}

	public Point randomPoint() {

		Random random = new Random();

		Point point;
		do {
			point = new Point(random.nextInt(rows), random.nextInt(cols));
		} while (point.equals(snake.getHead()));

		return point;
	}
	
	public void update() {
		if(food.getPoint().equals(snake.getHead())) {
			snake.extend();
			food.setPoint(randomPoint());
		}else {
			snake.move();
		}
		
	}

	public int getWidth() {

		return rows * SIZE;

	}

	public int getHeight() {
		return cols * SIZE;
	}

	public int getCols() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	public Food getFood() {
		return food;
	}

	public SnakeClass getSnake() {
		return snake;
	}

	
}

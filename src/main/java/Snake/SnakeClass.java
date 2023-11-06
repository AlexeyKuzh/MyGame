package Snake;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

//шаг 7 сама змейка 

/*Нужно сделать:
 * 1)звдвть параметры змейки их много: Цвет(Жизни и смерти змейки), Булиан жива ли, длинна,
 * Колекцию как контейнер куда будет записуваться тело змеии туда нужно по логие записать класс Точка,
 * и две переменые скоростии   
 * 2)Также две Сылочные переменные двух классов Grid, Point  для работы с ними.У Point лутчше дать имя head для работы(так будет проще)  
 * 3)Нужно создать конструктор где нужно записать(положить туда) по умолчанию все параметры змейки
 * 4)нужно сделать метод getHead (голова змеии) п.с из всех методов єто самый главный для начала, просто чтобы уже отобразить на полотне(оброзно)
 * 5)Нужно будет создать метод 
*/
public class SnakeClass {

	public static final Color colorLife = Color.DARKOLIVEGREEN;
	public static final Color colorDead = Color.BLACK;

	private boolean life;
	private int length;

	private Grid grid;
	private Point head;

	private List<Point> body;
	private int xVelocity;
	private int yVelocity;

	public SnakeClass(Grid grid, Point startPoint) {

		length = 1;

		body = new ArrayList<>();
		body.add(startPoint);

		head = startPoint;
		life = true;
		this.grid = grid;

		xVelocity = 0;
		yVelocity = 0;

	}

	public void growTo(Point point) {
		length++;
		checkAndAdd(point);
	}
	
	// Нужно чтобы прикаждом обновлении Змейки дабовлялась новая точка и удалялоссь
	// прошлое значение
	public void shiftTO(Point point) {

		checkAndAdd(point);
		body.remove(0);
	}

	// Проверяет пересикли ли мы границы и живы

	public void checkAndAdd(Point point) {

		point = grid.wrap(point);
		life &= !body.contains(point);
		body.add(point);
		head = point;

	}
	
	public List<Point> getBody() {
		return body;
	}
	
		public boolean isLife() {
		return life || length == 1;

	}
	

		public Point getHead() {
		return head;
	}
		
		public boolean isStill(){
			return xVelocity == 0 & yVelocity == 0;
		}
		
		public void move() {
		if (!isLife()) {
			shiftTO(head.translate(xVelocity, yVelocity));
		}
	}	
		





	public void extend() {
		if(!isStill()) {
			growTo(head.translate(xVelocity, yVelocity));
		}
	}

	public void setUp() {
		System.out.println("Нажата клавиша ВВЕРХ");
		if (yVelocity == 1 && length > 1)
			return;
		xVelocity = 0;
		yVelocity = -1;

	}

	public void setDown() {
		System.out.println("Нажата клавиша Вниз");
		if (yVelocity == -1 && length > 1)
			return;
		xVelocity = 0;
		yVelocity = 1;
	}

	public void setLeft() {
		System.out.println("Нажата клавиша Лево");
		if (xVelocity == 1 && length > 1)
			return;
		xVelocity = -1;
		yVelocity = 0;
	}

	public void setRigth() {
		System.out.println("Нажата клавиша Право");
		if (xVelocity == -1 && length > 1)
			return;
		xVelocity = 1;
		yVelocity = 0;
	}

}

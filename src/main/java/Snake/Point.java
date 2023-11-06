package Snake;
//шаг 4

/* Делаем точку
 * 1.Сначала задаем две переменые X и Y для кординат кнопки
 * 2.Потом конструктор где в параметрах пишем еще X и Y и спомощю this. скрепляем их с теми что за конструктором
 * 3.Потом нужно вернуть наши переменные спомощю get
 * 4. 
*/
public class Point {

	final int x;
	final int y;

	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point translate(int dx, int dy) {

		return new Point(x + dx, y + dy);

	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Point))
			return false;
		Point point = (Point) object;
		return x == point.x & y == point.y;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}

}

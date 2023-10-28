package Snake;

// в проэкте Змека это 1 шаг\класс
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	private Grid grid;
	private GraphicsContext context;

	@Override
	public void start(Stage primaryStage) throws Exception {

		StackPane stackPane = new StackPane();
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		context = canvas.getGraphicsContext2D();

		reset();
		stackPane.getChildren().add(canvas);
		Scene scene = new Scene(stackPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Snake");
		primaryStage.show();
	}

	private void reset() {
		grid = new Grid(WIDTH, HEIGHT);

		Painter.draw(grid, context);

	}

}

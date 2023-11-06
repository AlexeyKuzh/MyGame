package Snake;

// в проэкте Змека это 1 шаг\класс
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private Controller controller;
	private Grid grid;
	private GraphicsContext context;
	

	/*
	 * public static void main(String[] args) 
	 * { Application.launch(args); }
	 */	
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		StackPane root = new StackPane();
		Canvas canvas = new Canvas(WIDTH,HEIGHT);
		
		context = canvas.getGraphicsContext2D();
		
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(e->{
			SnakeClass snake = grid.getSnake();
			
			if(controller.isKeyPressed()) {
				return;
			}
			switch(e.getCode()) {
			case UP:
				snake.setUp();
				controller.setKeyPressed(true);
			break;
			case DOWN:
				snake.setDown();
				controller.setKeyPressed(true);
				break;
			case LEFT:
				snake.setLeft();
				controller.setKeyPressed(true);
				break;
			case RIGHT:
				snake.setRigth();
				controller.setKeyPressed(true);
				break;
			case ENTER:
				if(controller.isPaused()) {
					reset();
					(new Thread(controller)).start();
				}
			
			}
			
			
		});
		reset();
		root.getChildren().add(canvas);
		
		Scene scene = new Scene(root);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Snake");
		primaryStage.setOnCloseRequest(e -> System.exit(0));
		primaryStage.setScene(scene);
		primaryStage.show();
		
		(new Thread(controller)).start();
	}

	private void reset() {
		grid = new Grid(WIDTH, HEIGHT);
		controller = new Controller(grid, context);
		Painter.draw(grid, context);

	}

}

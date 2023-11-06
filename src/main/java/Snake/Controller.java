package Snake;

import javafx.scene.canvas.GraphicsContext;

public class Controller implements Runnable {

	private Grid grid;
	private GraphicsContext context;

	private int frameRate;
	private float interval;

	private boolean running;
	private boolean keyIsPressed;
	private boolean paused;

	public Controller(Grid grid, final GraphicsContext graphicsContext) {

		this.grid = grid;
		this.context = graphicsContext;

		frameRate = 20;
		interval = 1000.0f / frameRate;

		running = true;
		paused = false;
		keyIsPressed = false;
	}

	@Override
	public void run() {
		while (running && !paused) {
			float time = System.currentTimeMillis();

			keyIsPressed = false;//false
			grid.update();
			//
			grid.getSnake().move();
			//
			Painter.draw(grid, context);

			if (!grid.getSnake().isLife()) {
				pause();
				Painter.paintResetMessage(context);
				break;
			}
			time = System.currentTimeMillis() - time;
			
			if (time < interval) {
				try {
					Thread.sleep((long) (interval - time));
				} catch (InterruptedException ignore) {
					// TODO: handle exception
				}
			}

		}
	}

	public void stop() {
		running = false;
	}

	public boolean isKeyPressed() {
		return keyIsPressed;
	}

	public void setKeyPressed(boolean pressed) {
		keyIsPressed = pressed;
	}

	public void resume() {
		paused = false;
	}

	public void pause() {
		paused = true;
	}

	public boolean isPaused() {
		return paused;
	}

	public int getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(int frameRate) {
		this.frameRate = frameRate;
	}

}

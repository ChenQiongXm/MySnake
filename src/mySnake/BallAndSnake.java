package mySnake;

import java.util.LinkedList;

public class BallAndSnake {
	private Snake snake;
	private LinkedList<Ball>balls=new LinkedList<Ball>();
	public BallAndSnake(Snake snake, LinkedList<Ball> balls) {
		super();
		this.snake = snake;
		this.balls = balls;
	}
	
}

package mySnake;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final static int COW_NUMBER=40;
	protected final static int COL_NUMBER=40;
	protected final static int BLOCK_WIDTH=10;
	protected final static int BLOCK_HEIGHT=10;
	protected final static int WIDTH=(COL_NUMBER+8)*BLOCK_WIDTH;
	protected final static int HEIGHT=(COW_NUMBER+8)*BLOCK_HEIGHT;
	private Snake snake;
	private LinkedList<Ball> balls=new LinkedList<Ball>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame myFrame = new MyFrame();
		
	}
	public  MyFrame(){
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(300,300);
		this.snake=new Snake();
		Ball ball=new Ball();
		balls.add(ball);
		BallAndSnake deal=new BallAndSnake(snake, balls);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(new KeyMonitor());
		new Thread(new PaintClass()).start();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		System.out.println("ÖØÐÂ»­");
		g.drawRect(BLOCK_WIDTH*4, BLOCK_HEIGHT*4, COL_NUMBER*BLOCK_WIDTH, COW_NUMBER*BLOCK_HEIGHT);
		snake.draw(g);
		Iterator<Ball> it=balls.iterator();
		while(it.hasNext()){
			Ball ball=it.next();
			ball.draw(g);
		}
	}
	private class PaintClass implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	private class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("key is pressed");
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				snake.changeDir(Direction.UP);
				break;
			case KeyEvent.VK_DOWN:
				snake.changeDir(Direction.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				snake.changeDir(Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				snake.changeDir(Direction.RIGHT);
				break;
			default:
				break;
			}
		}
	}
}

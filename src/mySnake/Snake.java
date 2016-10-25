package mySnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import cq.snake.Dir;

public class Snake {
	//ArrayList<Node> nodes=null;
	Node node1;
	Node first;
	Node last;
	public Snake() {
		// TODO Auto-generated constructor stub
		first=new Node(MyFrame.BLOCK_WIDTH*20, MyFrame.BLOCK_HEIGHT*20,Direction.UP);
		last=first;
		addNode();
		addNode();
		addNode();
		addNode();
	}
	public void addNode(){
		Node node=null;
		switch (last.direction) {
		case UP:
			node=new Node(last.x, last.y+Node.width, last.direction);
			break;
		case DOWN:
			node=new Node(last.x, last.y-Node.width, last.direction);
			break;
		case LEFT:
			node=new Node(last.x+Node.height, last.y,last.direction);
			break;
		case RIGHT:
			node=new Node(last.x-Node.height, last.y, last.direction);
			break;
		default:
			break;
		}
		last.next=node;
		node.pre=last;
		last=node;
	}
	public void draw(Graphics g){
		first.draw(g);
		first.move();
		Node node=first.next;
		while(node!=null){
			node.move();
			node.draw(g);
			if(node.direction==Direction.UP||node.direction==Direction.DOWN){
				if(node.x!=node.pre.x&&node.y==node.pre.y)node.direction=node.pre.direction;
				if(node.y!=node.pre.y)g.fillRect(node.x, node.pre.y, Node.width, Node.height);
			}else{
				if(node.y!=node.pre.y&&node.x==node.pre.x)node.direction=node.pre.direction;
				if(node.x!=node.pre.x)g.fillRect(node.pre.x, node.y, Node.width, Node.height);
			}
			if(node.next!=null)node=node.next;
			else break;
		}
	}
	public void changeDir(Direction dir){
		Direction dirF=first.direction;
		if(((dirF==Direction.LEFT||dirF==Direction.RIGHT)&&(dir==Direction.DOWN||dir==Direction.UP))
			||((dir==Direction.LEFT||dir==Direction.RIGHT)&&(dirF==Direction.DOWN||dirF==Direction.UP)))
		{
		Node node=first;
		Node first_node = null;
		boolean flag=false;
		switch (dir) {
		case UP:
				first_node=new Node(first.x, first.y-Node.width, dir);
			break;
		case DOWN:
				first_node=new Node(first.x, first.y+Node.width, dir);
			break;
		case LEFT:
				first_node=new Node(first.x-Node.height, first.y, dir);
			break;
		case RIGHT:
				first_node=new Node(first.x+Node.height, first.y, dir);
			break;
		default:
			break;
		}
			node.direction = dir;
			first = first_node;
			first.next = node;
			node.pre = first;
			last = last.pre;
			last.next = null;
		}
	}
	private class Node{
		int x;
		int y;
		Node pre=null;
		Node next=null;
		public static final int width= MyFrame.BLOCK_WIDTH;
		public static final int height= MyFrame.BLOCK_HEIGHT;
		Direction direction;
		public Node(int x,int y,Direction direction) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
			this.direction=direction;
		}
		public void draw(Graphics g){
			g.fillRect(x, y, MyFrame.BLOCK_WIDTH, MyFrame.BLOCK_HEIGHT);
			System.out.println("ÖØÐÂ»­");
		}
		public void move(){
			switch (direction) {
			case UP:
				y-=1;
				break;
			case DOWN:
				y+=1;
				break;
			case LEFT:
				x-=1;
				break;
			case RIGHT:
				x+=1;
				break;
			default:
				break;
			}
		}
	}
}

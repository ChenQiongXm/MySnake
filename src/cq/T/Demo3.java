package cq.T;

public class Demo3 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		GenericClass<Dog> dog=new GenericClass<>();
		dog.setObj(new Dog());
		dog.getObj().eat();

	}

}
//�����������ܵĲ�����������ֻ�ܽ���Animal������������
class GenericClass<T extends Animal>{
	private T obj;
	public void setObj(T obj){
		this.obj=obj;
	}
	public T getObj(){
		return obj;
	}
	
	
}
abstract class Animal{
	public  abstract void eat();
}
class Dog extends Animal{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
	System.out.println("�ӹ�ͷ");	
	}
}
class Cat extends Animal{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
	System.out.println("��С��");	
	}
}
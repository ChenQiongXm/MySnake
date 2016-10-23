package cq.T;

import java.util.Arrays;

public class MyContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
interface IContainer<T>{
	public void add(T obj);//���������Ԫ��
	public T get(int index);//��ȡָ������λ�õ�Ԫ��
	public int size();
	public T remove();
}
class ArrayList<T> implements IContainer<T>{
	//private T[] data=new T[10];//���󣬲��ܴ�����������
	private Object[]data=null;
	private int size=0;
	public ArrayList() {
		data=new Object[10];//��ʼ����СΪ10
	}
	public ArrayList(int capacity){
		data=new Object[10];
	}
	@Override
	public void add(T obj) {
		// TODO Auto-generated method stub
		//�ж�Ԫ�صĸ����Ƿ��Ѿ������������Ĵ�С��������Ӧ�ö�������������
		ensureCapacity(size+1);
		data[size++]=obj;//���Ԫ��
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return (T) data[index];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	private void ensureCapacity(int capacity){
		if(capacity>data.length){
			int oldCapacity=data.length;//��ȡԭ�����ݴ���
			int newCapacity=oldCapacity+(oldCapacity>>1);
			data=Arrays.copyOf(data, newCapacity);
		}
	}
}
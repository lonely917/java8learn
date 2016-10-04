package bityan.java8.test;

public class TestDefaultMethod {

	public static void main(String[] args) {
		
		//���нӿڵ�Ĭ��ʵ��
		Vehicle vehicle = new Vehicle() {
		};
		vehicle.print();
		
		//FourWheelDriverCarʵ��Vehicle��FourWheelDrice�ӿڣ�ʵ��print����
		FourWheelDriveCar car = new FourWheelDriveCar();
		car.print();
	}

}

interface Vehicle
{
	default void print()
	{
		System.out.println("vehicle");
	}
	
	default void speed()
	{
		System.out.println("speed up");
	}
}

interface FourWheelDrive
{
	default void print()
	{
		System.out.println("four wheel drive");
	}
}

class FourWheelDriveCar implements Vehicle, FourWheelDrive
{
	//Duplicate default methods named print with the parameters () and () are inherited 
	
	public void print()
	{
		System.out.println("four wheel drive - vehicle");
		
		//���ýӿ��е�ͬ���ķ���
		Vehicle.super.print();
		FourWheelDrive.super.print();
		
		//���ýӿ��еķ���,����������ʽһ��
		Vehicle.super.speed();
		speed();
	}
}
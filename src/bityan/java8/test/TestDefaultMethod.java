package bityan.java8.test;

public class TestDefaultMethod {

	public static void main(String[] args) {
		
		//带有接口的默认实现
		Vehicle vehicle = new Vehicle() {
		};
		vehicle.print();
		
		//FourWheelDriverCar实现Vehicle和FourWheelDrice接口，实现print方法
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
		
		//调用接口中的同名的方法
		Vehicle.super.print();
		FourWheelDrive.super.print();
		
		//调用接口中的方法,下面两种形式一样
		Vehicle.super.speed();
		speed();
	}
}
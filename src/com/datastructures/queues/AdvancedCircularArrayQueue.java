package com.datastructures.queues;

import com.datastructures.common.Employee;

public class AdvancedCircularArrayQueue {

	public static void main(String[] args) {
		Employee employee = new  Employee("nikhil", "karanjkar", 1);
		Employee employee1 = new  Employee("apoorva", "swami", 2);
		Employee employee2 = new  Employee("prachi", "karanjkar", 3);
		Employee employee3 = new  Employee("suhas", "karanjkar", 4);
		
		
		AdvancedCircularArrayQueue arrayQueue = new AdvancedCircularArrayQueue(3);
		
		arrayQueue.enqueue(employee);
		arrayQueue.enqueue(employee1);
		arrayQueue.enqueue(employee2);
		
		arrayQueue.printQueue();
		
		arrayQueue.enqueue(employee3);
		arrayQueue.printQueue();
		
		
		arrayQueue.enqueue(employee1);
		arrayQueue.enqueue(employee1);
		
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		
		arrayQueue.enqueue(employee1);
		arrayQueue.enqueue(employee1);
		
		arrayQueue.printQueue();
		
		
		
	}
	
	private Employee[] employees;
	private int front;
	private int rear;
	private int numOfItems;
	
	public AdvancedCircularArrayQueue(int capacity) {
		
		employees = new Employee[capacity];
		front =0;
		rear =0;
		numOfItems=0;
			
	}
	
	public void enqueue(Employee employee)
	{
		System.out.println("---------------------------------------");
		if(numOfItems == employees.length)
		{
			int initialLength =employees.length;
			Employee[] newemployees = new Employee[employees.length*2];
			System.arraycopy(employees, front,newemployees,0,employees.length);
			employees=newemployees;
			front=0;
			rear = initialLength;
			
		}
		
		if(rear == employees.length)
		{
			rear =0;
		}
		
		
		System.out.println("Enqueued " +employee.toString());
		employees[rear++] = employee;
		System.out.println("---------------------------------------");
		numOfItems++;
	}
	
	
	public Employee dequeue()
	{
		System.out.println("---------------------------------------");
		
		if(numOfItems == 0)
		{
			return null;
		}
		
		if(front ==employees.length)
		{
			front=0;
		}
		
		System.out.println("Dequeued " +employees[front].toString());
		System.out.println("---------------------------------------");
		
		numOfItems--;
		return employees[front++];
		
		
	}
	
	
	public Employee peek()
	{
		if(numOfItems == 0)
		{
			return null;
		}
		
		return employees[front];
	}
	
	
	public void printQueue() {
		
		System.out.println("---------------------------------------");
		int size = numOfItems;
		for(int i = front;  size!=0;i++)
		{
			if(i==employees.length)
			{
				i=0;
			}
			System.out.println("Printing "+employees[i].toString());
			size--;
		}
		
		System.out.println("---------------------------------------");
	}
	
}

package com.datastructures.queues;

import com.datastructures.common.Employee;

public class ArrayQueue {
	
	private int size=0;

	public static void main(String[] args) {
		
		Employee employee = new  Employee("nikhil", "karanjkar", 1);
		Employee employee1 = new  Employee("apoorva", "swami", 2);
		Employee employee2 = new  Employee("prachi", "karanjkar", 3);
		Employee employee3 = new  Employee("suhas", "karanjkar", 4);
		
		
		ArrayQueue arrayQueue = new ArrayQueue(4);
		
		arrayQueue.enqueue(employee);
		arrayQueue.enqueue(employee1);
		arrayQueue.enqueue(employee2);
		arrayQueue.enqueue(employee3);
		
		arrayQueue.printAll();
		
		arrayQueue.enqueue(employee);

		
		arrayQueue.printAll();
		
	    System.out.println(arrayQueue.dequeue());
		System.out.println(" ");
	    arrayQueue.enqueue(employee2);
	    
	    arrayQueue.printAll();
	    
	    System.out.println(arrayQueue.dequeue());
		System.out.println(" ");
	    System.out.println(arrayQueue.dequeue());
		System.out.println(" ");
	    System.out.println(arrayQueue.dequeue());
		System.out.println(" ");
	    System.out.println(arrayQueue.dequeue());
	    
	    System.out.println("finish dequeue ");
	    
	    arrayQueue.enqueue(employee);
	    
	    arrayQueue.printAll();
	    
	    
	
	}
	
	private int front;
	
	private int back;
	
	private Employee[] employees;
	
	public ArrayQueue(int capacity)
	{
		employees = new Employee[capacity];
		front=0;
		back = -1;
		
	}
	
	
	public void enqueue(Employee employee)
	{
		if(size ==employees.length)
		{
			return;
		}
		
		else if(front==employees.length)
		{
			front=0;
		}
		
		employees[front++]=employee;
		size++;
		
		
	}
	
	
	public Employee dequeue()
	{
		
		if(size == 0)
		{
			return null;
		}
		
		else if(back == employees.length -1)
		{
			 back =-1;
		}
		size--;
		
		Employee employee= employees[++back];
		
		employees[back]= null;
		return employee;
	}
	
	
	public Employee peek()
	{
		
		if(size == 0)
		{
			return null;
		}
		
		if(back == employees.length)
		{
			return employees[0];
		}
		
		return employees[back+1];
		
	}
	
	
	public void printAll()
	{
		for(int i =0; i<employees.length;i++)
		{
			System.out.println(employees[i]);
		}
		
		System.out.println("-----------------------------------------------------");
	}
	
	
	
	

}

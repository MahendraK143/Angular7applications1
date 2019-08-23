package com.sb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDbExampleApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		int a=6,b=4,c=55,d=876,e=1;
		int max = 0;
		if (a > b && a > c && a > d && a > e)
	    {
	        max = a;
	        Console.WriteLine("The biggest number from {0} , {1} and {2} is {3}.", a, b, c, max);
	    }
	    else if (b > a && b > c && b > d && b > e)
	    {
	        max = b;
	        Console.WriteLine("The biggest number from {0} , {1} and {2} is {3}.", a, b, c, max);
	    }
	    else if (c > a && c > b && c > d && c > e)
	    {
	        max = c;
	        Console.WriteLine("The biggest number from {0} , {1} and {2} is {3}.", a, b, c, max);
	    }
	    else if (d > a && d > b && d > c && d > e)
	    {
	        max = d;
	        Console.WriteLine("The biggest number from {0} , {1} and {2} is {3}.", a, b, c, max);
	    }
	    else
	    {
	        max = e;
	        Console.WriteLine("The biggest number from {0} , {1} and {2} is {3}.", a, b, c, max);
	    }
	}
}

package Rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

public class rough1 {

	public static void main(String[] args) {

		
		List<String> user= Arrays.asList("15","16","17","18","19","28","40","44");
	
		System.out.println(user.get(0));
		
		for (int i = 0; i < 12; i++) {
			if (i != 5 && i != 6) {
				System.out.println(i);
			}
		}
	
		
		}
}



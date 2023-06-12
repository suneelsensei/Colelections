package Rough;

public class random_num {

	public static void main(String[] args) {

//		int a = (int) (Math.random() * 1000000);
//		System.out.println(a);
//
//		Random rand = new Random();
//		// Generate random integers in range 0 to 999
//		int num1 = rand.nextInt(100);
//		System.out.println(num1);

		System.out.println("Returned:" + random(5));
	}

	public static int random(int num) {
		String zeros = "";
		double ran = Math.random();
		for (int i = 0; i < num; i++) {
			zeros = zeros + "0";
		}
		System.out.println(ran);
		int result = (int) (ran * Integer.parseInt("1" + zeros));
		System.out.println("Result:" + result);

		String digits = String.valueOf(result);
		System.out.println(digits.length());

		if (digits.length() < num) {
			return random(num);
		}

		return result;

	}

}

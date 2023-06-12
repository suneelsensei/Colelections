package Rough;

public class rough1 {

	public static void main(String[] args) {
		one: for (int i = 33; i <= 128; i++) {
//			System.out.println(" The ASCII value of " + (char) i + "  =  " + i);
			for (int j = 33; j <= 128; j++) {
				for (int k = 33; k <= 128; k++) {
					for (int b = 33; b <= 128; b++) {
//						for (int c = 33; c <= 128; c++) {
//							for (int d = 33; d <= 128; d++) {
//								for (int e = 33; e <= 128; e++) {
//									for (int f = 33; f <= 128; f++) {
//
//										for (int g = 33; g <= 128; g++) {
											String a = "" + (char) i + (char) j+ (char) k+ (char) b;//+ (char) c+ (char) d+ (char) e+ (char) f+ (char) g;
											System.out.println(a);
											if (a.equals("!une")) {
												break one;
											}
										}

									}
								}
//							}
//						}
//					}
//				}
//			}
		}
	}
}

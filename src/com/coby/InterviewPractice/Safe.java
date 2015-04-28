package com.coby.InterviewPractice;

public class Safe {

	public static void main(String[] args) {

		String combo = generateComboMod();
		System.out.println(combo);
		System.out.println(testCombo(combo));

	}

	public static boolean testCombo(String combo) {
		boolean ret = true;
		int[] check = new int[10000];

		for (int i = 0; i < check.length; i++) {
			check[i] = 0;
		}

		for (int i = 0; i < combo.length() - 3; i++) {
			String testCombo = combo.substring(i, i + 4);
			check[Integer.valueOf(testCombo)]++;
			if (check[Integer.valueOf(testCombo)] >= 2 || testCombo.equals("8898")) {
				System.out.println(testCombo + " " + combo.substring(i - 4, i - 1) + " " + combo.substring(i, i + 4) + " " + combo.substring(i + 4, i + 4));
			}
		}

		for (int i = 0; i < check.length; i++) {
			if (check[i] == 0) {
				ret = false;
				System.out.println(i);
			} else if (check[i] > 1){
				 System.out.println(i);
			}
		}
		System.out.println(combo.length());
		return ret;
	}

	public static String shittyGenerateCombo() {
		String ret = "";
		for (int i = 0; i < 10000; i++) {
			ret = ret + String.format("%04d", i);
		}
		return ret;
	}
	
	public static String generateCombo() {
		String ret = "0";
		boolean[] check = new boolean[10000];
		for (int i = 1; i < 10000; i++) {
			if (!check[i]) {
				ret = ret + String.format("%04d", i);
				for (int j = ret.length() - 7; j <= ret.length() - 4; j++) {
					if (j >= 0) {
						if (check[Integer.valueOf(ret.substring(j, j + 4))]) {
							System.out.println(i + ": "
									+ ret.substring(j, j + 4) + " : " + ret.substring(ret.length() - 10));
//							System.out.println();
						}
						check[Integer.valueOf(ret.substring(j, j + 4))] = true;
					}
				}
			}
		}
		return ret;
	}

	public static String generateComboMod() {
		String ret = "0";
		boolean[] check = new boolean[10000];
		for (int i = 1; i < 10000; i++) {
			if (!check[i]) {
				String add = String.format("%04d", i);
				int subCheck = 0;
				
				for (int j = 1; j <= 3; j++) {
					if (ret.length() - (4 - j) >= 0) {
						String s = ret.substring(ret.length() - (4 - j))+ add.substring(0,j);
						if (check[Integer.valueOf(s)]) {
							subCheck++;
						} else {
							check[Integer.valueOf(s)] = true;
						}
					}
				}
				check[Integer.valueOf(add)] = true;
				
//				if(subCheck == 3 && !add.matches("(\\d)\\1{2}.*")) {
				if (add.equals("8899")) {
					ret = ret + add.substring(subCheck - 2);
				} else {
					ret = ret + add.substring(subCheck);
				}
			}
		}
		return ret;
	}

}

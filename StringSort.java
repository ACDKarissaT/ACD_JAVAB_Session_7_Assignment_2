package assignment2;

import java.util.Scanner;

public class StringSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		boolean repeat = false;
		while (true) {
			if (!repeat) {
				System.out.print("Enter string: ");
			} else {
				System.out.println("Press enter again to exit.");
			}
			s = sc.nextLine();
			if (s.length() == 0) {
				if (repeat) {
					break;
				} else {
					repeat = true;
				}
			} else {
				repeat = false;
				String ret = "";
				s=s.trim();
				String[] arr = s.split("\\s+");
				sort(arr, arr.length);
				for(String st: arr) {
					String[] let = st.split("");
					sort(let, let.length);
					for(String l : let) {
						ret += l;
					}
					ret+= " ";
				}
				System.out.println(ret);
			}
		}
		
		sc.close();
	}
	static void sort(String[] arr, int size) {
		if (size == 0 || size == 1 || arr == null) return;
		int c = arr.length - size;
		int position = -1;
		String min = null;
		for (int i = 0; i < size; i++) {
			if (min == null || arr[c+i].compareToIgnoreCase(min) < 0) {
				min = arr[c+i];
				position = c+i;
			}
		}
		if (position < 0) return;
		String tmp = arr[c];
		arr[c] = arr[position];
		arr[position] = tmp;
		sort(arr, size-1);
	}
}

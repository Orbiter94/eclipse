
public class Aufgabe11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] testfeld = new int[] { 0, 5, 3, 4, 2, 1 };

		quickSort3M(testfeld, 0, testfeld.length - 1);

		for (int i = 0; i < testfeld.length; i++) {
			System.out.println(testfeld[i]);
		}

	}

	public static void quickSort3M(int[] values, int l, int r) {
		int left = l;
		int right = r;
		int pivot = (l + r) / 2;
		// (0+(values.length/2)+values.length)/3;

		while (left < right) {
			while (values[left] < values[pivot]) {
				left++;
			}

			while (values[right] > values[pivot]) {
				right--;
			}

			if (values[left] >= values[right]) {
				int temp = values[left];
				values[left] = values[right];
				values[right] = temp;
				left++;
				right--;
			}
		}

		if (left < r) {
			quickSort3M(values, l, left);
		}
		if (right > l) {
			quickSort3M(values, right, r);
		}
	}
}

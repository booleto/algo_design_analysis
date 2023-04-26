public class Value {
	
	public long getMaxValue(int[] v)
	{
		Value val = new Value();
	    val.sort(v, 0, v.length - 1);
		return calcSum(v);
	}

	int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }


	long calcSum(int[] arr) {
		int min = arr[0];
		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == min) {
				continue;
			}
			result += arr[i];
		}
		return result;
	}
}
class Arr {
    public static void main(String[] args) {
        int [] a = {3,1,-40,1,200,5};
        a = Arr.reverse(a);
        System.out.println(Arr.toString(a));
    }

    public static String toString(int [] a) {
        String result = "";
        int i = 1;
        for(int number: a) {
            result += number;
            if (i++ != a.length) {
                result += ", ";
            }
        }
        return result;
    }

/*    public static void sort(int [] a) {
        sort(a);
    }*/
    public static int[] reverse(int[] a) {
        int size = a.length;
        for (int i = 0; i < size / 2; i++) {
            int temp = a[i];
            a[i] = a[size - i - 1];
            a[size - i - 1] = temp;
        }
        return a;
    }

    public static String join(int[] a, String glue) {
        String result = "";
        int i = 1;
        for(int number: a) {
            result += number;
            if (i++ != a.length) {
                result += glue;
            }
        }
        return result;
    }

    public static int sum(int[] a) {
        int result = 0;
        for(int number: a) {
            result += number;
        }
        return result;
    }

    public static int[] range(int a, int b) {
        int array_size = b - a;
        int [] result = new int [array_size];
        int j = 0;
        for (int i = a; i < b; i++) {
            result[j++] = i;
        }
        return result;
    }

    public static int[] filterOdd(int[] a) {
        int [] result = new int [a.length];
        int i = 0;
        for(int number: a) {
            if(number % 2 != 0) {
                result[i++] = number;
            }
        }
        return result;
    }
}

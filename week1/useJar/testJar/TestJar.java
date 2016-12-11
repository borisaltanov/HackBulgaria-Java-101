package testjar;

import arr.Arr;

class MyMain{
    public static void main(String[] args) {
        String[] arr = {"This", "is", "an", "array"};

        String line = Arr.glue(arr, " ");
        System.out.println(line);
    }
}

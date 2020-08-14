package Day_2;

public class Answer {
    public static void main(String[] args) {
        int[] array = new int[]{2, 8, 6, 4, 3, 5, 9};
        for (int i_n = 0; i_n < array.length; i_n++)

            System.out.print(array[i_n] + " ");
        System.out.println("");

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j = i +1; j < array.length; j++){
                if (array[j] < min){
                    min = array[j];
                    min_i = j;
                }
                if (i != min_i) {
                    int tmp = array[i];
                    array[i] = array[min_i];
                    array[min_i] = tmp;
                }
            }
            System.out.print(array[i] + " ");
        }

    }
}

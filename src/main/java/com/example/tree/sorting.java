import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class sorting {
    static int MIN_MERGE = 32;

    private static class Data {
        String name;
        long size;
        long comparisons;
        long exchanges ;
        double timetaken;
        public String toString(){
            return size+","+name+"," + comparisons+", " + exchanges +", "+ timetaken;

        }
    }
    public static Data sort(int[] arr){
        Data d =  new Data();


        return d;
    }
    public static int[] makearray(int length){
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i< arr.length;i++) {
            arr[i] = random.nextInt(10001);
        }
        return arr;
    }


    public static void Insertion_Sort(int[] arr,Data data) {
        data.name = "Insertion Sort";
        Long start= System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;
            data.comparisons++;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev -= 1;
                data.comparisons++;
                data.exchanges++;
            }
            arr[prev + 1] = current;
            data.comparisons++;
        }
        Long end = System.currentTimeMillis();
        data.timetaken = end - start;
//from geekforgeek///

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high, Data data) {

        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {


            if (arr[j] < pivot) {

                data.comparisons++;
                i++;
                swap(arr, i, j);
                data.exchanges++;
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void Quicksort(int[] arr, int low, int high, Data data) {
        data.name = "Quick Sort";
        if (low < high) {
            int pie = partition(arr, low, high,data);
            Quicksort(arr, low, pie - 1,data);
            Quicksort(arr, pie + 1, high,data);
        }
    }
    //Quick sort is from geek for geek;

    static void QSwrapper (int[] arr, Data data){
        Long start= System.currentTimeMillis();
        int n = arr.length;
        Quicksort(arr,0,n-1,data);
        Long end = System.currentTimeMillis();
        data.timetaken = end - start;
    }

    public static int minRunLength(int n) {
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int l1 = m - l + 1, l2 = r - m;
        int[] left = new int[l1];
        int[] right = new int[l2];
        for (int x = 0; x < l1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < l2; x++) {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < l1 && j < l2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < l2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void Timsort(int[] arr, int i, Data data) {
        data.name = "Tim Sort";
        int minRun = minRunLength(MIN_MERGE);
        for (int size = minRun; size < i; size = 2 * size) {
            for (int left = 0; left < i; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (i - 1));
                if (mid < right) {
                    data.comparisons++;
                    merge(arr, left, mid, right);
                    data.exchanges++;
                }
            }
        }
    }
    ///Timsort, merge, minlengthrun are from geeks for geeks.///
    static void TSwrapper (int[] arr, Data data){
        Long start= System.currentTimeMillis();
        int n = arr.length;
        Timsort(arr,n,data);
        Long end = System.currentTimeMillis();
        data.timetaken = end - start;
    }

    public static void main(String[] args) {
        ArrayList<Data> datalist = new ArrayList<>();
        for (int i = 6; i <= 16; i++) {
            int n = (int) Math.pow(2, i);
            int[] arr = makearray(n);
            Data d = new Data();
            d.size = n;
            Insertion_Sort(arr, d);
            datalist.add(d);
            System.out.println(n + " size, " + "\t" + d);
            int[] arry = makearray(n);
            Data r = new Data();
            r.size = n;
            QSwrapper(arry, r);
            datalist.add(r);
            System.out.println(n + " size, " + "\t" + r);
            int[] arrs = makearray(n);
            Data s = new Data();
            s.size = n;
            TSwrapper(arrs, s);
            datalist.add(s);
            System.out.println(n + " size, " + "\t" + s);
        }
        try{
            FileWriter writer = new FileWriter("Data.csv");
            String[] headers = {"Size","Name","Comparisons","Exchanges","Time Taken"};
            for(String category : headers) {
                writer.append(category +",");
            }

            writer.append("\n");
            for (Data d :datalist){
                //write the row
                writer.append(d + ",");
                writer.append("\n"); //go to next row
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




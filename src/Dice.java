public class Dice {
    static int findCeil(int arr[], int r, int l, int h) {
        int mid;
        while (l < h) {
            mid = l + ((h - l) >> 1);
            if (r > arr[mid])
                l = mid + 1;
            else
                h = mid;
        }
        return (arr[l] >= r) ? l : -1;
    }
    static int myRand(int arr[], int freq[], int n) {
        int prefix[] = new int[n];
        int i;
        prefix[0] = freq[0];
        for (i = 1; i < n; ++i)
            prefix[i] = prefix[i - 1] + freq[i];
        int r = ((int) (Math.random() * (323567)) % prefix[n - 1]) + 1;
        int indexc = findCeil(prefix, r,0, n - 1);
        return arr[indexc];
    }

    static int[] Freq(int Dice){
        int freq[] = new int[6];
        for(int i = 0; i < 6; i++){
            freq[i] = 4;
        }
        freq[Dice] = 5;
        return freq;

    }
    static int DiceNumber(int Dice)
    {
        int arr[] = {1, 2, 3, 4, 5, 6};

        int i, n = arr.length;

        return myRand(arr, Freq(Dice), n);
    }
}

package arrays.misc;

import arrays.sortingAlgo.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;

public class NextGreatestNumber {
    private int sizeOfNumber(long n) {
        int ans = 0;
        while(n!=0) {
            ans++;
            n/=10;
        }
        return ans;
    }
    public int nextGreaterNumber(int num) {
        long n = num;
        if(n<10) return -1;
        long[] digits = new long[sizeOfNumber(n)];
        long temp = n;
        for(int i=digits.length-1; i>=0; i--) {
            digits[i] = temp%10;
            temp = temp/10;
        }
        int changeDigit=digits.length-2;
        while(changeDigit>=0 && digits[changeDigit]>=digits[changeDigit+1]) {
            changeDigit--;
        }
        if(changeDigit==-1) return -1;
        int targetDigit = digits.length-1;
        while(digits[targetDigit] <= digits[changeDigit]) {
            targetDigit--;
        }
        temp = digits[targetDigit];
        digits[targetDigit] = digits[changeDigit];
        digits[changeDigit] = temp;

        Arrays.sort(digits, changeDigit+1, digits.length);

        long ans = 0;
        for(int i=0; i<digits.length; i++) {
            ans = 10*ans + digits[i];
        }
        if(ans>2147483647) return -1;
        return (int)ans;
    }
}

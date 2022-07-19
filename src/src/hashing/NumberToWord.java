package hashing;

public class NumberToWord {
    String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] tens = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    String convert(long numm) {
        int num = (int)numm;
        if(num<20) {
            return ones[num];
        }
        if(num%10==0) return tens[num/10];
        return tens[num/10] + " " + ones[num%10];
    }
    String convertToWords(long n, int k) {
        // code here
        if(n==0) return "zero";
        long last2 = n%100;
        n = n/100;
        long hundred = n%10;
        n = n/10;
        long thousands = n%100;
        n = n/100;
        long lakhs = n%100;
        n = n/100;
        long crores = n;
        String ans = "";
        if(crores>0) {
            ans = ans + convert(crores) + " crore ";
        }
        if(lakhs>0) {
            ans = ans + convert(lakhs) + " lakh ";
        }
        if(thousands>0) {
            ans = ans + convert(thousands) + " thousand ";
        }
        if(hundred>0) {
            ans = ans + convert(hundred) + " hundred ";
        }
        if(last2>0) {
            if(ans.length() > 0) ans = ans + "and ";
            ans = ans + convert(last2);
        }
        return ans;
    }
}

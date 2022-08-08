package fbleetcode;

public class IntegerToWords {
    private String toWord(int num) {
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String ans = "";

        int hundred = num/100;
        int remaining = num%100;
        boolean spaceReq = false;

        if(hundred > 0) {
            ans = ans + units[hundred] + " Hundred";
            spaceReq = true;
        }

        if(remaining > 0) {
            if(spaceReq) ans = ans + " ";
            spaceReq = false;

            if(remaining <= 20) {
                ans = ans + units[remaining];
                return ans;
            }

            int ten = remaining/10;
            remaining = remaining % 10;

            if(ten > 0) {
                ans = ans + tens[ten];
                spaceReq = true;
            }

            if(remaining > 0) {
                if(spaceReq) ans = ans + " ";
                spaceReq = false;

                ans = ans + units[remaining];
            }
        }

        return ans;
    }

    public String numberToWords(int num) {

        if(num == 0) return "Zero";

        int last3 = num%1000;
        num = num/1000;

        int thousands = num % 1000;
        num = num/1000;

        int millions = num%1000;
        num = num/1000;

        int billions = num;

        String ans = "";
        boolean spaceReq = false;

        if(billions > 0) {
            ans = ans + toWord(billions) + " Billion";
            spaceReq = true;
        }

        if(millions > 0) {
            if(spaceReq) ans = ans + " ";
            ans = ans + toWord(millions) + " Million";
            spaceReq = true;
        }

        if(thousands > 0) {
            if(spaceReq) ans = ans + " ";
            ans = ans + toWord(thousands) + " Thousand";
            spaceReq = true;
        }

        if(last3 > 0) {
            if(spaceReq) ans = ans + " ";
            ans = ans + toWord(last3);
        }
        return ans;
    }
}

package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {
    static long jumpingNums(long X) {
        // code here
        Queue<Long> queue = new LinkedList<>();
        for(long i=1; i<10; i++) queue.add(i);

        long ans = 0;
        while(queue.size() > 0 && queue.peek() <= X) {
            ans = queue.poll();
            long num1 = 10*ans + (ans%10 - 1);
            long num2 = 10*ans + (ans%10 + 1);

            if(ans%10 == 0) num1 = -1;
            if(ans%10 == 9) num2 = -1;

            if(num1 != -1 && num1<=X) queue.add(num1);
            if(num2 != -1 && num2<=X) queue.add(num2);
        }
        return ans;
    }
}

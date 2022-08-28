package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MaximumProfitJobScheduling {
    class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i=0; i<startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.end < o2.end) return -1;
                if(o1.end > o2.end) return 1;
                return 0;
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0,0);
        int ans = 0;

        for(int i=0; i<jobs.length; i++) {
            int temp = map.floorEntry(jobs[i].start).getValue();
            if(temp + jobs[i].profit > ans) {
                ans = temp + jobs[i].profit;
                map.put(jobs[i].end, ans);
            }
        }
        return ans;
    }
}

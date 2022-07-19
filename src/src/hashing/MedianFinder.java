package hashing;

import java.util.ArrayList;

public class MedianFinder {
    ArrayList<Integer> maxHeap;
    ArrayList<Integer> minHeap;

    private void maxHeapifyDown(int index) {
        int maxIndex = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if(left<maxHeap.size() && maxHeap.get(left) > maxHeap.get(maxIndex)) maxIndex = left;
        if(right<maxHeap.size() && maxHeap.get(right) > maxHeap.get(maxIndex)) maxIndex = right;

        if(maxIndex != index) {
            maxHeap.set(index, maxHeap.get(index) ^ maxHeap.get(maxIndex));
            maxHeap.set(maxIndex, maxHeap.get(index) ^ maxHeap.get(maxIndex));
            maxHeap.set(index, maxHeap.get(index) ^ maxHeap.get(maxIndex));
            maxHeapifyDown(maxIndex);
        }
    }

    private void maxHeapifyUp(int index) {
        if(index==0) return;
        int parent = (index-1)/2;
        if(maxHeap.get(parent) < maxHeap.get(index)) {
            maxHeap.set(index, maxHeap.get(index) ^ maxHeap.get(parent));
            maxHeap.set(parent, maxHeap.get(index) ^ maxHeap.get(parent));
            maxHeap.set(index, maxHeap.get(index) ^ maxHeap.get(parent));
            maxHeapifyUp(parent);
        }
    }

    private void minHeapifyDown(int index) {
        int minIndex = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if(left<minHeap.size() && minHeap.get(left) < minHeap.get(minIndex)) minIndex = left;
        if(right<minHeap.size() && minHeap.get(right) < minHeap.get(minIndex)) minIndex = right;

        if(minIndex != index) {
            minHeap.set(index, minHeap.get(index) ^ minHeap.get(minIndex));
            minHeap.set(minIndex, minHeap.get(index) ^ minHeap.get(minIndex));
            minHeap.set(index, minHeap.get(index) ^ minHeap.get(minIndex));
            minHeapifyDown(minIndex);
        }
    }

    private void minHeapifyUp(int index) {
        if(index==0) return;
        int parent = (index-1)/2;
        if(minHeap.get(parent) > minHeap.get(index)) {
            minHeap.set(index, minHeap.get(index) ^ minHeap.get(parent));
            minHeap.set(parent, minHeap.get(index) ^ minHeap.get(parent));
            minHeap.set(index, minHeap.get(index) ^ minHeap.get(parent));
            minHeapifyUp(parent);
        }
    }

    public MedianFinder() {
        maxHeap = new ArrayList<>();
        minHeap = new ArrayList<>();
    }

    public void addNum(int num) {
        if(maxHeap.size()==0) {
            maxHeap.add(num);
            return;
        }
        if(minHeap.size()==0) {
            if(num>maxHeap.get(0)) {
                minHeap.add(num);
                return;
            }
            minHeap.add(maxHeap.get(0));
            maxHeap.set(0,num);
            return;
        }

        if(maxHeap.size() == minHeap.size()) {
            if(num < minHeap.get(0)) {
                maxHeap.add(num);
                maxHeapifyUp(maxHeap.size()-1);
                return;
            }
            else {
                maxHeap.add(minHeap.get(0));
                maxHeapifyUp(maxHeap.size()-1);
                minHeap.set(0,num);
                minHeapifyDown(0);
                return;
            }
        }
        // Element should go right side
        if(num > maxHeap.get(0)) {
            minHeap.add(num);
            minHeapifyUp(minHeap.size()-1);
            return;
        }
        minHeap.add(maxHeap.get(0));
        minHeapifyUp(minHeap.size()-1);
        maxHeap.set(0,num);
        maxHeapifyDown(0);
    }

    public double findMedian() {
        if(maxHeap.size()==0) return 0;
        if(maxHeap.size()==minHeap.size()) {
            double ans = maxHeap.get(0);
            ans += minHeap.get(0);
            return ans/2;
        }
        return maxHeap.get(0);
    }
}

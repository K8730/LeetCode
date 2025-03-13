import java.util.PriorityQueue;

public class Leetcode295 {

}

// 数据流的中位数

class MedianFinder {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        // queMax: 11 12
        // queMin: 10 9 8
        queMax = new PriorityQueue<>((a, b) -> (a - b));// 最小堆
        queMin = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMin.size() - queMax.size() >= 2) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size())
            return queMin.peek();
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
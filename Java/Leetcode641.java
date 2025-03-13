public class Leetcode641 {

}

// 设计循环双端队列
class MyCircularDeque {

    public int[] deque;
    public int left, right, size, limit;

    public MyCircularDeque(int k) {
        deque = new int[k];
        left = right = size = 0;
        limit = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                left = right = 0;
                deque[0] = value;
            } else {
                // 如果 left 在0位置, 就跳到最后
                left = (left == 0) ? (limit - 1) : (left - 1);
                deque[left] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                left = right = 0;
                deque[0] = value;
            } else {
                // 如果 right 在最后, 就跳到0位置
                right = (right == limit - 1) ? 0 : (right + 1);
                deque[right] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            left = (left == limit - 1) ? 0 : (left + 1);
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            right = (right == 0) ? (limit - 1) : (right - 1);
            size--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[left];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[right];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

}
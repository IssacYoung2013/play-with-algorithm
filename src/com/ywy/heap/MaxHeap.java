package com.ywy.heap;

/**
 * author:  ywy
 * date:    2018-12-24
 * desc:
 */
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int capacity;
    protected int count;

    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(Item[] arr) {

        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];
        this.capacity = n;

        for (int i = 0; i < n; i++) {
            data[i+1] = arr[i];
        }
        count = n;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);

    }

    /**
     * 核心辅助函数
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }


    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;

        shiftDown(1);

        return ret;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        PrintableMaxHeap maxHeap = new PrintableMaxHeap(100);
        int N = 11; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0,M)
        for (int i = 0; i < N; i++) {
            maxHeap.insert((int) (Math.random() * M));
        }
        maxHeap.treePrint();

        for (int i = 0; i < N / 2; i++) {
            System.out.print(maxHeap.extractMax() + " ");
            maxHeap.treePrint();

        }


    }
}


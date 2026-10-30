// class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         double[] ans=new double[n-k+1];
        
//         for(int i=0;i<=n-k;i++)
//         {
//             long arr[]=new long[k];
//             int idx=0;
//             for(int j=i;j<i+k;j++)
//             {
//                 arr[idx]=nums[j];
//                 idx++;
//             }
//             Arrays.sort(arr);
//             if(k%2!=0)
//             {
//                 ans[i]=arr[k/2];
//             }
//             else
//             {
//                 long sum=arr[k/2]+arr[k/2-1];
//                 ans[i]=sum/2.0;
//             }
//         }
//         return ans;
//     }
// }


import java.util.*;

class Solution {

    PriorityQueue<Long> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Long> large = new PriorityQueue<>();

    Map<Long, Integer> delayed = new HashMap<>();

    int smallSize = 0, largeSize = 0;

    void prune(PriorityQueue<Long> heap) {
        while (!heap.isEmpty()) {
            long x = heap.peek();

            if (delayed.getOrDefault(x, 0) > 0) {
                heap.poll();

                delayed.put(x, delayed.get(x) - 1);
            } else {
                break;
            }
        }
    }

    void balance() {
        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        }
        else if (smallSize < largeSize) {
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }

    void add(long x) {
        if (small.isEmpty() || x <= small.peek()) {
            small.offer(x);
            smallSize++;
        } else {
            large.offer(x);
            largeSize++;
        }

        balance();
    }

    void remove(long x) {
        delayed.put(x, delayed.getOrDefault(x, 0) + 1);

        if (x <= small.peek()) {
            smallSize--;

            if (x == small.peek())
                prune(small);
        } else {
            largeSize--;

            if (!large.isEmpty() && x == large.peek())
                prune(large);
        }

        balance();
    }

    double getMedian(int k) {
        if (k % 2 == 1)
            return small.peek();

        return ((double) small.peek() + large.peek()) / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        for (int i = 0; i < n; i++) {

            // Add new element
            add(nums[i]);

            // Remove element outside the window
            if (i >= k) {
                remove(nums[i - k]);
            }

            // Calculate median
            if (i >= k - 1) {
                ans[i - k + 1] = getMedian(k);
            }
        }

        return ans;
    }
}

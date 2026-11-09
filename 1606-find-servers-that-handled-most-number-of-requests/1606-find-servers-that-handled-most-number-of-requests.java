
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int n = arrival.length;

        // Count requests handled by each server
        int[] count = new int[k];

        // Store available servers in sorted order
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Store {completionTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) {

            // 1. Release servers whose requests are completed
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {

                int[] server = busy.poll();

                available.add(server[1]);
            }

            // 2. If all servers are busy, drop request
            if (available.isEmpty()) {
                continue;
            }

            // 3. Find preferred server
            int preferred = i % k;

            // Find next available server
            Integer server = available.ceiling(preferred);

            // 4. Wrap around if necessary
            if (server == null) {
                server = available.first();
            }

            // 5. Assign request
            available.remove(server);

            count[server]++;

            // 6. Calculate completion time
            int completionTime = arrival[i] + load[i];

            busy.offer(new int[]{completionTime, server});
        }

        // 7. Find maximum number of requests
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // 8. Collect busiest servers
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}

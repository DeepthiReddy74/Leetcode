import java.util.*;
class JumpgameIV{
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currIdx = queue.poll();
                if (currIdx == n - 1) {
                    return steps;
                }
                if (graph.containsKey(arr[currIdx])) {
                    for (int nextIdx : graph.get(arr[currIdx])) {
                        if (!visited[nextIdx]) {
                            visited[nextIdx] = true;
                            queue.offer(nextIdx);
                        }
                    }
                    graph.remove(arr[currIdx]);
                }
                if (currIdx + 1 < n && !visited[currIdx + 1]) {
                    visited[currIdx + 1] = true;
                    queue.offer(currIdx + 1);
                }
                if (currIdx - 1 >= 0 && !visited[currIdx - 1]) {
                    visited[currIdx - 1] = true;
                    queue.offer(currIdx - 1);
                }
            }
            steps++;
        }

        return -1;
    }
}
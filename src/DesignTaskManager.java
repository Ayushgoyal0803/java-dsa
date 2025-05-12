/*
https://leetcode.com/problems/design-task-manager/description/?envType=problem-list-v2&envId=design
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignTaskManager {
    class T {
        int userid, taskid, p;
        boolean valid;

        T(int u, int t, int pr) {
            this.userid = u;
            this.taskid = t;
            this.p = pr;
            this.valid = true;
        }
    }

    class TaskManager {
        Map<Integer, T> map = new HashMap<>();
        PriorityQueue<T> pq = new PriorityQueue<>((a, b) -> {
            if (a.p == b.p) {
                return Integer.compare(b.taskid, a.taskid);
            } else {
                return Integer.compare(b.p, a.p);
            }
        });

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> lst : tasks) {
                int userid = lst.get(0);
                int taskid = lst.get(1);
                int p = lst.get(2);
                T t = new T(userid, taskid, p);
                map.put(taskid, t);
                pq.add(t);
            }
        }

        public void add(int userId, int taskId, int priority) {
            T t = new T(userId, taskId, priority);
            pq.add(t);
            map.put(taskId, t);
        }

        public void edit(int taskId, int newPriority) {
            if (!map.containsKey(taskId)) return;

            // Invalidate the old task
            T oldTask = map.get(taskId);
            oldTask.valid = false;

            // Add the updated task
            T newTask = new T(oldTask.userid, taskId, newPriority);
            pq.add(newTask);
            map.put(taskId, newTask);
        }

        public void rmv(int taskId) {
            if (!map.containsKey(taskId)) return;

            // Invalidate the task
            T task = map.get(taskId);
            task.valid = false;
            map.remove(taskId);
        }

        public int execTop() {
            while (!pq.isEmpty()) {
                T found = pq.poll(); // Get the highest-priority task
                if (found.valid) { // Check if the task is valid
                    map.remove(found.taskid); // Remove it from the map
                    return found.userid; // Return the userId
                }
            }
            return -1; // If no valid tasks are found
        }
    }
/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
}

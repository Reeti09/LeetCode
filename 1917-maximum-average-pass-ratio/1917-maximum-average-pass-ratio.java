import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store each class using a custom comparator based on the improvement
        // in pass ratio by adding one extra student to the class.
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            double improvementA = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double improvementB = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(improvementB, improvementA); // Max-heap, so we invert the comparison
        });
      
        // Populate the priority queue with the pass ratio of each class
        for (int[] cls : classes) {
            priorityQueue.offer(new double[] {cls[0], cls[1]});
        }
      
        // Distribute the extra students to the classes where they would cause the highest improvement
        while (extraStudents-- > 0) {
            double[] currentClass = priorityQueue.poll();
            double passes = currentClass[0] + 1, totalStudents = currentClass[1] + 1;
            priorityQueue.offer(new double[] {passes, totalStudents});
        }
      
        // Calculate the total average ratio after all extra students have been distributed
        double totalAverageRatio = 0;
        while (!priorityQueue.isEmpty()) {
            double[] classRatio = priorityQueue.poll();
            totalAverageRatio += classRatio[0] / classRatio[1];
        }
      
        // Return the final average ratio by dividing by the total number of classes
        return totalAverageRatio / classes.length;
    }
}

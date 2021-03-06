package org.walmart.gs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToHireEmployees {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for(int i = 0; i < n; i++)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = Double.MAX_VALUE;
        int sum = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();
        for(Worker worker : workers) {
            pool.offer(-worker.quality);
            sum += worker.quality;
            if(pool.size() > K)
                sum += pool.poll();
            if(pool.size() == K)
                ans = Math.min(ans, sum * worker.ratio());
        }
        return ans;
    }

    class Worker implements Comparable<Worker> {
        int quality, wage;
        public Worker(int q, int w){
            quality = q;
            wage = w;
        }

        public double ratio() {
            return (double) wage / quality;
        }

        public int compareTo(Worker other){
            return Double.compare(ratio(), other.ratio());
        }
    }

    public static void main(String[] args) {
        MinCostToHireEmployees min = new MinCostToHireEmployees();
        min.mincostToHireWorkers(new int[]{10,20,5},
        new int[]{70,50,30},
        2);
    }
}

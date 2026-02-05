package Algorithms;

import Type.*;

import java.util.*;

/*
Class SJF:
    - Shortest Job First algo
    - has schedule function which takes list of jobs and returns ScheduleResult obj
 */

public class SJF {

    public static ScheduleResult schedule(List<ProcessJob> processes){
        int time = 0;

        //queue up all processes into prio queue (sorts by burst time)
        PriorityQueue<ProcessJob> jobQ = new PriorityQueue<>(Comparator.comparingInt(ProcessJob -> ProcessJob.burstTime));
        jobQ.addAll(processes);

        //complete jobs
        while (!jobQ.isEmpty()) {
            ProcessJob pj = jobQ.poll();
            time += pj.burstTime;
            pj.completionTime = time;
        }

        return new ScheduleResult(processes);
    }
}

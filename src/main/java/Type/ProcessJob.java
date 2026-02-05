package Type;
/*
Class ProcessJob:
    - embodies 1 job or process
    - has a title and burstTime
    - completionTime should be set during scheduling
 */

public class ProcessJob {
    public int completionTime;
    public int burstTime;
    public String title;

    public ProcessJob(String title, int bt){
        title = title;
        burstTime = bt;
    }
}

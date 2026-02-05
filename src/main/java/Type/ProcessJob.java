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
    public int remainingTime;

    public ProcessJob(String title, int bt){
        this.title = title;
        burstTime = bt;
        remainingTime = burstTime;
    }

    @Override
    public String toString() {
        return this.title + " - Burst: "+this.burstTime + " Completion: "+this.completionTime;
    }
}

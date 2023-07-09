public class Timing {

    private int startTime;
    private int endTime;

    public Timing ( int startTime, int endTime ) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime () {
        return this.startTime;
    }

    public int getEndTime () {
        return this.endTime;
    }

    public void setStartTime ( int startTime ) {
        this.startTime = startTime;
    }

    public void setEndTime ( int endTime ) {
        this.endTime = endTime;
    }

    public String toString ( ) {
        return this.startTime + " " + this.endTime;
    }
}

package chapter11.Task7;

public class Time {
    public int hours;
    public int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours >= 0 ? hours : 0;
        this.minutes = minutes >= 0 && minutes < 60? minutes : 0;
    }

    public Time add(Time time) {
        this.minutes += time.minutes % 60;
        this.hours += time.hours + this.minutes / 60;
        return this;
    }

    public int difference(Time time) {
        return (hours * 60 + minutes) - (time.hours * 60 + time.minutes);
    }

    public int getMinutes() {
        return this.hours * 60 + this.minutes;
    }
}
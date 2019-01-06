package haxidenti.jcronlib;

public class JCron {
    private JCron(){}

    public static Job createJob(int interval, Task t) {
        return new Job(interval, t, false);
    }

    public static Job createJobOnce(int timeout, Task t) {
        return new Job(timeout, t, true);
    }

    public static void update(int count, Job... jobs) {
        for (Job job : jobs) {
            job.update(count);
        }
    }

    public static class Job {
        private int endCount;
        private int count;
        private Task task;
        private boolean once;

        private Job(int interval, Task t, boolean once){
            this.endCount = interval;
            this.count = 0;
            this.task = t;
            this.once = once;
        }

        public void update(int cnt) {
            count += cnt;
            if (count >= endCount) {
                count -= endCount;
                Task task = this.task;
                if (once) this.task = null;
                if (task != null) task.doTask(this);
            }
        }

        public void setAnotherTask(int interval, Task task) {
            this.count = 0;
            this.task = task;
            this.endCount = interval;
        }
    }
}

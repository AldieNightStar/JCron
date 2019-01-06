# JCron
Java Cron Micro Library to make your task runnable in one Thread ^^

## Create your job
```java
// Create job which will be runned every 2ms
JCron.Job j1 = JCron.createJob(2, (j) -> System.out.println("FIZZ"));
// ... every 3ms
JCron.Job j2 = JCron.createJob(3, (j) -> System.out.println("BAZZ"));
// ... every 5ms
JCron.Job j3 = JCron.createJob(5, (j) -> System.out.println("FIZZBAZZ"));
```

## Do not forget to update them
### <i>You can update them every second OR whatever you want!</i>
```java
JCron.update(1, j1, j2, j3);
```

## Or if you want, you can make Job, which will be runned AT ONCE
```java
JCron.Job onceJob = JCron.createJobOnce(1000, j -> System.out.println("You will never see me again!"));
```

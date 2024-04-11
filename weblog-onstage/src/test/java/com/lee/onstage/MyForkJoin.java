package com.lee.onstage;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 计算1+2+…+1000000000的结果。
 */
class MyTask extends RecursiveTask<Long> {


    private long start;
    private long end;
    private static final long threshold = 10_0000L;

    public MyTask(long start, long end)
    {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if((end - start)<threshold)
        {
            long sum = 0l;
            for (long i=start;i<=end;i++)
            {
                sum+=i;
            }
            return sum;
        }
        else {
            long middle = (start + end) / 2;
            MyTask left = new MyTask(start, middle);
            MyTask right = new MyTask(middle + 1, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
}

public class MyForkJoin {

    public static void main(String[] args) throws Exception {
        long start = 0L;
        long end = 10_0000_00000L;
        testFork(start,end);
        testFor(start,end);
        testStream(start,end);
    }

    public static void testFork(long start,long end) throws Exception{
        long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask task = new MyTask(start,end);
        long invoke = forkJoinPool.invoke(task);
        long l1 = System.currentTimeMillis();
        System.out.println("forkjoin结果:"+invoke+",耗时:"+(l1-l));
    }


    private static void testFor(long start,long end ){
        long start1 = System.currentTimeMillis();
        long res = 0;
        for (long i = start; i <= end; i++) {
            res+=i;
        }
        System.out.println("testFor运行时间："+(System.currentTimeMillis()-start1)+"ms");
    }

    public static void testStream(Long start,Long end){
        long l = System.currentTimeMillis();

        long reduce = LongStream.rangeClosed(start, end).parallel().reduce(0, (x, y) -> x + y);

        long l1 = System.currentTimeMillis();
        System.out.println("stream流结果:"+reduce+",耗时:"+(l1-l));
    }
}

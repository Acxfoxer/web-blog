package com.lee.onstage;


public class JoinDemo {
    public static void main(String[] args) {
        Thread t1 =new Thread(new MyTask("任务1"));
        Thread t2 =new Thread(new MyTask("任务2"));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("all threads has finish execution");
    }
    static class MyTask implements Runnable{
        private String name;
        public MyTask(){

        }
        public MyTask(String name){
            this.name=name;
        }

        @Override
        public void run() {
            System.out.printf(name+"is starting");
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

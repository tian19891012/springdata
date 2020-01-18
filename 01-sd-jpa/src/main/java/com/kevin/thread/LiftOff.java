package com.kevin.thread;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/1220:22
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + ")，";
    }

    @Override
    public void run() {

        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {

        /**
         * 直接调用Runnable接口的实现方法
         */
        /*LiftOff lauch = new LiftOff();
        lauch.run();*/
        /**
         * 线程的原生方法
         */
        /*Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");*/
        /**
         * 多线程
         */
        for (int i = 0; i < 5; i++) {

            new Thread(new LiftOff()).start();
            System.out.println("Waiting for LiftOff");
        }
    }
}


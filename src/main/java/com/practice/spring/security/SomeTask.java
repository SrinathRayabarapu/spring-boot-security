package com.practice.spring.security;

import static com.practice.spring.security.SpringBootSecurityApplication.BLOCKING_QUEUE;

public class SomeTask implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            BLOCKING_QUEUE.put("Srinath");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

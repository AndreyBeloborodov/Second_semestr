package Informatics.multithreading;

import java.io.IOException;

public class New_message {
    public static void main(String[] args) {
        Thread message = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("NEW MESSAGE");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread closeMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int code = System.in.read();
                        if (code == 10) {
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        message.start();
        closeMessage.start();

    }
}

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public static void main(String[] args) {
        final int NUM_PHILOSOPHERS = 5;
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        ReentrantLock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i, forks);
            new Thread(philosophers[i]).start();
        }
    }

    static class Philosopher implements Runnable {
        private final int id;
        private final ReentrantLock[] forks;

        Philosopher(int id, ReentrantLock[] forks) {
            this.id = id;
            this.forks = forks;
        }

        @Override
        public void run() {
            while (true) {
                think();
                pickForks();
                eat();
                putForks();
            }
        }

        private void think() {
            System.out.println("Philosopher " + id + " is thinking.");
            sleepRandomTime();
        }

        private void eat() {
            System.out.println("Philosopher " + id + " is eating.");
            sleepRandomTime();
        }

        private void pickForks() {
            int leftFork = id;
            int rightFork = (id + 1) % forks.length;

            int firstFork = Math.min(leftFork, rightFork);
            int secondFork = Math.max(leftFork, rightFork);

            forks[firstFork].lock();
            forks[secondFork].lock();
        }

        private void putForks() {
            int leftFork = id;
            int rightFork = (id + 1) % forks.length;

            int firstFork = Math.min(leftFork, rightFork);
            int secondFork = Math.max(leftFork, rightFork);

            forks[secondFork].unlock();
            forks[firstFork].unlock();
        }

        private void sleepRandomTime() {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

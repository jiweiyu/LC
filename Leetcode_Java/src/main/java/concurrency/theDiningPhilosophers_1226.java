package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
output[i] = [a, b, c] (three integers)
- a is the id of a philosopher.
- b specifies the fork: {1 : left, 2 : right}.
- c specifies the operation: {1 : pick, 2 : put, 3 : eat}.
 */
public class theDiningPhilosophers_1226 {

    private final Lock[] forks = new Lock[5];
    private final Semaphore semaphore = new Semaphore(4);

    public theDiningPhilosophers_1226(){
        for(int i = 0; i<5;i++){
            forks[i] = new ReentrantLock();
        }
    }

    void pickFork(int id, Runnable pick){
        forks[id].lock();
        pick.run();
    }

    void putFork(int id, Runnable put){
        put.run();
        forks[id].unlock();
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException{
        int leftFork = philosopher;
        int rightFork = (philosopher+4)% 5;

        semaphore.acquire();

        pickFork(leftFork, pickLeftFork);
        pickFork(rightFork, pickRightFork);
        eat.run();
        putFork(rightFork, putRightFork);
        putFork(leftFork, putLeftFork);

        semaphore.release();
    }
}

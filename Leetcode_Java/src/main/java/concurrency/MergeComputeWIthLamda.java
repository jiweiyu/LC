package concurrency;

import java.io.Closeable;
import java.io.IOError;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeComputeWIthLamda <O extends Output, I extends Input> implements Closeable {

    private ExecutorService executor;

    public MergeComputeWIthLamda(int k){
        executor = Executors.newFixedThreadPool(k);
    }

    public Output mergeAll(List<Input> inputs){
        List<Future<Output>> futures = new LinkedList<>();
        for(Input input : inputs){
            final Input source = input;
            futures.add(executor.submit(() -> compute(source)));
        }
        try{
            while(futures.size() > 1){
                final Output o1 = futures.remove(0).get();
                final Output o2 = futures.remove(0).get();
                futures.add(executor.submit(() -> merge(o1, o2)));
            }
            return futures.get(0).get();
        }catch(InterruptedException | ExecutionException e){

        }
        return null;
    }

    @Override
    public void close() throws IOException {
        this.executor.shutdown();
    }

    //fake code
    private Output compute(Input i){
        return i.output();
    }
    //fake code
    private Output merge(Output o1, Output o2){
        return o1;
    }
}

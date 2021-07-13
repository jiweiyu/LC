package concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

abstract class Input{
    abstract Output output();
}

abstract class Output{
    abstract Output add(Output o);
}

class ComputeTask implements Callable {
    private Input input;
    public ComputeTask(Input input){
        this.input = input;
    }

    @Override
    public Output call(){
        return compute(this.input);
    }

    private static Output compute(Input in){
        return in.output();
    }
}

class MergeTask implements Callable{
    private Output output1;
    private Output output2;

    public MergeTask(Output output1, Output output2){
        this.output1 = output1;
        this.output2 = output2;
    }

    @Override
    public Output call(){
        return merge(this.output1, this.output2);
    }

    private static Output merge(Output o1, Output o2){
        return o1.add(o2);
    }
}

public class MergeKThread<O extends Output, I extends Input>{
    private ExecutorService executor;
    private MergeKThread(){}
    public MergeKThread(int k){
        executor = Executors.newFixedThreadPool(k);
    }

    public Output mergeAll(List<Input> inputs){
        List<Future<Output>> futures = new LinkedList<>();
        for(Input input : inputs){
            futures.add(executor.submit(new ComputeTask(input)));
        }

        try{
            while(futures.size() > 1){
                futures.add(executor.submit(
                        new MergeTask(futures.remove(0).get(), futures.remove(0).get())
                ));
            }
            return futures.get(0).get();
        }catch(InterruptedException | ExecutionException e){

        }
        return null;
    }

}

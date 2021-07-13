package concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class webCrawlerMultithreaded_1242<htmlParser> {

//    private Object htmlParser;
//
//    interface HtmlParser {
//        default List getUrls(String url) {return new LinkedList<String>();}
//    }
//
//    private String hostname(String url){
//        return url.split("/")[2];
//    }
//
//    public List<String> crawl(String startUrl, final HtmlParser htmlParser){
//        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
//        ConcurrentSkipListSet<String> seen = new ConcurrentSkipListSet<>();
//
//        queue.offer(startUrl);
//        seen.add(startUrl);
//
//        final List<String> result = new ArrayList<>();
//        final String host = hostname(startUrl);
//        int nThreads = 4;
//        final CountDownLatch latch = new CountDownLatch(nThreads);
//
//        final Runnable worker = new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    while(true){
//                        final String url = queue.poll();
//                        if(url == null){
//                            break;
//                        }
//                        result.add(url);
//                        for(Object nextUrl: htmlParser.getUrls(url)){
//                            if(seen.add((String) nextUrl) && host.equals(hostname((String) nextUrl))){
//                                queue.offer((String) nextUrl);
//                            }
//                        }
//                    }
//                }finally {
//                    latch.countDown();
//                }
//            }
//        };
//        for(int i = 0; i < nThreads; i++){
//            new Thread(worker).start();
//        }
//        try{
//            latch.await();
//        }catch(Exception e){
//            e.printStackTrace(System.out);
//        }
//        return result;
//    }
//
//
//    /////////////////////
//
//    public List<String> crawl__(String startUrl ,HtmlParser htmlParser){
//        String hostname = getHostName(startUrl);
//
//        Set<String> visited = ConcurrentHashMap.newKeySet();
//        visited.add(startUrl);
//
//        //return crawl(startUrl, htmlParser, hostname, visited).collect(Collections.toList());
//        List<String> fakeres = new ArrayList<>();
//        return fakeres;
//    }
//
//    private Stream<String> crawl(String startUrl, HtmlParser htmlParser, String hostname, Set<String> visited){
//        Stream<String> stream = htmlParser.getUrls(startUrl)
//                .parallelStream()
//                .filter(url -> isSameHostname(url, hostname))
//                .filter(url -> visited.add(url))
//                .flatMap(url -> crawl(url, htmlParser, hostname, visited));
//        return Stream.concat(Stream.of(startUrl), stream);
//    }
//
//    private String getHostName(String url){
//        int idx = url.indexOf('/', 7);
//        return (idx != -1) ? url.substring(0, idx): url;
//    }
//
//    private boolean isSameHostname(String url, String hostname){
//        if(!url.startsWith(hostname)){
//            return false;
//        }
//        return url.length() == hostname.length() || url.charAt(hostname.length()) == '/';
//    }
//
//    ////
//    public List<String> crawl_(String startUrl, HtmlParser htmlParser) {
//        Set<String> visited = ConcurrentHashMap.newKeySet();
//        ExecutorService pool = Executors.newCachedThreadPool(); // Thread Pool (Executor)
//        Deque<Future<List<String>>> tasks = new ArrayDeque<>();
//        visited.add(startUrl);
//
//        Future<List<String>> future = pool.submit(getCallableTask(startUrl, visited, htmlParser));
//        tasks.addLast(future);
//        try {
//            while (!tasks.isEmpty()) {
//                List<String> newlyGottenUrls = tasks.removeFirst().get(); // get() throws InterruptedException
//                for (String newlyGottenUrl : newlyGottenUrls) {
//                    if (!visited.contains(newlyGottenUrl)) {
//                        visited.add(newlyGottenUrl);
//                        future = pool.submit(getCallableTask(newlyGottenUrl, visited, htmlParser));
//                        tasks.add(future);
//                    }
//                }
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            System.out.println(e.getMessage());
//        }
//
//        pool.shutdown(); // do not forget to shutdown the executor
//
//        return new LinkedList<String>(visited);
//    }
//
//    private Callable<List<String>> getCallableTask(String url, Set<String> visited, HtmlParser htmlParser) {
//        return  new Callable<List<String>>() {
//            public List<String> call() {
//                List<String> list = new ArrayList<>();
//                for (String newUrl : htmlParser.getUrls(url)) {
//                    if (!visited.contains(newUrl)) {
//                        System.out.print(newUrl + "  ");
//                        list.add(newUrl);
//                    }
//                }
//                return list;
//            }
//        };
//
//    }
}

package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

import lombok.Data;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Classname ParallelPrimeGenerator
 * @Description 基于Master-Slave模式可复用代码的质数生成器
 * @Date 2019/6/11 16:40
 * @Created by Gangan
 */
public class ParallelPrimeGenerator {

    @Test
    public  void test() throws Exception {
        PrimeGeneratorService primeGeneratorService = new PrimeGeneratorService();
        Set<BigInteger> result = primeGeneratorService.generatePrime(100);
        System.out.println(result);
    }

    @Data
    class Range {
        public final int lowerBound;
        public final int upperBound;

        public Range(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    class PrimeGeneratorService extends AbstractMaster<Range, Set<BigInteger>, Set<BigInteger>> {

        public PrimeGeneratorService() {
            //初始化仆从线程
            this.init();
        }

        /**
         * 调用关键服务
         * @param upperBound
         * @return
         * @throws Exception
         */
        public Set<BigInteger> generatePrime(int upperBound) throws Exception {
            return this.service(upperBound);
        }

        @Override
        protected Set<BigInteger> combineResults(Iterator<Future<Set<BigInteger>>> futureIterator) {

            TreeSet<BigInteger> result = new TreeSet<>();

            while (futureIterator.hasNext()) {
                try {
                    result.addAll(futureIterator.next().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (SubTaskFailureException.class.isInstance(cause)) {
                        RetryInfo retryInfo = ((SubTaskFailureException) cause).retryInfo;
                        Object subTask = retryInfo.subTask;
                        System.out.println(subTask);
                    }
                    e.printStackTrace();
                }
            }

            return result;
        }

        /**
         * 构建任务分割策略
         * @param params
         * @return
         */
        @Override
        protected TaskDivideStrategy<Range> newTaskDivideStrategy(Object[] params) {
            final int numOfSlavers = slaveSet.size();
            final int originalTaskScale = (Integer) params[0];
            final int subTaskScale = originalTaskScale / numOfSlavers;
            final int subTaskCount = (0 == (originalTaskScale % numOfSlavers)) ? numOfSlavers : numOfSlavers + 1;

            TaskDivideStrategy<Range> divideStrategy = new TaskDivideStrategy<Range>() {

                private int i=1;

                @Override
                public Range nextChunk() {
                    int upperBound;
                    if (i < subTaskCount) {
                        upperBound=i*subTaskScale;
                    } else if (i == subTaskCount) {
                        upperBound = originalTaskScale;
                    } else {
                        return null;
                    }

                    int lowerBound=(i-1)*subTaskScale+1;
                    i++;
                    return new Range(lowerBound,upperBound);
                }
            };

            return divideStrategy;
        }

        @Override
        protected SubTaskDispathStrategy<Range, Set<BigInteger>> newSubTaskDispathStrategy() {
            return new RoundRobinSubTaskDispatchStrategy<>();
        }

        @Override
        protected Set<? extends SlaveSpec<Range, Set<BigInteger>>> createSlavers() {
            HashSet<PrimeGenerator> slaves = new HashSet<>();
            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                slaves.add(new PrimeGenerator(new ArrayBlockingQueue<>(2)));
            }

            return slaves;
        }
    }


    private static class PrimeGenerator extends WorkerThreadSlave<Range,Set<BigInteger>>  {
        public PrimeGenerator(BlockingQueue<Runnable> taskQueue) {
            super(taskQueue);
        }

        @Override
        protected Set<BigInteger> doProcess(Range task) throws Exception {
            TreeSet<BigInteger> treeSet = new TreeSet<>();
            BigInteger start = BigInteger.valueOf(task.lowerBound);
            BigInteger end = BigInteger.valueOf(task.upperBound);

            while (-1 == (start = start.nextProbablePrime()).compareTo(end)) {
                treeSet.add(start);
            }
            return treeSet;
        }
    }
}

# Java Multithreading Practice

This repository contains 50 multithreading problems in Java, ranging from basic to advanced.

## Basic Questions
1. Create a thread by extending the Thread class
2. Create a thread by implementing the Runnable interface
3. Print numbers from 1 to 10 using two threads
4. Set name and priority of a thread and print it
5. Check if a thread is alive using isAlive() method
6. Use sleep() method to pause thread execution
7. Use join() method to wait for thread completion
8. Use yield() to voluntarily give up CPU
9. Create a daemon thread and observe its behavior
10. Use Thread.currentThread() to get current thread info

## Intermediate Questions
11. Synchronize method to prevent race condition
12. Synchronize block with a shared resource
13. Use static synchronization
14. Demonstrate deadlock between two threads
15. Use wait() and notify() to coordinate between threads
16. Producer-Consumer problem using wait/notify
17. Implement thread-safe counter using synchronized
18. Create thread-safe singleton using synchronization
19. Use ReentrantLock instead of synchronized block
20. Use tryLock with timeout

## Advanced Questions
21. Use ExecutorService to manage thread pool
22. Submit tasks using Callable and get result using Future
23. Handle timeout in Future.get()
24. Use invokeAll() and invokeAny() with ExecutorService
25. Implement custom ThreadFactory
26. Schedule tasks using ScheduledExecutorService
27. Use Semaphore to limit concurrent access
28. Use CountDownLatch to wait for threads to finish
29. Use CyclicBarrier for barrier synchronization
30. Use Exchanger to swap data between threads
31. Use ThreadLocal for thread-confined variables
32. Create a custom lock using AbstractQueuedSynchronizer
33. Implement a ReadWriteLock
34. Use Phaser for dynamic thread synchronization
35. Implement ForkJoin framework for parallelism
36. Use CompletableFuture for async computation
37. Handle exceptions in CompletableFuture
38. Chain async tasks using thenApply and thenCompose
39. Combine multiple CompletableFutures
40. Use virtual threads (Project Loom) if available


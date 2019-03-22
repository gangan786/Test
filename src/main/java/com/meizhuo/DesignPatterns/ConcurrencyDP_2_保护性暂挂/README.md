#  Guarded Suspension（保护性暂挂）模式

如果某个线程执行特定的操作前需要满足一定的条件，则在该条件未满足时将该线程暂停执行（即暂挂，处于Waiting）



这里的实现架构我是叹为观止啊，只知道具体的运行方式，对于其抽象思想还不是很懂，留待以后学习总结



+ 其中有一个知识点是：嵌套监视器锁死

  其实就是某个线程调用了Condition.await()方法后，该线程就会进入waiting状态，只会释放相关联的锁（锁指 java.util.concurrent.locks），但是对于通过 synchronized 获得锁是不会自动释放的，那么此时对于要获得锁的另一个方法要执行notify就会因为无法获得锁而阻塞，这样就形成了锁死。

  此时的线程为：

  ~~~
  Before calling guaredMethod
  2019-03-22 22:03:38
  Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.112-b15 mixed mode):
  
  "DestroyJavaVM" #13 prio=5 os_prio=0 tid=0x0000000003663800 nid=0xe4 waiting on condition [0x0000000000000000]
     java.lang.Thread.State: RUNNABLE
  
  "Timer-0" #12 prio=5 os_prio=0 tid=0x00000000197fa800 nid=0x3c98 waiting for monitor entry [0x000000001a3ee000]
     java.lang.Thread.State: BLOCKED (on object monitor)
  	at com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example.NestedMonitorLockoutExample$Helper.xStateChanged(NestedMonitorLockoutExample.java:89)
  	- waiting to lock <0x00000000d624cc68> (a com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example.NestedMonitorLockoutExample$Helper)
  	at com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example.NestedMonitorLockoutExample$2.run(NestedMonitorLockoutExample.java:49)
  	at java.util.TimerThread.mainLoop(Timer.java:555)
  	at java.util.TimerThread.run(Timer.java:505)
  
  "Thread-0" #11 prio=5 os_prio=0 tid=0x00000000197f9800 nid=0x117c waiting on condition [0x000000001a2ee000]
     java.lang.Thread.State: WAITING (parking)
  	at sun.misc.Unsafe.park(Native Method)
  	- parking to wait for  <0x00000000d625e710> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
  	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
  	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
  	at com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.ConditionVarBlocker.callWithGuard(ConditionVarBlocker.java:48)
  	at com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example.NestedMonitorLockoutExample$Helper.xGuarededMethod(NestedMonitorLockoutExample.java:78)
  	- locked <0x00000000d624cc68> (a com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example.NestedMonitorLockoutExample$Helper)
  	at com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example.NestedMonitorLockoutExample$Helper.access$100(NestedMonitorLockoutExample.java:56)
  	at com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example.NestedMonitorLockoutExample$1.run(NestedMonitorLockoutExample.java:38)
  	at java.lang.Thread.run(Thread.java:745)
  
  
  
  ~~~

  
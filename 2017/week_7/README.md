# Exercise 7: CPU-bound Concurrency

CSCM602023 - Advanced Programming (Pemrograman Lanjut) @ Faculty of
Computer Science Universitas Indonesia, Even Semester 2016/2017

* * *

This tutorial will exercise about Python's high-level concurrency
modules: `multiprocessing.Queue` and `concurrent.futures`. Specifically,
this tutorial will exercise about multiprocessing capability in Python
and handle concurrent tasks execution using said modules.

Concurrency is when two or more tasks overlap in execution. To handle
coordination between tasks, Python programmers can use middle-level
concurrency support provided by Python such as `Lock` or `Semaphore`,
or use high-level concurrency support such as `multiprocessing.Queue`
(in short: `Queue`) or `concurrent.futures` (in short: `Futures`)
modules.

The basic difference between `Queue` and `Futures` is the way they
organize processes. In `Queue`, we define processes that will do the
job and use `Queue` to coordinate usage of shared data, while in
`Futures` we submit the job to `ProcessPool` and let it do the rest.

For lab exercise monitoring purpose, you are asked to frequently
add & commit your code, e.g. everytime you completed a task item,
everytime you added a class or function.

* * *

## Mandatory Checklist

- [ ] Run the code from `queue_m1.py` and explain what it is
    - [ ] Write your explanation in a text file, save as `queue_m1.txt`
- [ ] Modify `queue_m1.py` so it will have 2 reader processes
    - [ ] Save the code as `queue_m2.py`
    - [ ] Run the code several times and explain what happens
    - [ ] Write your explanation in a text file, save as `queue_m2.txt`
- [ ] Run the code from `futures_m1.py` and explain what it is
    - [ ] Write your explanation in a text file, save as `futures_m1.txt`
- [ ] Modify `queue_m2.py` by using Futures

## Additional Checklist

- [ ] Modify `queue_m2.py` so that the reader will always guaranteed to
read at least 10 numbers in a row before other reader can read
    - Hint : You can use singleton pattern and implement simple data
    lock (acquire/releasing lock)
    - [ ] Save the code as `queue_a1.py`
- [ ] Create parallel factorization process like the one in `futures_m1.py`
by using `Queue`
    - Hint : You can reuse naive factorization method in `futures_m1.py`
    and put each number in jobs queue like the one in `imagescale-q-m.py`
    (see [Additional Resources](#additional-resources))
    - [ ] Save the code as `queue_a2.py`

## Additional Resources

- [Python - paralellizing CPU-bound tasks with concurrent.futures](http://eli.thegreenplace.net/2013/01/16/python-paralellizing-cpu-bound-tasks-with-concurrent-futures) by Eli Bendersky
- Source code from [Python in Practice](http://www.qtrac.eu/pipbook.html) for examples

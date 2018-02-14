from collections import namedtuple
import multiprocessing as mp
import random
import time

VALUES = (100, 200, 500, 1000)
Coin = namedtuple('Coin', ['value'])


def reader(queue):
    termination_threshold = 25
    termination_count = 0
    reader_sum = 0

    while termination_count < termination_threshold:
        if queue.empty():
            print("[Process {}] Waiting for new items...".format(
                  mp.current_process().name))
            time.sleep(random.random() * 0.50)
            termination_count += 1
        else:
            termination_count = 0
            coin = queue.get()
            reader_sum += coin.value
            time.sleep(random.random() * 0.50)
            print("[Process {}] Read coin ({})".format(
                  mp.current_process().name, str(coin.value)))

    print("[Process {}] Total value read: {}".format(
          mp.current_process().name, reader_sum))
    print("[Process {}] Exiting...".format(mp.current_process().name))


def writer(count, queue):
    writer_sum = 0

    for ii in range(count):
        coin = Coin(random.choice(VALUES))
        queue.put(coin)
        writer_sum += coin.value

        # No need to prepend string with process name since this
        # function is executed in main interpreter thread
        print("Put coin ({}) into queue".format(coin.value))
        time.sleep(random.random() * 0.50)

    print('Total value written: ' + str(writer_sum))


if __name__ == '__main__':
    start_time = time.time()
    count = 100
    queue = mp.Queue()  # Queue class from multiprocessing module

    reader_p1 = mp.Process(target=reader, name='Reader 1', args=(queue,))
    reader_p1.daemon = True
    reader_p1.start()

    writer(count, queue)
    reader_p1.join()
    end_time = time.time()

    print('Total running time: ' + str(end_time - start_time))

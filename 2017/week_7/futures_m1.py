"""Credit to Eli Bendersky"""

from concurrent.futures import ProcessPoolExecutor, as_completed
import math


def factorize_naive(n):
    """ A naive factorization method. Take integer 'n', return list of
        factors.
    """
    if n < 2:
        return []
    factors = []
    p = 2

    while True:
        if n == 1:
            return factors

        r = n % p
        if r == 0:
            factors.append(p)
            n = n // p
        elif p * p >= n:
            factors.append(n)
            return factors
        elif p > 2:
            # Advance in steps of 2 over odd numbers
            p += 2
        else:
            # If p == 2, get to 3
            p += 1
    assert False, "unreachable"


def chunked_worker(nums):
    """ Factorize a list of numbers, returning a num:factors mapping.
    """
    return {n: factorize_naive(n) for n in nums}


def pool_factorizer_chunked(nums, nprocs):
    # Manually divide the task to chunks of equal length, submitting each
    # chunk to the pool.
    chunksize = int(math.ceil(len(nums) / float(nprocs)))
    futures = []

    with ProcessPoolExecutor() as executor:
        for i in range(nprocs):
            chunk = nums[(chunksize * i): (chunksize * (i + 1))]
            futures.append(executor.submit(chunked_worker, chunk))

    resultdict = {}
    for f in as_completed(futures):
        resultdict.update(f.result())
    return resultdict


if __name__ == '__main__':
    nums = [25, 36, 42, 88, 99]
    print(pool_factorizer_chunked(nums, 2))

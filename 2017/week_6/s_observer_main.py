#!/usr/bin/env python3
from simple_observer import Publisher, Subscriber


def main():
    pub = Publisher()

    bob = Subscriber('Bob')
    alice = Subscriber('Alice')
    john = Subscriber('John')

    pub.register(bob)
    pub.register(alice)
    pub.register(john)

    pub.notify("It's Lunchtime!")
    pub.unregister(john)
    pub.notify("Time for dinner")


if __name__ == '__main__':
    main()

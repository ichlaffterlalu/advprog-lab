#!/usr/bin/env python3
from additional_observer import Publisher, SubscriberOne, SubscriberTwo


def main():
    pub = Publisher()
    bob = SubscriberOne('Bob')
    alice = SubscriberTwo('Alice')
    john = SubscriberOne('John')

    pub.register(bob, bob.update)
    pub.register(alice, alice.receive)
    pub.register(john)

    pub.notify("It's lunchtime!")
    pub.unregister(john)
    pub.notify("Time for dinner")


if __name__ == '__main__':
    main()

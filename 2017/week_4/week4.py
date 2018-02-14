#!/usr/bin/env python3
# Copyright 2012-13 Qtrac Ltd. All rights reserved.
# This program or module is free software: you can redistribute it
# and/or modify it under the terms of the GNU General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version. It is provided for
# educational purposes and is distributed in the hope that it will be
# useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
# General Public License for more details.

# This program has been modified from its original source
# (stationery1, stationery2.py) to fit in Advanced Programming 2017
# week 4 exercise.

import abc
import sys


def logged(function):
    # TODO Implement me!
    pass


def main():
    pencil = make_item("Pencil", 0.40)
    ruler = make_item("Ruler", 1.60)
    eraser = make_item("Eraser", 0.20)
    pencilSet = make_composite("Pencil Set", pencil, ruler, eraser)
    box = make_item("Box", 1.00)
    boxedPencilSet = make_composite("Boxed Pencil Set", box,
                                    pencilSet)
    boxedPencilSet.add(pencil)
    for item in (pencil, ruler, eraser, pencilSet, boxedPencilSet):
        item.print()


class AbstractItem(metaclass=abc.ABCMeta):

    @abc.abstractproperty
    def composite(self):
        pass


class SimpleItem(AbstractItem):

    def __init__(self, name, price=0.00):
        self.name = name
        self.price = price

    @property
    def composite(self):
        # TODO Implement me!
        pass

    def print(self, indent="", file=sys.stdout):
        print("{}${:.2f} {}".format(indent, self.price, self.name),
              file=file)


class AbstractCompositeItem(AbstractItem):

    def __init__(self, *items):
        self.children = []
        if items:
            self.add(*items)

    def add(self, first, *items):
        # TODO Implement me!
        pass

    def remove(self, item):
        # TODO Implement me!
        pass

    def __iter__(self):
        return iter(self.children)


class CompositeItem(AbstractCompositeItem):

    def __init__(self, name, *items):
        super().__init__(*items)
        self.name = name

    @property
    def composite(self):
        # TODO Implement me!
        pass

    @property
    def price(self):
        # TODO Implement me!
        pass

    def print(self, indent="", file=sys.stdout):
        print("{}${:.2f} {}".format(indent, self.price, self.name),
              file=file)
        for child in self:
            # Passed the file parameter to child.print() calls
            # in order to make print() more properly testable
            child.print(indent + "      ", file)


def make_item(name, price):
    # TODO Apply `logged` decorator to this function
    return SimpleItem(name, price=price)


def make_composite(name, *items):
    # TODO Apply `logged` decorator to this function
    return CompositeItem(name, *items)


if __name__ == "__main__":
    main()

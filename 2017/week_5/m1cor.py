class ProcessHandler(object):

    def __init__(self, successor=None, name=None):
        self._name = name
        self._successor = successor

    def has_successor(self):
        return self._successor is not None

    def process(self):
        pass

    def give_process(self, data):
        self._successor.process(data)


class ProcessLevel1(ProcessHandler):

    def __init__(self, s, n):
        super(ProcessLevel1, self).__init__(s, n)

    def process(self, data):
        # TODO Implement me!
        pass


class ProcessLevel2(ProcessHandler):

    def __init__(self, s, n):
        # TODO Implement me!
        pass

    def process(self, data):
        # TODO Implement me!
        pass


class ProcessLevel3(ProcessHandler):

    def __init__(self, s, n):
        # TODO Implement me!
        pass

    def process(self, data):
        # TODO Implement me!
        pass


def main():
    p3 = ProcessLevel3(s=None, n='Process Level 3')
    p2 = ProcessLevel2(s=p3, n='Process Level 2')
    p1 = ProcessLevel1(s=p2, n='Process Level 1')
    p1.process(70)  #


if __name__ == "__main__":
    main()

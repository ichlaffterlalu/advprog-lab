class Subscriber:

    def __init__(self, name):
            self.name = name

    def update(self, message):
            print('{} got message "{}"'.format(self.name, message))


class Publisher:

    def __init__(self):
        self.subscribers = set()

    def register(self, who):
        # TODO Complete Me
        pass

    def unregister(self, who):
        # TODO Complete Me
        pass

    def notify(self, message):
        # TODO Complete Me
        pass

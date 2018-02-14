from __future__ import print_function


class Subject(object):

    def __init__(self):
        self._observers = []

    def register(self, observer):
        # TODO Complete Me
        pass

    def unregister(self, observer):
        # TODO Complete Me
        pass

    def notify(self, modifier=None):
        # TODO Complete Me
        pass


class Data(Subject):

    def __init__(self, name=''):
        Subject.__init__(self)
        self.name = name
        self._data = 0

    @property
    def data(self):
        return self._data

    @data.setter
    def data(self, value):
        self._data = value
        self.notify()


class HexViewer:

    def update(self, subject):
        print(u'HexViewer: Subject %s has data 0x%x' % (subject.name,
                                                        subject.data))


class DecimalViewer:

    def update(self, subject):
        print(u'DecimalViewer: Subject %s has data %d' % (subject.name,
                                                          subject.data))


def main():
    data1 = Data('Data 1')
    data2 = Data('Data 2')
    view1 = DecimalViewer()
    view2 = HexViewer()
    data1.register(view1)
    data1.register(view2)
    data2.register(view2)
    data2.register(view1)

    print(u"Setting Data 1 = 10")
    data1.data = 10
    print(u"Setting Data 2 = 15")
    data2.data = 15
    print(u"Setting Data 1 = 3")
    data1.data = 3
    print(u"Setting Data 2 = 5")
    data2.data = 5
    print(u"Detach HexViewer from Data 1 and Data 2.")
    data1.unregister(view2)
    data2.unregister(view2)
    print(u"Setting Data 1 = 10")
    data1.data = 10
    print(u"Setting Data 2 = 15")
    data2.data = 15


if __name__ == '__main__':
    main()

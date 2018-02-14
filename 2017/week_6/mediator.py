import random
import time


class TestController:

    def __init__(self):
        self._testmanager = None
        self._bProblem = 0

    def setup(self):
        print("Setting up the Test")
        time.sleep(0.1)
        self._testmanager.prepareReporting()

    def execute(self):
        # TODO COMPLETE ME
        pass

    def tearDown(self):
        # TODO COMPLETE ME
        pass

    def setTM(self, testmanager):
        # TODO COMPLETE ME
        pass

    def setProblem(self, value):
        # TODO COMPLETE ME
        pass


class Reporter:

    def __init__(self):
        self._testmanager = None

    def prepare(self):
        print("Reporter Class is preparing to report the results")
        time.sleep(0.1)

    def report(self):
        print("Reporting the results of Test")
        time.sleep(0.1)

    def setTM(self, testmanager):
        self._testmanager = testmanager


class Database:

    def __init__(self):
        self._testmanager = None

    def insert(self):
        print("Inserting the execution begin status in the Database ")
        time.sleep(0.1)
        if random.randrange(1, 4) == 3:
            return -1

    def update(self):
        print("Updating the test results in Database")
        time.sleep(0.1)

    def setTM(self, testmanager):
        self._testmanager = testmanager


class TestManager:

    def __init__(self):
        # TODO Complete Me
        pass

    def prepareReporting(self):
        # TODO Complete Me
        pass

    def setReporter(self, reporter):
        # TODO Complete Me
        pass

    def setDB(self, database):
        # TODO Complete Me
        pass

    def publishReport(self):
        # TODO Complete Me
        pass

    def setTC(self, testcontroller):
        # TODO Complete Me
        pass


if __name__ == '__main__':
    reporter = Reporter()
    database = Database()
    testmanager = TestManager()
    testmanager.setReporter(reporter)
    testmanager.setDB(database)
    reporter.setTM(testmanager)
    database.setTM(testmanager)

    for i in range(3):
        testcontroller = TestController()
        testcontroller.setTM(testmanager)
        testmanager.setTC(testcontroller)
        testcontroller.setup()
        testcontroller.execute()
        testcontroller.tearDown()

import unittest
import sys
from io import StringIO
from m1cor import ProcessLevel1, ProcessLevel2, ProcessLevel3


class MandatoryCOR(unittest.TestCase):

    data1 = 30
    EXP_MSG = 'Using Process Level 2\nProcessing data '+str(data1)+'\n'
    data2 = 10
    EXP_MSG2 = 'Using Process Level 1\nProcessing data '+str(data2)+'\n'
    data3 = 0
    EXP_MSG3 = 'Using Process Level 1\nProcessing data ' + str(data3) + '\n'
    data4 = 60
    EXP_MSG4 = "This data can't be processed" + '\n'
    data5 = 100
    EXP_MSG5 = "This data can't be processed\n"

    def test_case_1(self):
        p3 = ProcessLevel3(s=None, n='Process Level 3')
        p2 = ProcessLevel2(s=p3, n='Process Level 2')
        p1 = ProcessLevel1(s=p2, n='Process Level 1')

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        p1.process(self.data1)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), self.EXP_MSG)

    def test_case_2(self):
        p3 = ProcessLevel3(s=None, n='Process Level 3')
        p2 = ProcessLevel2(s=p3, n='Process Level 2')
        p1 = ProcessLevel1(s=p2, n='Process Level 1')

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        p1.process(self.data2)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), self.EXP_MSG2)

    def test_case_3(self):
        p3 = ProcessLevel3(s=None, n='Process Level 3')
        p2 = ProcessLevel2(s=p3, n='Process Level 2')
        p1 = ProcessLevel1(s=p2, n='Process Level 1')

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        p1.process(self.data3)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), self.EXP_MSG3)

    def test_case_4(self):
        p3 = ProcessLevel3(s=None, n='Process Level 3')
        p2 = ProcessLevel2(s=p3, n='Process Level 2')
        p1 = ProcessLevel1(s=p2, n='Process Level 1')

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        p1.process(self.data4)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), self.EXP_MSG4)

    def test_case_5(self):
        p3 = ProcessLevel3(s=None, n='Process Level 3')
        p2 = ProcessLevel2(s=p3, n='Process Level 2')
        p1 = ProcessLevel1(s=p2, n='Process Level 1')

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        p1.process(self.data5)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), self.EXP_MSG5)

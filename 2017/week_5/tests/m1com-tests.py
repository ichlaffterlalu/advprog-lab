import unittest
import sys
from io import StringIO
from m1com import LIGHT_IS_OFF, LIGHT_IS_ON, TEL_OFF, TEL_ON,\
                  INV_COMM_REMOTE, INV_COMM_SWITCH, ON_CODE,\
                  OFF_CODE, CHANGE_CODE, TelevisionRemoteClient,\
                  LightSwitchClient, CHG_CHANN


class MandatoryCOM(unittest.TestCase):

    channel1 = "SCTV"

    def test_case_1(self):
        sw = LightSwitchClient()

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        sw.press(ON_CODE)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), LIGHT_IS_ON+'\n')

    def test_case_2(self):
        sw = LightSwitchClient()

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        sw.press(OFF_CODE)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), LIGHT_IS_OFF + '\n')

    def test_case_3(self):
        sw = LightSwitchClient()

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        sw.press('*****')
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), INV_COMM_SWITCH + '\n')

    def test_case_4(self):
        tel = TelevisionRemoteClient()

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        tel.press(ON_CODE)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), TEL_ON + '\n')

    def test_case_5(self):
        tel = TelevisionRemoteClient()

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        tel.press(OFF_CODE)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), TEL_OFF + '\n')

    def test_case_6(self):
        tel = TelevisionRemoteClient()

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        tel.press(CHANGE_CODE, self.channel1)
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         CHG_CHANN.format(self.channel1) + '\n')

    def test_case_7(self):
        tel = TelevisionRemoteClient()

        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        tel.press('****')
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), INV_COMM_REMOTE + '\n')

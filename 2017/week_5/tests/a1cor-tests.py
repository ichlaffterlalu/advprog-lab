import unittest
import sys
from io import StringIO
from a1cor import Application, Dialog, Button, APPLICATION_TOPIC,\
                  PRINT_TOPIC, NO_HELP_TOPIC, BUTTON_PRINT


class AdditionalCOR(unittest.TestCase):

    def test_case_1(self):
        application = Application(APPLICATION_TOPIC)
        dialog = Dialog(application, PRINT_TOPIC)
        button = Button(dialog, NO_HELP_TOPIC)

        # Invoking help in the chain

        capturedOutput = StringIO()
        sys.stdout = capturedOutput
        button.handle_help()
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), 'Dialog Help\n')

    def test_case_2(self):
        application = Application(APPLICATION_TOPIC)
        dialog = Dialog(application, PRINT_TOPIC)
        button = Button(dialog, BUTTON_PRINT)

        # Invoking help in the chain

        capturedOutput = StringIO()
        sys.stdout = capturedOutput
        button.handle_help()
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), 'Button Help\n')

    def test_case_3(self):
        application = Application(APPLICATION_TOPIC)
        dialog = Dialog(application, NO_HELP_TOPIC)
        button = Button(dialog, NO_HELP_TOPIC)

        # Invoking help in the chain

        capturedOutput = StringIO()
        sys.stdout = capturedOutput
        button.handle_help()
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(), 'Application Help\n')

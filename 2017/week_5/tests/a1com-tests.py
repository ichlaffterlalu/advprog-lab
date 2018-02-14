import unittest
import sys
from io import StringIO
from a1com import GundamCockpitClient, MegazordCockpitClient, GUNDAM_IS_ON,\
                  GUNDAM_IS_OFF, GUNDAM_MOVE, GUNDAM_SHOOT, MEGA_ON,\
                  MEGA_OFF, MEGA_MOVE, MEGA_MORPH, INV_COMM_GUNDAM,\
                  INV_COMM_MEGA


class AdditionalCOM(unittest.TestCase):

    gundam = GundamCockpitClient()
    megazord = MegazordCockpitClient()
    weapon_gundam = "Blaster Cannon"
    morph_blueprint = "Thunder Megazord"
    destination = "Enemy Base"

    def test_case_additional_1(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.gundam.do("ON")  # The light is on
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         GUNDAM_IS_ON + '\n')

    def test_case_additional_2(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.gundam.do("OFF")  # The light is on
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         GUNDAM_IS_OFF + '\n')

    def test_case_additional_3(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.gundam.do("SHOOT", self.weapon_gundam)  # The light is on
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         GUNDAM_SHOOT.format(self.weapon_gundam) + '\n')

    def test_case_additional_4(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.gundam.do("MOVE", self.destination)  # Accelerate to
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         GUNDAM_MOVE.format(self.destination) + '\n')

    def test_case_additional_5(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.gundam.do("MORPH", "Thunder Megazord")  # Accelerate to
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         INV_COMM_GUNDAM + '\n')

    def test_case_additional_6(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.megazord.do("ON")  # The light is on
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         MEGA_ON + '\n')

    def test_case_additional_7(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.megazord.do("OFF")  # The light is on
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         MEGA_OFF + '\n')

    def test_case_additional_8(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.megazord.do("SHOOT", self.weapon_gundam)  # The light is on
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         INV_COMM_MEGA + '\n')

    def test_case_additional_9(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.megazord.do("MOVE", self.destination)  # Accelerate to
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         MEGA_MOVE.format(self.destination) + '\n')

    def test_case_additional_10(self):
        capturedOutput = StringIO()  # Create StringIO object
        sys.stdout = capturedOutput
        self.megazord.do("MORPH", self.morph_blueprint)  # Accelerate to
        sys.stdout = sys.__stdout__
        self.assertEqual(capturedOutput.getvalue(),
                         MEGA_MORPH.format(self.morph_blueprint) + '\n')

INV_COMM_GUNDAM = "Argument 'ON' or 'OFF' or 'SHOOT' or 'MOVE' is required."
INV_COMM_MEGA = "Argument 'ON' or 'OFF' or 'MORPH' or 'MOVE' is required."
GUNDAM_IS_ON = "Launching"
GUNDAM_IS_OFF = "Backing off"
MEGA_ON = "Power Up"
MEGA_OFF = "Power Down"
GUNDAM_SHOOT = 'Shooting with {}'
MEGA_MORPH = "Morphing into {}"
MEGA_MOVE = "Moving to {}"
CHANGE_CODE = "CHANGE"
GUNDAM_MOVE = "Accelerating booster to {}"
ON_CODE = "ON"
OFF_CODE = "OFF"
MOVE_CODE = "MOVE"
SHOOT_CODE = "SHOOT"
MORPH_CODE = "MORPH"


class RobotRemote(object):
    # TODO Implement me!
    pass


class Command(object):
    """The COMMAND interface"""

    def __init__(self, obj):
        self._obj = obj

    def execute(self):
        raise NotImplementedError


class TurnOnCommand(Command):
    """The COMMAND for turning on the light"""

    def execute(self):
        self._obj.turn_on()


class TurnOffCommand(Command):
    """The COMMAND for turning off the light"""

    def execute(self):
        # TODO Implement me!
        pass


class ShootCommand(Command):

    def execute(self):
        # TODO Implement me!
        pass


class MoveCommand(Command):

    def execute(self):
        # TODO Implement me!
        pass


class MorphCommand(Command):

    def execute(self):
        # TODO Implement me!
        pass


class Gundam(object):

    def turn_on(self):
        print(GUNDAM_IS_ON)

    def turn_off(self):
        print(GUNDAM_IS_OFF)

    def shoot(self, weapon):
        print(GUNDAM_SHOOT.format(weapon))

    def move(self, direction):
        print(GUNDAM_MOVE.format(direction))


class Megazord(object):

    def turn_on(self):
        print(MEGA_ON)

    def turn_off(self):
        print(MEGA_OFF)

    def morph(self, form):
        print(MEGA_MORPH.format(form))

    def move(self, direction):
        print(MEGA_MOVE.format(direction))


class GundamCockpitClient(object):
    # TODO Implement me!
    pass


class MegazordCockpitClient(object):

    def __init__(self):
        # TODO Implement me!
        pass

    @property
    def cockpit(self):
        return self._mega_pit

    def do(self, cmd, p=None):
        cmd = cmd.strip().upper()
        # TODO IMPLEMENT
        pass

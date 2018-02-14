INV_COMM_SWITCH = "Argument 'ON' or 'OFF' is required."
INV_COMM_REMOTE = "Argument 'ON' or 'OFF' or 'CHANGE' is required."
LIGHT_IS_ON = "The light is on"
LIGHT_IS_OFF = "The light is off"
TEL_ON = "The television is on"
TEL_OFF = "The television is off"
CHG_CHANN = 'Changing channel into {}'
ON_CODE = "ON"
OFF_CODE = "OFF"
CHANGE_CODE = "CHANGE"


class Switch(object):
    """The INVOKER class"""

    def __init__(self):
        self._history = ()

    @property
    def history(self):
        return self._history

    def execute(self, command):
        self._history = self._history + (command, )
        command.execute()


class TelevisionRemote(object):

    def __init__(self):
        self._history = ()

    @property
    def history(self):
        return self._history

    def execute(self, command, chn_nm=None):
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
        self._obj.turn_off()


class ChangeChannelCommand(Command):
    """The COMMAND for changing channel"""

    def execute(self):
        self._obj.change_channel(self._chn)


class Light(object):
    """The RECEIVER class"""

    def turn_on(self):
        print(LIGHT_IS_ON)

    def turn_off(self):
        print(LIGHT_IS_OFF)


class LightSwitchClient(object):
    """The CLIENT class"""

    def __init__(self):
        self._lamp = Light()
        self._switch = Switch()

    @property
    def switch(self):
        return self._switch

    def press(self, cmd):
        cmd = cmd.strip().upper()
        # TODO Implement me!
        pass


class Television(object):

    def turn_on(self):
        print(TEL_ON)

    def turn_off(self):
        print(TEL_OFF)

    def change_channel(self, channel_name):
        print(CHG_CHANN.format(channel_name))


class TelevisionRemoteClient(object):
    # TODO Implement me!
    pass


if __name__ == "__main__":
    light_switch = LightSwitchClient()
    print("Switch ON test.")
    light_switch.press("ON")
    print("Switch OFF test.")
    light_switch.press("OFF")
    print("Invalid Command test.")
    light_switch.press("****")
    print("Command history:")
    print(light_switch.switch.history)

    television_remote = TelevisionRemoteClient()
    print("Turn Off television.")
    television_remote.press("ON")  # The television is on
    print("Turn Off television.")
    television_remote.press("OFF")  # The television is off
    print("Changing Channel.")
    television_remote.press("CHANGE", "ANTV")  # Changing channel into ANTV
    print("Invalid Command test.")
    # Argument 'ON' or 'OFF' or 'CHANGE' is required
    television_remote.press("****")

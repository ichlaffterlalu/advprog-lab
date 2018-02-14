PRINT_TOPIC = 1
APPLICATION_TOPIC = 3
NO_HELP_TOPIC = -1
BUTTON_PRINT = 4


class HelpHandler(object):

    def __init__(self, successor=0, topic=NO_HELP_TOPIC):
        self._successor = successor
        self._topic = topic

    def has_help(self):
        return self._topic != NO_HELP_TOPIC

    def handle_help(self):
        if self._successor != 0:
            self._successor.handle_help()

    def set_handler(self, h, t):
        self._successor = h
        self._h = t


class Widget(HelpHandler):
    # TODO Implement me!
    pass


class Application(HelpHandler):
    # TODO Implement me!
    pass


class Dialog(Widget):
    # TODO Implement me!
    pass


class Button(Widget):
    # TODO Implement me!
    pass


def main():
    application = Application(APPLICATION_TOPIC)
    dialog = Dialog(application, PRINT_TOPIC)
    button = Button(dialog, NO_HELP_TOPIC)

    # Invoking help in the chain
    button.handle_help()


if __name__ == "__main__":
    main()

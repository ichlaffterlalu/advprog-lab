def main():
    ubuntu = Ubuntu()
    windows = Windows()

    useCase = LogOff(ubuntu)
    # [1]
    useCase.someFunctionality()
    """
    Output for code [1]
    LogOff : Ubuntu
    """

    useCase = LogOff(windows)
    # [2]
    useCase.someFunctionality()
    """
    Output for code [2]
    LogOff : Windows
    """

    useCase = Shutdown(ubuntu)
    # [3]
    useCase.someFunctionality()
    """
    Output for code [3]
    Shutdown : Ubuntu
    """
    useCase = Shutdown(windows)

    # [4]
    useCase.someFunctionality()
    """
    Output for code [4] :
    Shutdown : Windows
    """


if __name__ == "__main__":
    main()

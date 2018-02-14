# Exercise 5: Chain of Responsibility & Command Patterns

CSCM602023 - Advanced Programming (Pemrograman Lanjut) @ Faculty of
Computer Science Universitas Indonesia, Even Semester 2016/2017

[![build status](https://gitlab.com/CSUI-AdvProg-2017/lab-exercises/badges/week-5/build.svg)](https://gitlab.com/CSUI-AdvProg-2017/lab-exercises/commits/week-5)

* * *

There are 2 design patterns that will be practised in this exercise:

1. Chain of Responsibility 

    > For example, you have three payment methods (**A**, **B**, and
    > **C**) setup in your account where each methods has different
    > balance in it. **A** has 100 USD, **B** has 300 USD, and **C**
    > has 1000 USD. The preference for payment is chosen from A,
    > then B, and lastly C.

    > You try to purchase something that is worth 210 USD. Using Chain
    > of Responsibility, first of all account A will be checked if it
    > can make the purchase. If it is possible, a purchase will be made
    > and the chain will be broken. Otherwise, request will move forward
    > to account B where the same checking procedure will be done.

    > This chain of request forwarding will be done in each accounts if
    > the account does not have enough balance. If an account has enough
    > balance to pay for the purchase, the account will be used for paying
    > the purchase and the request forwarding is done. In this example,
    > account **A**, **B**, and **C** are the handlers whereas the payment
    > request is the message/request that will be passed through the chain
    > in the example of Chain of Responsibility pattern.
	
2. Command

    > A generic example would be you ordering a food at restaurant. You
    > (i.e. Client) ask the waiter (i.e. Invoker) to bring some food
    > (i.e. Command) and waiter simply forwards the request to Chef
    > (i.e. Receiver) who has the knowledge of what and how to cook.
    > Another example would be you (i.e. Client) switching on (i.e. Command)
    > the television (i.e. Receiver) using a remote control (Invoker).

For this week mandatory exercise, you need to complete implementation of
Chain of Responsibility and Command patterns that can be found in `m1cor.py`
and `m1com.py` respectively. The tasks for each patterns are as follow:

1. Inside file `m1cor.py`, you are expected to use **Chain of Responsibility**
pattern for handling process pipelining. Your tasks:
    1. Complete `ProcessLevel1` class that should only able to handle
    data in range 0 to 19. If the data is beyond the expected range,
    it shall be passed to the next handler, i.e. `ProcessLevel2`
    2. Complete `ProcessLevel2` class that should only able to handle
    data in range 20 to 39. If the data is beyond the expected range,
    it shall be passed to the next handler, i.e. `ProcessLevel3`
    3. Complete `ProcessLevel3` class that should only able to handle
    data in range 40 to 59. If the data is beyond the expected range,
    an exception must be raised with error message saying that the
    data cannot be processed.

    As you can see in the main function, `ProcessLevel1` object will print
    `This data can't be processed` when it tried to process data 70. However,
    when `ProcessLevel1` tried to process data 45, it will print different
    string, that is `Using Process Level 3, Processing Data 45`. It means that,
    even though you called method `process` with `ProcessLevel1` object, it will
    call the correct Process Level to handle each data.
2. Inside file `m1com.py` you're expected to use **Command** pattern implementation
for executing command inside `Light` and `Television` objects. Your tasks:
    1. Complete `LightSwitchClient` class, so that when it call method
    press (with command `ON`, `OFF`), `LightSwitchClient` will execute
    the correct method inside `Light` class (For example, method
    `turn_on` activated when `ON` command is called)
    2. Implement `TelevisionRemote` and `TelevisionRemoteClient` class
    and make sure that every Command for `TelevisionRemoteClient` in
    main function can run the correct function in `Television` class

There are some additional exercise for both patterns implementation if
you want more challenges. Each pattern implementation can be found in
`a1cor.py` and `a1com.py`. The additional tasks for each patterns are
as follow:

1. Inside file `a1cor.py` you are expected to use **Chain of Responsibility**
pattern implementation for Handling `Help` request when a user clicked Help
Button. Your tasks:
    1. Implement `Widget` and `Application` class. Both classes derived
    from `HelpHandler` class. 
    2. Implement `Button` and `Dialog` class. Both classes derived from
    `Widget` class.

    Hint: When `Help` is requested, first it will ask `Button` for the
    handler. If there is no handler then it will ask `Dialog` and ask
    `Application` if `Dialog` still does not have any handler. An object
    does not have a handler if the `topic` attribute refer to `NO_HELP_TOPIC`.
2. Inside file `a1com.py` you're expected to use **Command** pattern
implementation for executing Command inside `Gundam` and `Megazord` objects
    1. Implement the **Invoker**, i.e. `RobotRemote` class. This class
    are the one who know how to execute the command and keeping the
    log of command execution.
    2. Implement the **Client**, i.e. `GundamRemoteClient` and
    `MegazordRemoteClient` class. This class are the one who handle
    every command given by User and execute the correct process based on
    the command.
    3. Implement the **Command**, i.e. classes whose name ends with
    `Command`. This class invoke the method in **Receiver** class
    (`Megazord` and `Gundam`)

Make sure that all classes & methods that you worked on produce output that
is similar to the expected output. You can read the main procedure written
in each modules to know the expected output, and **change the template code if necessary, but not the main method**. Additionally, you also need to
ensure that the unit tests pass for both mandatory and additional exercises.

* * *

## Mandatory Checklist

- [ ] Put your work in separate branch named `lab-week-5`
- [ ] Complete the code and make sure that `m1cor.py` working as expected (The console output is the same as expected)
- [ ] Make sure that all unit tests in `tests/m1cor-tests.py` passed (The console output is the same as expected)
    - [ ] Run this command in `week_5` directory: `python -m unittest tests/m1cor-tests.py`
- [ ] Complete the code and make sure that `m1com.py` working as expected (The console output is the same as expected)
- [ ] Make sure that all unit tests in `tests/m1com-tests.py` passed (The console output is the same as expected)
    - [ ] Run this command in `week_5` directory: `python -m unittest tests/m1com-tests.py`
- [ ] Push your work to your GitLab repository
    - Make sure that all test cases in GitLab pipeline passed

## Additional Checklist

- [ ] Complete the code and make sure that `a1cor.py` working as expected (The console output is the same as expected)
- [ ] Make sure that all unit tests in `tests/a1cor-tests.py` passed (The console output is the same as expected)
    - [ ] Run this command in `week_5` directory: `python -m unittest tests/a1cor-tests.py`
- [ ] Complete the code and make sure that `a1com.py` working as expected (The console output is the same as expected)
- [ ] Make sure that all unit tests in `tests/a1com-tests.py` passed (The console output is the same as expected)
    - [ ] Run this command in `week_5` directory: `python -m unittest tests/a1com-tests.py`
- [ ] Push your work to your GitLab repository
    - Make sure that all test cases in GitLab pipeline passed

## Additional Resources

- Chain of Responsibility and Command explanation is taken from
[Design Pattern for Human](https://github.com/kamranahmedse/design-patterns-for-humans)

## Credits

- [Calderon Roberto](http://calderonroberto.com/), as a Reference for Chain of Responsibility Design Pattern code
- [Wikipedia](https://en.wikipedia.org/), as a Reference for Chain of Responsibility and Command Design Pattern code
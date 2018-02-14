# Exercise 3: Adapter & Bridge Pattern

CSCM602023 - Advanced Programming (Pemrograman Lanjut) @ Faculty of
Computer Science Universitas Indonesia, Even Semester 2016/2017

* * *

[![build status](https://gitlab.com/CSUI-AdvProg-2017/lab-exercises/badges/week-3/build.svg)](https://gitlab.com/CSUI-AdvProg-2017/lab-exercises/commits/week-3)

Your task in this exercise is to complete an implementation of Adapter
& Bridge patterns. More specifically, there are 2 mandatory tasks and
1 additional tasks:

1. Complete [week3.py](week3.py)
2. Translate [BridgePatternDemo.java](BridgePatternDemo.java)
to Python-based implementation
3. Write a code implementation based on a given UML Class Diagram

# Mandatory Checklist

You are required to do all tasks in the mandatory checklist. You also
need to be able to explain your works to your TA during demo session.

## Adapter Pattern

1. [ ] Complete the code template in `week3.py` with the required code
which are hinted as Python comments in the source code
    - Save your work in a new Python module named `m1adapter.py`
2. [ ] Explain how the Adapter pattern implementation works in a new
text file named `m2adapter.txt`

## Bridge Pattern

1. [ ] Translate the code in `BridgePatternDemo.java` into `m1bridge.py`
    - Save your work in a new Python module named `m1bridge.py`
2. [ ] Explain how the Bridge pattern implementation works in a new
text file named `m2bridge.txt`

# Additional Checklist

The following diagram represents structure of some classes that are
related to implementing common OS operations. You will need to
understand the diagram and try to separate the abstraction of the
operations with its OS-specific implementation. In order to do so,
you have to implement Bridge pattern in this exercise.

![alt tag](http://i68.tinypic.com/11vmhsp.png)

## Bridge Pattern

1. [ ] Implement Bridge pattern in a Python module named `a1bridge.py`
based on the diagram and description given in the Additional Checklist

## Rules

Several rules that must be observed when doing the Additional Checklist:

- Copy `main()` from usecase.py to `a1bridge.py`
- You must not modify `main()` function
- `AnotherFunctionality()` only return the class name
- `SomeFunctionality` use `AnotherFunctionality`
- `SomeFunctionality()` print the class name + "$$$$$$" name
    - Please refer to the hint in the [usecase.py](usecase.py) for
    this point
- Use `m1bridge.py` as the reference

## Additional Resources

- [Daring Fireball: Markdown Syntax Documentation](https://daringfireball.net/projects/markdown/syntax.php)
- [reStructuredText Cheatsheet](http://docutils.sourceforge.net/docs/user/rst/cheatsheet.txt)
- [UML 2 Class Diagrams](http://www.agilemodeling.com/artifacts/classDiagram.htm)

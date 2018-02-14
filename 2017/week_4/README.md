# Exercise 4: Composite, Decorator, and Facade Pattern

CSCM602023 - Advanced Programming (Pemrograman Lanjut) @ Faculty of
Computer Science Universitas Indonesia, Even Semester 2016/2017

* * *

[![build status](https://gitlab.com/CSUI-AdvProg-2017/lab-exercises/badges/week-4/build.svg)](https://gitlab.com/CSUI-AdvProg-2017/lab-exercises/commits/week-4)

Your tasks in this exercise are to complete a partial implementation
of Composite pattern and create a simple decorator function. The code
for Composite pattern is taken from an example available where it 
illustrates the traditional Composite pattern implementation by having
separate classes for representing **simple** and **composite** items.

The code contains several parts that already been omitted in a way that
it fails the unit tests. You are required to complete the code and
ensure that it pass every unit tests (i.e. achieving `green` build in
GitLab pipeline).

Your code will be run by a GitLab CI Runner instance where it will do
`git clone` to your repository and try to run one or more jobs that
will evaluate the correctness of your work. The jobs can be in form
of running unit tests or checking whether the required files exist in
certain directory.

If everything goes well on every jobs, the [Pipeline](https://gitlab.com/CSUI-AdvProg-2017/lab-exercises/pipelines)
will report a `green` (i.e. success) build. Otherwise, it will report
`orange` (i.e. warning) or `red` (i.e. fail) build. This information
must be given to your TA to help him/her grade your work. Therefore,
you have to enable Pipeline access so it can be viewed publicly.

Sometimes GitLab may have delays on running your code because
it uses shared instance of runners. You can manually run the unit
tests in your own PC without having to commit and push it to your
repository. You can do so by executing the following command inside
week 4 directory: `python -m unittest test_week4.py`

You also need to create a simple decorator function named `logged()`
in this exercise. The specifications for the decorator function is
as follows:

1. The decorator shall print the **name of the decorated function**
**BEFORE** the decorated function is called
2. The decorator shall print the **number of arguments** passed to the
decorated function **BEFORE** the decorated function is called
3. (Optional) The decorator also print the **string representation of
each arguments** that passed to the decorated function **BEFORE** the
decorated function is called
4. The decorator will be applied to a function with varying
number of arguments, i.e. it can be a function without arguments or
function with any number of arguments

At the end of exercise, you are also asked to understand a toy example
of Facade pattern implementation and write your explanation into a text
file. Ensure that you can explain it to your TA as well. At minimum,
you should be able to explain the structure, purpose, and benefit of
Facade pattern.

* * *

## Mandatory Checklist

You are required to do all tasks in the mandatory checklist. You also
need to be able to explain your works to your TA during demo session.


- [ ] Set your repository's Pipeline permission to **Everyone with access**
    - Change it by going to: `https://gitlab.com/<YOURGITLABUSERNAME>/lab-exercises/edit`
- [ ] Implement blank methods in week4.py module
    - Tip: Do not forget to commit and push your work frequently even
    though it is not yet finished
- [ ] Demonstrate to your TA that all of the unit tests pass
- [ ] Implement `logged()` decorator function according to the given
specifications
- [ ] Apply `logged()` decorator to `make_item()` and
`make_composite()` 
- [ ] Demonstrate to your TA that your `logged()` decorator is working
according to the specifications when the program calls `make_item()`
- [ ] Analyse the given Facade example (i.e. `FacadeDemo.py`) and write 
your analysis result into a text file named `m1facade.txt`
    - The text should contain explanation regarding the structure, purpose,
    benefit, and how it was implemented in the example

## Additional Checklist

- [ ] Implement the additional/optional specifications for `logged()`
decorator function, i.e. the one that prints string values of each
arguments
- [ ] Create a new Python module named `week4a.py` containing Python
statements to demonstrate the optional specifications for `logged()`
decorator is working
    - Hint: Import `SimpleItem`, `CompositeItem`, and two `make_*`
    functions from `week4` module into `week4a`
- [ ] Demonstrate to your TA that `logged()` function still works
correctly and produces result as expected in the optional
specifications

## Additional Resources

N/A

## Credits

- FacadeDemo.py by [jackaljack](https://github.com/jackaljack)

    The example can be found in his [design-patterns](https://github.com/jackaljack/design-patterns) repository on
    GitHub. It is licensed under [MIT License](https://github.com/jackaljack/design-patterns/blob/master/LICENSE).

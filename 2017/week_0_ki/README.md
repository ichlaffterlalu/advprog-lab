# Exercise 0: Introduction to Git

CSCM602023 - Advanced Programming (Pemrograman Lanjut) @ Faculty of
Computer Science Universitas Indonesia, Even Semester 2016/2017

* * *

Hello! Welcome to the first Advanced Programming tutorial! You are
going to learn how to use basic Git commands.

This tutorial is divided into two parts. The first part is introduction
to basic Git commands. You will learn how to create a Git repository in
your local machine, saving your work into repository, and pushing your
repository to a remote Git repository.

The second part of the tutorial will introduce Git branches and how
to work on branches.

## First Part: Git 101

During your life as a CS student, you may have used some sort of version
control system. Probably the most pervasive example is undo functionality
in text editor. Whenever you make some mistakes, you can revert back to
previous state of your work by using undo function in text editor. Another
example is when you are working on a document collaboratively using Google
Drive where you can see every revisions made to the document.

In this course, you are going to use Git extensively. Git is a version
control system that commonly used to track changes in software artefacts.
It works by capturing the states of items in the software artefacts as
series of commits. The commits are arranged in linear manner from the
oldest commit to the most recent commit and may have several branches.
Think of it like a graph in which a node represents a commit and
directed edge(s) represent the connection from a commit to its
subsequent commit(s).

Enough with the background information. Let's start with the exercise!

1. Start your command-prompt or shell. In Windows, run `Git Bash`. In
Linux-based OS or Mac OS, you can use your favourite shell (e.g. Bash,
zsh).
2. Set your current directory to a directory where you will store any
Advanced Programming-related work. Use `cd` commands to navigate to
a directory of your choice.
3. Create a new directory to store new files related to this exercise.
Try naming the directory to `git-exercise` and set your current
directory to the recently created directory.
4. Inside the new directory, execute `git init`. An empty Git
repository will be created inside this directory.
5. Try executing `git status`. It will print the state of Git repository
at the time of command execution.

Congratulations! You have created your first local Git repository.
Before we can continue the tutorial, there are several configurations
need to be done to your local Git repository.

1. Set the username and email that will be associated with your work in
this Git repository. Run this command in your local Git repository:
`git config user.name "<YOURNAME>"` and `git config user.email <YOUREMAIL>`
Example: `git config user.name "John Doe"` followed by
`git config user.email example@gmail.com`
2. If you are using PC in Fasilkom labs, you need to set HTTP proxy
in Git configuration as well. Set the proxy by using this command: 
`git config http.proxy 152.118.24.10:8080`
3. If you want to set the configuration globally (i.e. for every Git
repositories in your local machine and new local repositories in the
future), add `--global` flag in `git config` calls.
4. If you want to know the configurations set to your local repository,
try this command: `git config --list --local`

Once you have configured your username and email, you may proceed to the
next tutorial instructions.

1. Create a new file named **README.md** and put your name in the first
line, NPM in the second line, and class in the third line of the file.
2. Run `git status` again. Notice that there is an untracked file. It
means that there is a file that is not yet tracked by Git.
3. Add the file into Git by executing `git add README.md`.
4. Run `git status` again. The status message will be different from
previous `git status` execution. See that the `README.md` file is
put into section named `Changes to be committed`. It means that
README.md will be tracked by Git in the next commit.

    As of now, README.md is not yet tracked by Git even though you
    have run `git add README.md`. `git add` command only tells Git to
    include changes in file(s) into Git's *staging area*. 
5. To persist the changes permanently into Git, run `git commit`.
A text editor (Vim) will appear where you have to write a message
describing the commit.

    How to use Vim: `h j k l` to move cursor in Vim, `i` to switch to
    INSERT mode, `escape` to switch back to COMMAND mode, `:w` in COMMAND
    mode to write content buffer to output stream, `:q` in COMMAND mode
    to exit Vim.
6. Once you have written the commit message, write the content and
then exit the text editor. The changes will be persisted into a commit
and stored in Git.

You have just created a Git repository and start tracking changes to a
file in the repository. The repository that you just created is stored
in your own machine. If you are going to share your work with your
colleagues, you need to have the repository accessible via Web. In order
to do that, you are going to put a copy of your repository to an online
Git hosting service named GitLab.

1. Go to GitLab.com by using your favourite Web browser.
2. Create an account or use an existing one if you have registered prior
to taking this course.
3. Create a new repository named **My First Git Repo** on GitLab and go
to its repository page. Ensure that you set the visibility to Public.
4. Find a section named clone URL in the page. Notice that there are 2
kinds of URL: HTTPS and SSH. Take note of the HTTPS URL.
5. You are going to update your local Git repository so your commits
can be stored in GitLab as well. Execute `git remote add origin <URL>`
where `<URL>` is the HTTPS URL of your GitLab repository. Example:
`git remote add origin https://gitlab.com/JohnDoe/my-first-repo.git`
`git remote` adds a path from your local repository to the online
repository on GitLab. The path has an identifier named `origin`. By
having this path, you can begin storing your commits to the online
repository as well.
6. To store your commits to your online GitLab repository, run
`git push -u origin master`. `git push -u` tells Git to push commits in
your local `master` branch to repository pointed by `origin` and ensure
subsequent `git push` calls will be sent to `master` branch at `origin`.
7. Check your GitLab repository page. You will see that your files are
available on GitLab.

You can also get (i.e. clone) other repository to your local machine.
Let's try making a copy of your repository from GitLab to a different
directory in your machine.

1. Go to your repository page on GitLab.
2. Take note of its HTTPS clone URL.
3. Switch back to your command-prompt or shell. Go to a different
directory outside of your own local Git repository.
4. Run this command: `git clone <URL>` where `<URL>` is the clone URL.
5. Confirm that a new directory is created at the location where you
executed the `git clone` command.

This ends the first part of the tutorial. Make sure that you have
informed your GitLab username to the teaching team (TA and lecturer)
so they can monitor your work.

## Second Part: Git Branches

When you need to edit something but it is still unclear whether it would
actually work or not, that's when the branch feature becomes important to
your group project. If you edit something in your branch, your files on
`master` branch still the same as before.

How to create branch from latest commit in `master`:

1. Make sure you are inside the `master` branch. You can check the branch
that you are currently working at by using `git branch`.
2. Create a new branch by using `git branch <BRANCHNAME>`. Example:
`git branch cool-feature`
3. Switch to your new branch using `git checkout <BRANCHNAME>`. Example:
`git checkout cool-feature`

    Actually, step 2 and 3 can be shortened into a single `git checkout`
    call: `git checkout -b <BRANCHNAME>`
4. Verify that you have switched to the new branch. Try invoke `git branch -v`.
The branch name in bold text is the current branch you are working on.

Now you are working on your new branch, let's try to simulate concurrent working
on the same project:

1. Open the README.md file.
2. Create one new line below the third line. Write your hobby in that line.
3. Save the README.md file.
4. Add the README.md file into *staging area*. Use the command:
`git add README.md`
5. Commit the README.md file into the Git. Use the command `git commit`
and write a commit message.
6. Push the commit. Use the command `git push -u origin <BRANCHNAME>`

Do you have any problem with the instructions above? If you don't, do
the following:

1. Work on the `master` branch. Use the command `git checkout master`
to switch back to `master` branch.
2. Open the README.md file.
3. Create one new line below the third line. Write your *other* hobby
in that line (must be different with previous one).
4. Save the README.md file. Add the modified README.md to *staging area*
by using `git add README.md` then commit it into Git.
5. Merge the new branch with the `master` branch. Use this command:
`git merge <BRANCHNAME>` Example: `git merge cool-feature`

There should be a problem in your `git merge`, which Git will provide some
options to resolve the conflict. Choose anything suitable with your merge
conflict condition. (In this case you will need to choose what hobby really
suitable with you). The conflict can be resolved by opening the conflicting
file in a text editor and choose which portion that you consider correct.

To give you an example, suppose that you call `git merge` in `master`
branch. Git reported that there is a merge conflict in README.md file.
Consequently, Git included the conflicting changes from both branches
in README.md and ask the programmer to resolve the conflict. The
conflicting part in the README.md file is as follows:

```
Name    : John Doe
NPM     : 123456789
Class   : A/B/INT
<<<<< HEAD
Hobby   : Sleeping
=========
Hobby   : Dreaming
>>>>> cool-feature
```

Notice that there are 2 sections labelled with name of branches: `HEAD`
and `cool-feature`. Section between `HEAD` and `===` line contains the
content from `master` branch whereas the section between `===` line and
`cool-feature` contains the content from `cool-feature` branch. As a
programmer that resolving the conflict, there are 3 options that you
can follow.

1. Pick the changes from `master` and discard content from `cool-feature`.

    The final result should be similar to this example:
    ```
    Name    : John Doe
    NPM     : 123456789
    Class   : A/B/INT
    Hobby   : Sleeping
    ```
2. The other way around: pick the changes from `cool-feature` and
discard content from `master`.

    The final result should be similar to this example:
    ```
    Name    : John Doe
    NPM     : 123456789
    Class   : A/B/INT
    Hobby   : Dreaming
    ```
3. Integrate changes from both branches, or even came up with completely
different content. One example is as follows:

    ```
    Name    : John Doe
    NPM     : 123456789
    Class   : A/B/INT
    Hobby   : Sleeping, dreaming, listening to music
    ```

* * *

### Mandatory Tasks Checklist

- [ ] Local Git repository contains at least one commit
- [ ] Local Git repository is synchronised with GitLab
- [ ] Able to clone the same Git repository from GitLab to a different
directory
- [ ] Local Git repository contains one branch

## Additional Tasks Checklist

- [ ] Find a public Git repository on GitLab or GitHub and try
to clone it to local machine
- [ ] Able to perform a merge conflict resolution

## Additional Resources

- [Git Tutorials & Training by Atlassian](https://www.atlassian.com/git/tutorials)
- [Try Git in your Web browser](https://try.github.io/)
- [Pro Git e-Book by Scott Chacon & Ben Straub](https://git-scm.com/book/en/v2)
- [Graph theory](http://think-like-a-git.net/sections/graph-theory.html) and
[ applications in Git](http://think-like-a-git.net/sections/graphs-and-git.html)

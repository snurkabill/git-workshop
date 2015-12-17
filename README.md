PB162 Seminar project
=====================
This project is a set of subsequent assignments used to demonstrate and practice the main aspects of Java and Object Oriented Programming in semianr groups of PB162 course at Faculty of Informatics, Masaryk University .


Downloading the assignment
==========================

The assignment is distributed in form of a git repository hosted on [gitlab.com](https://gitlab.com). For more information about this version control system have a look at [The Git Book](https://git-scm.com/book/en/v2).

## Checking out the assignment

First you need to create a local clone of this repository using these commands

```bash
$ git clone https://gitlab.com/munijava/pb162-seminar-project.git pb162-seminar-project
$ cd pb162-seminar-project
```

From now on, you will work in this local copy. The following command can be used to display the current status of your new repository.
```bash
$ git status
On branch master
nothing to commit, working directory clean
```
Notice that that currently active branch is **master**, this is the branch you want to work in.

## Updating to next iteration
At the beginning of each class you will need to *pull* the assignment for next iteration into your master branch. The following command demonstrates the upgrade to iteration 01.

```bash
$ git pull origin iteration-01
From origin
 * branch            iteration-01 -> FETCH_HEAD
Merge made by the 'recursive' strategy.
 README.md                                                    |  55 ++++++++++
 src/main/java/cz/muni/fi/pb162/project/demo/Draw.java        | 199 ++++++++++++++++++++++++++++++++++
 src/main/java/cz/muni/fi/pb162/project/demo/DrawExtra01.java |  53 +++++++++
 src/main/resources/01-readme.html                            | 101 +++++++++++++++++
 src/main/resources/01b.png                                   | Bin 0 -> 2933 bytes
 src/main/resources/01c.gif                                   | Bin 0 -> 598 bytes
 src/test/java/cz/muni/fi/pb162/project/test/ProjectTest.java |  57 ++++++++--
 7 files changed, 455 insertions(+), 10 deletions(-)
 create mode 100644 README.md
 create mode 100644 src/main/java/cz/muni/fi/pb162/project/demo/Draw.java
 create mode 100644 src/main/java/cz/muni/fi/pb162/project/demo/DrawExtra01.java
 create mode 100644 src/main/resources/01-readme.html
 create mode 100644 src/main/resources/01b.png
 create mode 100644 src/main/resources/01c.gif
```

During the procedure you will most likely be prompted (by opened text editor window) to enter a merge message. You can safely save and close the window.

## After finishing the work on iteration

Git (unlike Subversion, which you might have encountered) requires you to *commit* (save) your changes before *pulling* anyhting new. Thus after you are finished working on current iteration you should:

Check the status of your repository to view all the changes made

```bash
$ git status
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

Untracked files:
  (use "git add <file>..." to include in what will be committed)

    src/main/java/cz/muni/fi/pb162/project/demo/
```

*Commit* the changes to confirm and save them.

```bash
$ git add .
$ git commit -m "My implementation of iteration 00"
```

It is highly recommended that you commit your changes whenever you feel like "saving" is a good idea. This will protect your work and further more allow you to go back if needed.

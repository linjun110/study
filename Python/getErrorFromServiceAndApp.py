#!/usr/local/bin/python
import os
import re

# this is used to extract errors from service.log and application.log for analysis

# utils
def isMatch(regx, line):
    return re.compile(regx).match(line)

def isMatchBeginWith(beginWith, line):
    return isMatch("^"+beginWith+"=", line)

def handleStart(line, container):
    startFlag = "------------------------------------------------------------------------"
    if isMatch(startFlag, line):
        if container != None:
            # add filter condition here:
            if isMatch(",Error=[1-9][0-9]*,", container.pop("Time", "")):
                matchList.append(container)

        container = {} 
    return container

def handleMatchBeginWith(flag, line, container):
    if isMatchBeginWith(flag, line):
        if container != None:
            # plus 1 since there is a "="
            container[flag] = line[len(flag)+1:]

print "Start"

# init
matchList = []
container = None
attrs = ["RequestId", "ESOFS_Client"]

serviceFile = open("./service/tmp")
appFile = open("./application/tmp")

# file to store search result
outFile = open("./tmp", 'w')

# find matched request and aquire infomation, then store in memory
for line in serviceFile.readlines():
    # remove \n
    line=line.strip('\n')

    # specially handle start
    container = handleStart(line, container)

    # handle all tags
    for attr in attrs:
        handleMatchBeginWith(attr, line, container)

if len(matchList) == 0:
    print "Not found"
    exit(0)

# find corresponding logs in application
index = 0
mapKey = 'RequestId'
for line in appFile.readlines():
    # remove \n
    line=line.strip('\n')

    # find request
    if line.find(matchList[index][mapKey], 0) < 0:
        if index + 1 >= len(matchList):
            continue

        if line.find(matchList[index + 1][mapKey], 0) < 0:
            continue

    if line.find(matchList[index][mapKey], 0) > 0:
        outFile.write(line + "\n")
        continue

    if line.find(matchList[index+1][mapKey], 0) > 0:
        index = index + 1;
        continue

# close all files
serviceFile.close()
appFile.close()
outFile.close()

print "Done"

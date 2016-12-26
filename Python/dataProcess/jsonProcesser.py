#!/usr/local/bin/python
import os
import re
import urllib  
import urllib2
import cookielib
import string
import json

targetUrl = 'https://www.zhihu.com/'
jsonFile = open("items.json")
outFile = open("out.json", "w")

# read json

arraylike = json.load(jsonFile)

# write json to file
#json.dump(arraylike, outFile)

# access json
print(arraylike)
print(len(arraylike))
for item in arraylike:
    titleArray = item["title"]
    for title in titleArray:
        print 'title:', title.strip(" ")

jsonFile.close();
outFile.close();

# regex extract specific parts
s = 'text=cssPath:"http://imgcache.qq.com/ptlogin/v4/style/32",sig:"OvL7F1OQEojtPkn5x2xdj1*uYPm*H3mpaOf3rs2M",clientip:"82ee3af631dd6ffe",serverip:"",version:"201404010930"'

# applicable usage
m = re.match(r'.+sig:"([^"]*)",clientip:"([^"]*)",serverip:"([^"]*)",version:"([^"]*)"', s)
print m.group(0)
print m.group(1)
print m.group(2)
print m.group(3)
print m.group(4)

# bad scenario demo
s2 = "Isaac Newton, physicist"
s3 = 'sig:"OvL7F1OQEojtPkn5x2xdj1*uYPm*H3mpaOf3rs2M",clientip:"82ee3af631dd6ffe",serverip:"",version:"201404010930"'
m = re.match(r"(\w+) (\w+)", s2)
print m.group(0)
print m.group(1)
print m.group(2)

m = re.match(r'sig:"([^"]+)",clientip:"([^"]+)"', s3)
print m.group(0)
print m.group(1)


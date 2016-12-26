#!/usr/local/bin/python
import os
import re
import urllib  
import urllib2
import cookielib
import string
from lxml import etree
from bs4 import BeautifulSoup

targetUrl = 'https://www.taobao.com/markets/nvzhuang/taobaonvzhuang?spm=a21bo.50862.201867-main.2.chylDF'
cookieJar = cookielib.CookieJar() # init CookieJar to handle Cookie
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cookieJar))

result = opener.open(targetUrl)
html = result.read()
#print html
selector = etree.HTML(html)
imags = selector.xpath("//div[contains(@class, 'ipic')]//img")
print len(imags)
for img in imags:
    print img.xpath("//@src")[3]
bsObj = BeautifulSoup(html, "html.parser")
images = bsObj.find_all(class_="ipic")
for img in images:
    item = img.find('img')
    print item['src']
print(bsObj.title)

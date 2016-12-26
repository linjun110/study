#!/usr/local/bin/python

import urllib2
import urlparse
import re
import lxml.html
import time
import threading

SLEEP_TIME=1

# download single page
def download(url, user_agent='wswp', proxy=None, num_retries=2):
    print 'Downloading:', url
    headers = {'User-agent': user_agent}
    request = urllib2.Request(url, headers)

    opener = urllib2.build_opener()
    if proxy:
        proxy_params = {urlparse.urlparse(url).scheme: proxy}
        opener.add_handler(urllib2.ProxyHandler(proxy_params))

    try:
        html = urllib2.urlopen(url).read()
    except urllib2.URLError as e:
        print 'Downloaded error:', e.reason
        html = None
        if num_retries > 0:
            if hasattr(e, 'code') and 500 <= e.code < 600:
                return download(url, user_agent, proxy, num_retries-1)
    return html

#???
def crawl_sitemap(url):
    sitemap = download(url)
    links = re.findall('<loc>(.*?)</loc>', sitemap)
    for link in links:
        html = download(link)

def link_crawler(seed_url, link_regex):
    crawl_queue=[seed_url]
    seen = set(crawl_queue) #todo, why set this work?
    while crawl_queue:
        url = crawl_queue.pop()
        html = download(url)
        # todo: html is the content, grab necessary info from it
        enjoy(html)
        for link in get_links(html):
            if re.match(link_regex, link):
                link = urlparse.urljoin(seed_url, link)
                if link not in seen:
                    seen.add(link) # does it add to seen?
                    print "add link: ", link
                    crawl_queue.append(link)

def get_links(html):
    webpage_regex = re.compile('<a[^>]+href=["\'](.*?)["\'"]', re.IGNORECASE)
    return webpage_regex.findall(html)

# what's its use
class Throttle:
    def __init__(self, url):
        self.delay = delay
        self.domains = {}
    def wait(self, url):
        domain = urlparse.urlparse(url).netloc #what's this
        last_accessed = self.domains.get(domain)

        if self.delay > 0 and last_accessed is not None:
            sleep_secs = self.delay - (datetime.datetime.now()-last_accessed).seconds

            if sleep_secs > 0:
                time.sleep(sleep_secs)
        self.domains[domain] = datetime.datetime.now()

def enjoy(html):
    print 'enjoy'
    tree = lxml.html.fromstring(html)
    tds = tree.cssselect('tr#places_area_row > td.w2p_fw')
    print tds
    if tds is not None and len(tds) > 0:
         print tds[0]
    #    area = td.text_content()
    #    print area

link_crawler('http://example.webscraping.com', '/(index|view)')

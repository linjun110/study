# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html

from scrapy.exceptions import DropItem


class TutorialPipeline(object):
    def __init__(self):
        #self.file = open('items.jl', 'w')
        self.file = None

    def process_item(self, item, spider):
        #line = json.dumps(dict(item)) + "\n"
        #self.file.write(line)
        #self.file.write("a\n")
        item["title"].append("hi")
        return item
        #raise DropItem("Missing price in %s" % item)

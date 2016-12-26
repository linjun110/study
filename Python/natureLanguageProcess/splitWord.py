#!/usr/local/bin/python
# -*- coding: utf-8 -*-
import jieba

seg = jieba.cut("我是一只小小鸟")
print seg
seg_list = list(seg)
for item in seg_list:
    print item.encode('utf-8')


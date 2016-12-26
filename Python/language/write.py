#!/usr/local/bin/python
import pickle
import shelve

file = open('dbfile', 'wb')
bob = {'name': 'linjun', 'age': 46}
pickle.dump(bob, file)

shelveDb = shelve.open('shelveDbFile')
shelveDb['name'] = 'linjun'
shelveDb.close()

print __name__

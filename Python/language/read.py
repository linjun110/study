#!/usr/local/bin/python
import pickle
import shelve

file = open('dbfile', 'rb')
bob = pickle.load(file)
print bob

shelveDb = shelve.open('shelveDbFile')
print shelveDb['name']
shelveDb.close()

#!/usr/local/bin/python3
import os, sys
from http.server import HTTPServer, CGIHTTPRequestHandler
#from BaseHTTPServer import BaseHTTPRequestHandler

webdir = '.'
port = 80

os.chdir(webdir)
srvraddr = ("", port)
srvrobj = HTTPServer(srvraddr, CGIHTTPRequestHandler)
srvrobj.serve_forever()

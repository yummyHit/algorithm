#!/usr/bin/python

import sys

a = raw_input()
a = int(a)

while a < 16:
	sys.stdout.write(str(a) + " ")
	a += 1

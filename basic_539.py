#!/usr/bin/python

sum = 0
count = 0

a = raw_input().split()

for val in a :
	print a
	sum = sum + int(val)
	count += 1
	if int(val) >= 100:
		break
print sum
print round((float(sum)/float(count)),1)

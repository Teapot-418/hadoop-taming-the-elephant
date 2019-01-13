#!/usr/bin/env python

import sys

id = 0

for line in sys.stdin:
  val = line.strip()
  data = val.split(',')
  category = data[1]
  print(category + '\t' + str(id))
  id = id + 1
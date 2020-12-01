from heapq import *
def fcfs(array, head):
  print("DESCRIPTION: In this algorithm, requests are handled in the order they arrive at the
  queue")
  total_time = 0
  num_of_reqs = len(array)
  pos = head
  for a in array:
  total_time += abs(a-pos)
  pos = a
  print(" ", pos, " seeked")
  return total_time / num_of_reqs

def sstf(array, head):
  print("DESCRIPTION: In this algorithm, requests having the shortest seek time are handled
  first")
  req = array.copy()
  total_time = 0
  pos = head
  length = len(req)
  heap = []
  while len(req) > 0:
  for i in req:
  heappush(heap, (abs(pos-i), i))
  ind = heappop(heap)[1]
  total_time += abs(pos-ind)
  pos = ind
  print("
  ", ind, " seeked")
  req.remove(ind)
  heap = []
  # calculate average seek time
  return total_time/length
  
def scan(array, head):
  print("DESCRIPTION: In this algorithm, the disk arm moves into a particular direction and
  services the requests coming in its path.\n")
  print("After reaching the end of disk, it reverses its direction and again services the request
  arriving in its path.")
  requests = array.copy()
  pos = head
  total_time = 0
  start = 0
  end = 4999
  num_of_reqs = len(array)
  for i in range(pos, end+1):
  if i in requests:
  total_time += abs(pos-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  total_time += abs(pos-end)
  pos = end
  for i in range(end, start-1, -1):
  if i in requests:
  total_time += abs(pos-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  return total_time / num_of_reqs

def c_scan(array, head):
  print("DESCRIPTION: In this algorithm, the disk arm scans the path that has been scanned,
  after reversing its direction.")
  print("This implies that too many requests are waiting at the other end or there may be zero or
  few requests pending at the scanned area.")
  requests = array.copy()
  pos = head
  total_time = 0
  start = 0
  end = 4999
  num_of_reqs = len(array)
  for i in range(pos, end+1):
  if i in requests:
  total_time += abs(pos-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  total_time += abs(pos-end)
  pos = end
  for i in range(end, start-1, -1):
  if i in requests:
  total_time += abs(pos-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  return total_time / num_of_reqs
  
def look(array, head):
  print("DESCRIPTION: The disk arm goes only to the last request to be serviced in front of
  the head")
  print("and then reverses its direction from there only.")
  requests = array.copy()
  pos = head
  time = 0
  start = 0
  end = 4999
  num_of_reqs = len(array)
  # seek from curr_pos to end which is 200
  for i in range(pos, end+1):
  if i in requests:
  time += abs(pos-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  # seek back to start
  for i in range(end, start-1, -1):
  if i in requests:
  time += abs(pos-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  # calculate average seek time
  return time/num_of_reqs
  
def c_look(array, head):
  print("DESCRIPTION: The disk arm goes only to the last request to be serviced in front of the
  head")
  print("and then from there goes to the other ends last request.")
  requests = array.copy()
  index = head
  time = 0
  start = 0
  end = 4999
  num_of_reqs = len(array)
  # seek from curr_pos to max of list
  for i in range(index, end+1):
  if i in requests:
  time += abs(index-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  time += abs(index-start)
  pos = start
  # seek to hp from start
  for i in range(start, head+1):
  if i in requests:
  time += abs(pos-i)
  pos = i
  print("
  ", i, " seeked")
  requests.remove(i)
  # calculate average seek time
  return time / num_of_reqs

if __name__ == '__main__':
  print("DISK SCHEDULING:")
  # n is the number of I/O requests
  print("Provide number of I/O requests: ")
  n = int(input())
  print("Provide initial position of disc arm (total cylinders=200): ")
  head = int(input())
  while head > 200:
  print("!!! INVALID !!! try again")
  head = int(input())
  print("Provide positions to visit : max is 200: ")
  array = []
  for i in range(n):
  request = int(input())
  array.append(request)
  print(array)
  # calling the functions
  print(" **********
  FCFS
  *********")
  print("Avg seek time for fcfs was ", fcfs(array, head))
  print(" **********
  SSTF
  *********")
  print("Avg seek time for sstf was ", sstf(array, head))
  print(" **********
  SCAN
  *********")
  print("Avg seek time for scan was ", scan(array, head))
  print(" **********
  C-SCAN
  *********")
  print("Avg seek time for C-scan was ", c_scan(array, head))
  print(" **********
  LOOK
  *********")
  print("Avg seek time for look was ", look(array, head))
  print(" **********
  C-LOOK
  *********")
  print("Avg seek time for C-look was ", c_look(array, head))

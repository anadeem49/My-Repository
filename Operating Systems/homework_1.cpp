#include "stdio.h"
#include "stdlib.h"
#include "limits.h"
#define MIN_PID 300
#define MAX_PID 5000
#define cb CHAR_BIT
int size = MAX_PID - MIN_PID + 1;
unsigned char *b;

int allocate_map();
int allocate_pid();
void release_pid(int pid);

/*Input: no parameters
Process: this method creates and initializes a data structure for representing pids
Output: returns -1 if unsuccessful and 1 if successful
*/
int allocate_map() {
  b = (unsigned char*)malloc((size + cb - 1) / cb * sizeof(char));
  if (b) return 1;
  return -1;
}

/*Input: no parameters
Process: allocates and returns a pid
Output: returns -1 if unable to allocate a pid (all pids are in use), else return all available pids
*/
int allocate_pid() {
  int i = 0;
  int pid = b[i / cb] & (1 << (i & (cb - 1)));
  while (pid != 0) {
    i++;
    pid = b[i / cb] & (1 << (i & (cb - 1)));
  }
  if (i + MIN_PID > MAX_PID) return -1;
  b[i / cb] |= 1 << (i & (cb - 1));
  return i + MIN_PID;
}

/*Input: an integer pid
  Process: releases a pid.
Output: no return values
*/

void release_pid(int pid) {
  if (pid < MIN_PID) {
    printf("\nInvalid PID: It should lie between 300 and 5000.");
    return;
  }
  int i = pid - MIN_PID;
  b[i / cb] &= ~(1 << (i & (cb - 1)));
  return;
}

int main() {
  int map = allocate_map();
  if (map == 1) {
  printf("\nBitmap initialized.\n");
  int key = 0, val = 0; 
  while (key < 10) {
    val = allocate_pid();
    printf("\nProcess %d: pid = %d", key, val);
    key++;
  }
  release_pid(404); printf("\nProcess 404 released.");
  }
  else printf("\nBitmap failed to initialize.\n");
  return 0;
}

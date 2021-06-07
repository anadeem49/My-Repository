//Tagsort.h

#ifndef TAGSORT_H
#define TAGSORT_H

void sort(int *t[], int n);

#endif

//Tagsort.cpp

#include "tagsort.h"

void swap(int *&xp, int *&yp){
    int *tp = xp;  
    xp = yp;  
    yp = tp;
}

void sort(int *t[], int n){
    for (int i = 0; i < n; i++)  {  
        int min = i;  
        for (int j = i+1; j < n; j++){  
        	if (*(t[j]) < *(t[min])) min = j;
        }
    swap(t[i], t[min]);
    } 
}

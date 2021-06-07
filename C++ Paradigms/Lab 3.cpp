//Lab 3.2.1

#ifndef UNTITLED1_SIMPLE_H
#define UNTITLED1_SIMPLE_H
#endif //UNTITLED1_SIMPLE_H

#include <iostream>
using namespace std;

template <typename T>
class Simple{
public:
    Simple(T v):val(v){};
    void setVal(T v){val=v;}
    T getVal(){return val;}
    void print(){cout<<val;}

private:
    T val;
};

<----------------------------->

//Lab 3.2.2

#include "Simple.h"
#include <iostream>
#include <string>
using namespace std;

int main() {
    cout<<"Working with int"<<endl;
    Simple<int> si(10);
    cout<<"After initialization to 10 si: ";
    si.print();
    cout<<endl;
    si.setVal(23);
    cout<<"After setVal(23) si: ";
    si.print();
    cout<<endl;
    cout<<"Calling print: ";
    si.print();
    cout<<endl<<endl;

    cout<<"Working with double"<<endl;
    Simple<double> sd(10.5);
    cout<<"After initialization to 10.5 sd: ";
    sd.print();
    cout<<endl;
    sd.setVal(23.5);
    cout<<"After setVal(23.5) sd: ";
    sd.print();
    cout<<endl;
    cout<<"Calling print: ";
    sd.print();
    cout<<endl<<endl;

    cout<<"Working with string"<<endl;
    Simple<string> ss("Hello");
    cout<<"After initialization to \"Hello\" ss: ";
    ss.print();
    cout<<endl;
    ss.setVal("Goodbye");
    cout<<"After setVal(\"Goodbye\") ss: ";
    ss.print();
    cout<<endl;
    cout<<"Calling print: ";
    ss.print();
    return(0);
}

<-------------------------->

//Lab 3.3.1

#include <iostream>
using namespace std;

template <typename T>
void reverse(T a[],int length){
   int i=0,j=length-1;
   T temp;
   while(i<j){
       temp=a[i];
       a[i]=a[j];
       a[j]=temp;
       i++; j--;
   }
}

template <typename T>
void print(T a[],int length){
cout<<"{";
   for(int i=0;i<length-1;i++){
       cout<<a[i]<<","<<" ";
    }
    cout<<a[length-1]<<"}";
}

<----------------------->

//Lab 3.3.2

#include <iostream>
using namespace std;

template <typename T>
void reverse(T a[],int length){
	int i=0,j=length-1;
	T temp;
	while(i<j){
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		i++; j--;
	}
}

template <typename T>
void print(T a[], int length) {
	cout << "{";
	for (int i = 0; i<length; i++){
		cout << a[i];
		if (i != length - 1) {
		cout << ", ";
		}
	}
	cout << "}" << endl;
}

int main(){
	int a[] = { 10,20,30,40,50 };
	double b[] = { 10.5,20.5,30.5,40.5,50.5,60.5 };
	string c[] = { "ABC","DE","FGHI","JK" };
	
	cout << "Playing with int" << endl;
	cout << "Before: ";
	print<int>(a, 5);
	reverse<int>(a, 5);
	cout << "After: ";
	print<int>(a, 5);
	cout << endl;
	
	cout << "Playing with double" << endl;
	cout << "Before: ";
	print<double>(b, 6);
	reverse<double>(b, 6);
	cout << "After: ";
	print<double>(b, 6);
	cout << endl;
	
	cout << "Playing with string" << endl;
	cout << "Before: ";
	print<string>(c, 4);
	reverse<string>(c, 4);
	cout << "After: ";
	print<string>(c, 4);
	cout << endl;
	
	return 0;
}


#include <cstring>
#include <iostream>
#include "mystring.h"
#include "mystring_exception.h"

namespace mystring{
    std::ostream &operator <<(std::ostream &os, const string &s){
        os << s.cs;
    	return os;
    }

    string operator +(const string &s1, const string &s2){
        string temp = s1; temp += s2;
        return temp;
    }

    string::string(const char *cs) : cs(new char[strlen(cs) + 1]){
        strcpy(this->cs, cs);
    }

    string::string(const string &s) : string(s.cs){
        strcpy(cs, s.cs);
    }

    string::~string() { delete[] cs; }

    string &string::operator =(const string &rhs){
        strcpy(cs, rhs.cs);
        return *this;
    }

    char &string::operator [](int index){
        if(index < 0 || index >= length()){
            printf("Index %d out of range\n", index);
            exit(1);
        }
        return *(cs + index);
    }

    string &string::operator +=(const string &s){
    	int newLength = length() + s.length(); 
        char *temp = new char[newLength + 1]; 
        strcpy(temp, cs); strcat(temp, s.cs); 
		delete[] cs; cs = temp; 
        return *this;
    }

    int string::length() const{return strlen(cs);}

    void string::clear(){cs[0] = '\0';}
}

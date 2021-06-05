//Rational.cpp

#include <iostream>
#include "rational.h"
#include "gcd.h"
#include "rational_exception.h"
using namespace std;

Rational::Rational(int n, int d) {
    num=n;
    if(d<0){
        num*=-1;
        denom=d*-1;
    } else if (d>0){
        denom=d;
    } else{
        throw RationalException("undefined number");
    }
    int x;
    if (abs(num) > abs(denom)) {
        x = gcd(abs(num), abs(denom));
    } else {
        x = gcd(abs(denom), abs(num));
    }
    num /= x;
    denom /= x;
}

Rational &Rational::operator+=(const Rational &r) {
    if (denom==r.denom){
        num+=r.num;
    }else{
        int temp=denom;
        num*=r.denom;
        denom*=r.denom;
        num+=(r.num*temp);
    }
    int x;
    if(abs(num)<abs(denom)){
        x=gcd(abs(num),abs(denom));
    }else{
        x=gcd(abs(denom),abs(num));
    }
    num/=x;
    denom/=x;
    return *this;
}

Rational &Rational::operator-=(const Rational &r) {
    auto other=-r;
    return (*this)+=other;
}

Rational &Rational::operator*=(const Rational &r){
    num*=r.num;
    denom*=r.denom;
    int x;
    if(abs(num)<abs(denom)){
        x=gcd(abs(num),abs(denom));
    }else{
        x=gcd(abs(denom),abs(num));
    }
    num/=x;
    denom/=x;
    return *this;
}

Rational &Rational::operator/=(const Rational &other) {
    Rational r=other.inv();
    return (*this)*=r;
}

Rational Rational::operator-() const {
    return Rational(num*-1,denom);
}

Rational Rational::inv() const {return Rational(denom, num);}
int Rational::getNumerator() const {return num;}
int Rational::getDenominator() const {return denom;}
int Rational::compareTo(const Rational &other) const {
    if (num==0&&other.num==0||(num==other.num&&denom==other.denom)){
        return 0;
    }else if (((*this)-other).getNumerator()<0){
        return -1;
    }
    return 1;
}

void Rational::print(ostream &os) const {
    os<<(*this);
}

std::ostream &operator<<(ostream &os, const Rational &r) {
    if(r.getNumerator()==0){
        os << 0;
    }else if(r.getDenominator()==1){
        os << r.getNumerator();
    }else{
        os << r.getNumerator() << "/" <<r.getDenominator();
    }
    return os;
}

Rational operator+(const Rational &r1, const Rational &r2){
    Rational r=r1;
    r+=r2;
    return r;
}

Rational operator-(const Rational &r1, const Rational &r2){
    Rational r=r1;
    r-=r2;
    return r;
}

Rational operator*(const Rational &r1, const Rational &r2) {
    Rational r=r1;
    r*=r2;
    return r;
}

Rational operator/(const Rational &r1, const Rational &r2){
    Rational r=r1;
    r/=r2;
    return r;
}

bool operator==(const Rational &r1, const Rational &r2){
    return r1.compareTo(r2)==0;
}

//4.1.1: RATIONAL.H

#ifndef RATIONAL_H
#define RATIONAL_H
#include <iostream>

class Rational{
    private: int num, denom;

    public:
        Rational(int num = 0, int denom = 1);

        int getNumerator() const;

        int getDenominator() const;

        Rational neg() const;

        Rational inv() const;

        bool equals(const Rational &r) const;

        int compareTo(const Rational &r) const;

        Rational &addInPlace(const Rational &r);

        Rational &subInPlace(const Rational &r);

        Rational &mulInPlace(const Rational &r);

        Rational &divInPlace(const Rational &r);

        Rational add(const Rational &r) const;

        Rational sub(const Rational &r) const;

        Rational mul(const Rational &r) const;

        Rational div(const Rational &r) const;

        void print(std::ostream &os) const;
};

inline std::ostream &operator << (std::ostream &os, const Rational &r){
    r.print(os);
    return os;
}

#endif

//4.1.2: RATIONAL.CPP

#include "rational.h"
#include "rational_exception.h"
#include "gcd.h"

void normalize(int &num, int &denom){
    int g = gcd(num, denom);
    num /= g; denom /= g;
}

Rational::Rational(int num, int denom){
    if(denom == 0) throw RationalException("Denominator cannot be 0");
    normalize(num, denom);
    Rational::num = num;
    Rational::denom = denom;
}

int Rational::getNumerator() const { return num; }
int Rational::getDenominator() const { return denom; }

Rational Rational::neg() const { return Rational(num * -1, denom); }
Rational Rational::inv() const { return Rational(denom, num); }

bool Rational::equals(const Rational &r) const { return this->compareTo(r) == 0; }

int Rational::compareTo(const Rational &r) const{
    int lhs = num * r.getDenominator();
    int rhs = denom * r.getNumerator();
    return lhs < rhs ? -1 : (lhs > rhs ? 1 : 0);
}

Rational &Rational::addInPlace(const Rational &r){
    int commonDenom = denom * r.getDenominator();
    int newNum1 = num * r.getDenominator();
    int newNum2 = r.getNumerator() * denom;
    num = newNum1 + newNum2;
    denom = commonDenom;
    normalize(num, denom);
    return *this;
}

Rational &Rational::subInPlace(const Rational &r) { return addInPlace(r.neg()); }

Rational &Rational::mulInPlace(const Rational &r){
    num *= r.getNumerator();
    denom *= r.getDenominator();
    normalize(num, denom);
    return *this;
}

Rational &Rational::divInPlace(const Rational &r) { return mulInPlace(r.inv()); }

Rational Rational::add(const Rational &r) const{ 
    Rational newR(num, denom);
    return newR.addInPlace(r);
}

Rational Rational::sub(const Rational &r) const{
    Rational newR(num, denom);
    return newR.subInPlace(r);
}

Rational Rational::mul(const Rational &r) const{
    Rational newR(num, denom);
    return newR.mulInPlace(r);
}

Rational Rational::div(const Rational &r) const{
    Rational newR(num, denom);
    return newR.divInPlace(r);
}

void Rational::print(std::ostream &os) const{
    if(denom == 1) os << num;
    else os << num << "/" << denom;
}

//4.2: STUDENT.H

#include <string>
#include <vector>
#include "course.h"
#ifndef LAB4_2_STUDENT_H
#define LAB4_2_STUDENT_H

class Student{
public:
    Student(std::string str, int id, std::vector<Course> courses) : name(str), id(id), courses(courses){}
    std::string getName() const;
    int getId() const;
    std::vector<Course> getCourses() const;
    void print(std::ostream &os) const;
    double getGPA() const ;
private:
    std::string name;
    int id;
    std::vector<Course> courses;
};

inline std::ostream &operator <<(std::ostream &os, const Student &s){s.print(os);return os;}
#endif 

//COURSE.H

#ifndef LAB4_2_COURSE_H
#define LAB4_2_COURSE_H
#include <iostream>

class Course{
private:
    int code;
    int credits;
    char grade;
public:
    Course(int code, int cred, char grade) : code(code), credits(cred), grade(grade){}
    int getCode() const {return code;}
    int getCredits() const {return credits;}
    char getGrade() const {return grade;}
    void print(std::ostream &os) const{
        os << "--- " << code << " (" << credits << " credits): " << grade;
    }
};

inline std::ostream &operator <<(std::ostream &os, const Course &course) {course.print(os); return os;}

#endif

//STUDENT.CPP

#include "student.h"
#include "course.h"
#include <vector>

//int Student::nextId=1000;

std::string Student::getName() const {
    return name;
}

int Student::getId() const {
    return id;
}

std::vector<Course> Student::getCourses() const {
    return courses;
}

void Student::print(std::ostream &os) const {
    os << id <<" " << name << ": " << getGPA() << std::endl;
    bool lastTime=false;
    for(int i=0;i<courses.size();i++) {
        os << courses[i];
        lastTime=(i==courses.size()-1);
        if(!lastTime)
            os << std::endl;
    }
}

double Student::getGPA() const {
    double totalCredits=0.0;
    double weightedGrade=0.0;
    for(Course c: courses){
        totalCredits+=c.getCredits();
        weightedGrade+=(4-(toupper(c.getGrade())-'A'))*c.getCredits();
    }
    return weightedGrade/totalCredits;
}

//APP.CPP

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <fstream>

#include "student.h"

using namespace std;

void load(string fName,vector<Student> &students);
void print(vector<Student> students);
bool compare(const Student &s1,const Student &s2);

int main(){
    try {
        vector<Student> students;
        load("students.data", students);
        sort(students.begin(), students.end(), compare);
        print(students);
        cout << endl << students.size() << " records processed";
        return 0;
    } catch (string message) {
        cout<<message;
        exit(1);
    }
}

void load(string fName, vector<Student> &students){
    ifstream ifs(fName);
    if(!ifs)
        throw string ("Input file " + fName + " not found");

    string name;
    int id;
    int course;
    int credits;
    char grade;
    ifs >> id;
    while (ifs) {
        ifs >> name;
        ifs>>course;
        ifs>>credits;
        ifs>>grade;
        Course c(course, credits, grade);
        vector<Course> courses;
        courses.push_back(c);
        ifs>>course;
        while (course>0){
            ifs>>credits;
            ifs>>grade;
            Course c(course, credits, grade);
            courses.push_back(c);
            ifs>>course;
        }
        Student s(name,id,courses);
        students.push_back(s);
        ifs >> id;
    }
    ifs.close();
}

void print(const vector<Student> students){
    for(Student s: students)
        cout<<s<<endl;
}

bool compare(const Student &s1, const Student &s2){
    return s1.getGPA() > s2.getGPA();
}

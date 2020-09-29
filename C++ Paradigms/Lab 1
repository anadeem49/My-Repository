#include <iostream>
 
using namespace std;
 
int main() {
      cout << "+----------------------+\n";
      cout << "| Hello from CISC 3142 |\n";
      cout << "+----------------------+\n";
      return 0;
}

/*<-------------------------------------->*/

#include <iostream> 
#include <iomanip>
#include <fstream>
using namespace std;

int main() {
    try{
    	int sum = 0; int ID = 1001; string names[5]; 
        const int MAX = 50; int ids[5]; 
        ifstream in("names.data");
        if (!in.good()) throw string("Cannot open names.data");
        
        ofstream out("results.data");
        if (!out) throw string("Cannot open results.data");

        int count = 0, initial_id = 1001;
        while (in >> names[count]){
            ids[count] = initial_id;
        	initial_id++;
            count++;
            if (count >= MAX){
            	cout << "*** Exception *** array capacity exceeded" << endl;
            	exit(1);
        	}
        }
    	cout << count << " records processed" << endl;
    	int n = sizeof(names) / sizeof(names[0]);
    	if (n >= MAX){
    		throw string("*** Exception *** array capacity exceeded"); 
        	exit(1);
    	}
    	for (int i = 0; i < n; i++){
    		for (int j = i + 1; j < n; j++){
        		if (names[i] > names[j]){
                	//swap names
                	string temp = names[i];
                	names[i] = names[j];
                	names[j] = temp;
                	//swap ids
                	int t = ids[i];
                	ids[i] = ids[j];
                	ids[j] = t;
            	}
        	}
    	}
    	for (int i = 0; i < n; i++){
    		ID++;
        	out << names[i] << " " << ids[i] << endl;
    	}
    }
    catch(string message) {
        cout << message << endl;
        exit(1);
    }
    return 0;  
}

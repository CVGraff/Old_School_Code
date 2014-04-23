#include "utility.h"
#include "List.h"
#include "main.h"

int main(){
   clock_t start, finish;
   double elapsed_time;

   bool exit_now = false;
   List<Personal_record> record_list;

   string user_input;

   while(!exit_now){
      cout << endl;
      cout << "***********************" << endl;
      cout << "Menu:" << endl;
      cout << "1. Import List from File" << endl;
      cout << "2. Display List" << endl;
      cout << "3. Search List" << endl;
      cout << "x. Exit" << endl;
      cout << "***********************" << endl;

      getline(cin, user_input);

      if(user_input == "1"){
         string input;
         cout << endl << "Enter Data File Name:" << endl;
         getline(cin, input);
         ifstream insertion_file;
         insertion_file.open(input.c_str());
         if(!insertion_file.fail()){
            record_list.clear();

            while(!insertion_file.fail() && !insertion_file.eof()){
               Personal_record input_rec;
               string code_string;
               getline(insertion_file, input_rec.last_name);
               getline(insertion_file, input_rec.first_name);
               getline(insertion_file, code_string);
               input_rec.code = string_to_int(code_string);


               // write code to implement Requirement 1

            }
         } else
            cout << "Invalid file name." << endl;
      }
      else if(user_input == "2"){

      

      // write code to implement Requirement 2

      
      
      }
      else if(user_input == "3"){
         string search_fist_name, search_last_name;
         cout << endl;
         cout << "Enter the last name to search:" << endl;
         getline(cin, search_last_name);
         cout << endl;
         cout << "Enter the first name to search:" << endl;
         getline(cin, search_fist_name);
         start = clock();



         // write code to implement Requirement 3





         finish = clock();
         elapsed_time = (double)(finish - start) / CLOCKS_PER_SEC;
         cout << endl << "Time: " << elapsed_time << " seconds" << endl << endl;
      } 
      else if(user_input == "x")
         exit_now = true;
   }
}


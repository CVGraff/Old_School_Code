// p01.cpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <iomanip>
#include <math.h>
#include <string.h>
using namespace std;

struct CommandLineException
{
  CommandLineException (int max, int actual)
  {
    cout << endl << "Too many command line arguements." << endl;
    cout << "A maximum of " << max << " arguements are permitted." << endl;
    cout << actual << " arguements were entered." << endl;
  }
};

struct FileException
{
  FileException (string filename)
  {
    cout << endl << "File " << filename << " could not be opened or doesn't exist" << endl;
  }
};


void aprint(ostream& o, int answer)
{
  o << setw(4) << answer;
}

void sprint(ostream& o, string thing)
{
  o << setw(4) << thing;
}

void Run(ostream& o)
{
  int par[4] = {0, 0, 1, 1};
  int qar[4] = {0, 1, 0, 1};

  o << endl;
  string row1[7] = {"p", "q", "and", "or", "xor", "->", "<->"};
  int row2[7];
  int row3[7];
  int row4[7];
  int row5[7];


  for(int x=0;x<7;++x)
    sprint(o, row1[x]);
  o << endl;

  row2[0]=par[0];
  row3[0]=par[1];
  row4[0]=par[2];
  row5[0]=par[3];

  row2[1]=qar[0];
  row3[1]=qar[1];
  row4[1]=qar[2];
  row5[1]=qar[3];
  for(int y=0;y<4;++y)
  {
    if(y==0)
    {
      if(par[y] && qar[y])
        row2[2]=1;
      else
        row2[2]=0;
    }
    if(y==1)
    {
      if(par[y] && qar[y])
        row3[2]=1;
      else
        row3[2]=0;
    }
    if(y==3)
    {
      if(par[y] && qar[y])
        row4[2]=1;
      else
        row4[2]=0;
    }
    if(y==4)
    {
      if(par[y] && qar[y])
        row5[2]=1;
      else
        row5[2]=0;
    }

  }
cout << setw(4) << row2[2] << row3[2] << row4[2] << row5[4];
  for(int y=0;y<4;++y)
  {
  if(y==0)
    {
      if(par[y] || qar[y])
        row2[3]=1;
      else
        row2[3]=0;
    }
    if(y==1)
    {
      if(par[y] || qar[y])
        row3[3]=1;
      else
        row3[3]=0;
    }
    if(y==3)
    {
      if(par[y] || qar[y])
        row4[3]=1;
      else
        row4[3]=0;
    }
    if(y==4)
    {
      if(par[y] || qar[y])
        row5[3]=1;
      else
        row5[3]=0;
    }
  }
  for(int y=0;y<4;++y)
  {
    if(y==0)
    {
      if(par[y] xor qar[y])
        row2[4]=1;
      else
        row2[4]=0;
    }
    if(y==1)

    {
      if(par[y] xor qar[y])
        row3[4]=1;
      else
        row3[4]=0;
    }
    if(y==3)
    {
      if(par[y] xor qar[y])
        row4[4]=1;
      else
        row4[4]=0;
    }
    if(y==4)
    {
      if(par[y] xor qar[y])
        row5[4]=1;
      else
        row5[4]=0;
    }
  }
  for(int y=0;y<4;++y)
  {
    if(y==0)
    {
      if(par[y])
        row2[5]=qar[y];
      else
        row2[5]=1;
    }
    if(y==1)
    {
      if(par[y])
        row3[5]=qar[y];
      else
        row3[5]=1;
    }
    if(y==3)
    {
      if(par[y])
        row4[5]=qar[y];
      else

        row4[5]=qar[y];
      else
        row4[5]=1;
    }
    if(y==4)
    {
      if(par[y])
        row5[5]=qar[y];
      else
        row5[5]=1;
    }
  }
  for(int y=0;y<4;++y)
  {
    if(y==0)
    {
      if(par[y] == qar[y])
        row2[6]=1;
      else
        row2[6]=0;
    }
    if(y==1)
    {
      if(par[y] == qar[y])
        row3[6]=1;
      else
        row3[6]=0;
    }
    if(y==3)
    {
      if(par[y] == qar[y])
        row4[6]=1;
      else
        row4[6]=0;
    }
    if(y==4)
    {
      if(par[y] == qar[y])
        row5[6]=1;
      else
        row5[6]=0;
    }
  }

cout << "made it" << endl;
  for(int x;x<7;++x){
    aprint(o, row2[x]);
cout << row2[x];
aprint(cout, row2[x]);}
  o << endl;
  for(int x;x<7;++x){
    aprint(o, row3[x]);
aprint(cout, row3[x]);}
  o << endl;
  for(int x;x<7;++x){
    aprint(o, row4[x]);
aprint(cout, row4[x]);}
  o << endl;
cout << "printed row4" << endl;
  for(int x;x<7;++x){
    aprint(o, row5[x]);
aprint(cout, row5[x]);}
  o << endl;
cout << "printed row5" << endl;
}

int main()
{
  try
    {
//      char oFileName[255];
//      "o01.dat" >> oFileName;
      ofstream o(/*oFileName*/"o01.dat");
        if (!o)
          throw FileException(/*oFileName*/"o01.dat");
        Run(o);
cout << "finished running" << endl;
        o.close();
    }
  catch (...)
  {
    cout <<"Program terminated." <<endl;
    exit(EXIT_FAILURE);
  }

  return 0;
}


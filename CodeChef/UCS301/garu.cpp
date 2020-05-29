#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;
int count=0;
void rowwise(int n,int i,vector<int>inc[])
{
    int j,k,min,index;
    for(k=0;k<n;k++)
    {
        min=inc[i][k];
        index=i;
        for(j=i;j<n;j++)
        {
            if(inc[j][k]<min)
            {min=inc[j][k];
            index=j;
            }
        }
        if(index!=i)
        {
            swap(inc[i][k],inc[index][k]);
            ::count++;
        }
    }
    
}
void columnwise(int n,int i,vector<int>inc[])
{
    int j,k,min,index;
    for(k=0;k<n;k++)
    {
        min=inc[k][i];
        index=i;
        for(j=i;j<n;j++)
        {
            if(inc[k][j]<min)
            {min=inc[k][j];
            index=j;
            }
        }
        if(index!=i)
        {
            swap(inc[k][i],inc[k][index]);
            ::count++;
        }
    }
}
int main() {
    int n,i,j,data;
    cin>>n;
   vector<int>inc[n];
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            cin>>data;
            inc[i].push_back(data);
        }
    }
    for(i=0;i<n;i++)
    {
        rowwise(n,i,inc);
        columnwise(n,i,inc);
    }
    cout<<::count<<endl;
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            cout<<inc[i][j]<<" ";
        }
    }
}

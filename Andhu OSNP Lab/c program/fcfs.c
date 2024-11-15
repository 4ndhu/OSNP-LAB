#include<stdio.h>
void findWaitingTime(int processes[], int n,int bt[], int wt[],int at[])
{
    wt[0] = 0;  //The waiting time for the first process is 0 since it does not have to wait.
    for (int  i = 1; i < n ; i++ )
        wt[i] =  bt[i-1] + wt[i-1];  //The waiting time of process i is equal to the burst time of the previous process plus the waiting time of the previous process.
        for(int  i = 1; i < n ; i++ ){
        //wt[i]-=at[i];
        wt[i] = wt[i]-at[i];
        }
}
/* 
    processes[] :      Array of process IDs.
	n    : 		Total number of processes.
	bt[] : 		Burst time array (time each process needs for execution).
	wt[] : 	Waiting time array to store the calculated waiting times.
	at[] : 	Arrival time array. 
*/

void findTurnAroundTime( int processes[], int n,int bt[], int wt[], int tat[])
{
    for (int  i = 0; i < n ; i++)
        tat[i] = bt[i] + wt[i];
}
void findavgTime( int processes[], int n, int bt[],int arriving_time[])
{
    int wt[n], tat[n], total_wt = 0, total_tat = 0;
    
    findWaitingTime(processes, n, bt, wt,arriving_time);
    findTurnAroundTime(processes, n, bt, wt, tat);
    printf("Processes  Arriving-Time   Burst-time   Waiting-time   Turn-around-time\n");
    for (int  i=0; i<n; i++)
    {
        total_wt = total_wt + wt[i];
        total_tat = total_tat + tat[i];
        printf("   %d ",processes[i]);
        printf("           %d ", arriving_time[i]);
        printf("           %d ", bt[i] );
        printf("            %d",wt[i]);
        printf("             %d\n",tat[i] );
    }
    float s=(float)total_wt / (float)n;
    float t=(float)total_tat / (float)n;
    printf("Average waiting time = %f",s);
    printf("\n");
    printf("Average turn around time = %f ",t);
}
int main()
{
    int processes[20],burst_time[20],arriving_time[20],nop;
    printf("Enter number of processes:");
    scanf("%d",&nop);
    printf("Enter %d process number :",nop);
    for(int i=0;i<nop;i++)
    {
    	scanf("%d",&processes[i]);
    }
    printf("Enter %d Arriving Time:",nop);
    for(int i=0;i<nop;i++)
    {
    	scanf("%d",&arriving_time[i]);
    }
    printf("Enter %d burst_time:",nop);
    for(int i=0;i<nop;i++)
    {
   	 scanf("%d",&burst_time[i]);
    }
     findavgTime(processes, nop,  burst_time, arriving_time);
    return 0;
}

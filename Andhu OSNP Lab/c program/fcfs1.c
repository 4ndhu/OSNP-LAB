#include<stdio.h>
int main(){
	int process[20],burst_time[20],arriving_time[20],nop;
	printf("enter the number of process:");
	scanf("%d" , &nop);
	
	printf("enter %d process number :",nop);
	for(int i=0;i<nop;i++){
		scanf("%d" ,&process[i]);
	}
	printf("enter %d burst time :",nop);
	for(int i=0;i<nop;i++){
		scanf("%d" ,&burst_time[i]);
	}
	printf("enter %d Arriving time :",nop);
	for(int i=0;i<nop;i++){
		scanf("%d" ,&arriving_time[i]);
	}
	findavgTime(process, nop,  burst_time, at);
   return 0;
}
void findwaitingtime( int process[],int at[],int bt[],int wt[],int n){
	wt[0]=0;
	for ( int i=0;i<n; i++){
		wt[i]=bt[i-1]+wt[i-1];
		
		for(int i=1;i<n;i++){
		 wt[i]=wt[i]-at[i] ;
		}
	}
}
void findTurnAroundtime ( int process[],int tat[],int n,int bt[] ,int wt[]) {
	for(int i=0;i<n;i++){
		tat[i]=bt[i]+wt[i];
	}
}
void findAvgtime(int process[],int n ,int bt[],int at[]
){
	int wt[n] ,tat[n] ,total_tat =0,total_wt=0;
	findwaitingtime(process,bt,wt,n,at);
	findTurnAroundtime (process, n,bt,wt,tat);
	printf("Processes  Arriving-Time   Burst-time   Waiting-time   Turn-around-time\n");
	for(int i=0;i<n;i++){
		total_wt=total_wt+wt[i];
		total_tat+=tat[i];
		printf("   %d ",process[i]);
		printf("           %d ", at[i]);
		printf("           %d ", bt[i] );
		printf("            %d",wt[i]);
		printf("             %d\n",tat[i] );
  	  }
  	float  avgwt =(float) total_wt /(float)n;
  	float avgtat =(float)total_tat /(float)n;
  	printf("Average waiting time = %f",avgwt);
	    printf("\n");
	    printf("Average turn around time = %f ",avgtat);
 }
	
	
	





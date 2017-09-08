
class Bowler
{
String name;
double overs;
double balls;
int runsInAnOver;
int totalRunsGiven;
int wickets;
double economyRate;
int maidens ;
int lastOverBowled ;//attribute to later check whether a bowler is bowling consecutive overs and to prevent this

public Bowler(String pName)
{ 
   this.name = pName ;
   lastOverBowled = 0 ;
}
public void increase(int n)
{
this.totalRunsGiven = this.totalRunsGiven+ n ;
this.balls++ ;
if(this.balls%6==0)
{
this.overs=this.balls/6;
}
else //if overs is not a whole number, then make it a decimal not according to decimal system but cricket system
{
this.overs=(int)(this.balls/6)+((this.balls%6)/10) ;
}

}
public void increaseWicket()
{
this.wickets++;

}
//function to check whether a bowler has bowled the previous over 
public boolean check(int n)
{
    if ((lastOverBowled != (n-1)))
    {
        return true ;
     }  
    else
    return false ;
    
}

//function to print the analysis of the bowler
public void printBowlerAnalysis()
{ this.economyRate = (this.totalRunsGiven/this.balls)*6 ;

System.out.println("OVERS    RUNS    WICKETS    ECONOMY");
System.out.println(this.overs+"       "+this.totalRunsGiven+"      "+this.wickets+"         "+this.economyRate);

}
}
class Batsman
{

int runs;
int ballsFaced = 0;
double strikeRate;
String name;
 

public Batsman(String pName)
{

this.name= pName;

}

//function to print the analysis of the batsman
public void printBatsmanAnalysis()
{
    if(this.ballsFaced != 1)
{
    this.strikeRate = (this.runs*100)/this.ballsFaced ;
    System.out.println(this.name+" has scored "+ this.runs+" of "+this.ballsFaced+" balls at a strike rate of " + this.strikeRate + ".");
}
else
{
    System.out.println("Its a duck! " + this.name + " is out!!");
}

}


public void increaseRuns(int ballScore)
{
 this.runs = this.runs + ballScore;
 this.ballsFaced++;
}
public void outdata(String bowlerName)
{
System.out.println(this.name+" has been clean bowled by "+ bowlerName);
}

}

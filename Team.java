
import java.io.* ;
class Team
{

String teamName;
Batsman[] players; // array of batsman objects
Bowler[] bowlers;  //array of bowler objects
String teamText;   //name of text file of the team
int wicketsFallen  ; 
int inningsScore ;
int balls = 0 ;
Batsman striker ;
Batsman nonStriker ;
Batsman temp = new Batsman("") ;//to change the strike
int overs ;

//function to compute the team
public void computeArray()
throws Exception
{
 this.players = new Batsman[11];
 String line;


FileReader fr =new FileReader(this.teamText);
BufferedReader br=new BufferedReader(fr);
this.teamName= br.readLine();
line = br.readLine() ;


for(int i = 0 ; i < 11 ; i++)

{

line = br.readLine();
players[i] = new Batsman(line) ;


}

striker = players[0] ;
nonStriker = players[1] ;


this.bowlers = new Bowler[5] ;
int j,k  ;
//to populate the bowler array
for(j = 6 , k = 0 ; j <= 10 ; j++, k++)
{
    bowlers[k] = new Bowler(players[j].name) ;
}
}

//function to print the players of the team in playing order
public void printTeam()
{
    System.out.println(this.teamName);
    
    for(int i = 0 ; i <= 10 ; i++)
    {
        System.out.println(players[i].name);
    }
    
}
//function to bring new batsman to crease when wicket falls
public void wicketFell()
{ this.wicketsFallen++ ;
    
    if(wicketsFallen != 10)
    {striker = nonStriker ;
    nonStriker = players[wicketsFallen + 1] ;
    System.out.println( nonStriker.name + " has come to the field. ") ;
    }
    else
    {
        return;
    }
}

public void changeStrike()
{
    
    temp = striker ;
    striker = nonStriker;
    nonStriker = temp ;
    System.out.println("The strike has changed to " + striker.name) ;
}

//function to print statistics of top 3 batsman at the end of the game
public void Top3Bat(Team t)
{
 sortBat(players);
 System.out.println("Top batsman in today's match from "+t.teamName+":");
 for(int i=0;i<3;i++)
 {
   if(players[i].runs>0)
   System.out.println(players[i].name+":"+players[i].runs);
}
}
//function to print the statistics of the top 3 bowlers at the end of the game
public void Top3Bowl(Team t)
{
    sortBowl(bowlers);
    System.out.println("Top bowlers in today's match from "+t.teamName+":");
    for(int i=0;i<3;i++)
    {
        if(bowlers[i].overs>0)
        {
        System.out.println(bowlers[i].name+":"+bowlers[i].wickets+"-"+bowlers[i].totalRunsGiven);
    }
}  
}
//function to sort batsman objects in descending order of their runs
public static void sortBat(Batsman[] arr)
{
    int i,j ;
    for(i=0 ; i < (arr.length - 1) ; i++)
    {
        int noOfComparisons = arr.length - 1 - i ;
        int index = 0 ;
        for(j = 0 ; j < noOfComparisons ; j++)
        {
if(arr[index].runs > arr[j+1].runs)
{
    index = j +1 ;
}
}


Batsman temp = arr[index] ;
arr[index] = arr[arr.length - 1 - i] ;
arr[arr.length-1-i] = temp ;
}
}

//function to sort bowler objects in order of best to worst performance
public static void sortBowl(Bowler[] arr)
{
    int i,j ;
    for(i=0 ; i < (arr.length - 1) ; i++)
    {
        int noOfComparisons = arr.length - 1 - i ;
        int index = 0 ;
        for(j = 0 ; j < noOfComparisons ; j++)
        {
if(arr[index].wickets > arr[j+1].wickets)
{
    index = j +1 ;
}
else if(arr[index].wickets == arr[j+1].wickets)
{
    if(arr[index].totalRunsGiven < arr[j+1].totalRunsGiven)
    {
        index = j+1 ;
    }
}


Bowler temp = arr[index] ;
arr[index] = arr[arr.length - 1 - i] ;
arr[arr.length-1-i] = temp ;
}
}
}
}
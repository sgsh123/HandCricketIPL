import java.util.*;
import java.io.*;
class IPL06
{

public static void main(String[] args)

throws Exception

{


displayTeams();

Scanner sc=new Scanner(System.in);
System.out.print("Choose your team:") ;
char ch1 = sc.nextLine().toUpperCase().charAt(0);

Team teamUser = new Team() ;

switch(ch1)
{
case 'B':
 teamUser.teamText="RCB.txt";
 System.out.println("Your team is Royal Challengers Bangalore");
 break;

case 'M':
 teamUser.teamText="MI.txt";
 System.out.println("Your team is Mumbai Indians");
 break;

case 'R':
 teamUser.teamText="RR.txt";
 System.out.println("Your team is Rajasthan Royals");
 break;

case 'K':
 teamUser.teamText="KKR.txt";
 System.out.println("Your team is Kolkata Knight Riders");
 break;

case 'D':
teamUser.teamText="DD.txt";
System.out.println("Your team is Delhi Daredevils");
break;

case 'C':
teamUser.teamText="CSK.txt";
System.out.println("Your team is Chennai Super Kings");
break;

case 'P':
teamUser.teamText="KXIP.txt";
System.out.println("Your team is Kings XI Punjab");
break;

case 'W':
teamUser.teamText="PWI.txt";
System.out.println("Your team is Pune Warriors");
break;

case 'H':
teamUser.teamText="SH.txt";
System.out.println("Your team is Sunrisers Hyderabad");
break;

default:
ch1='D';
System.out.println("Incorrect entry,you get the computers choice, Delhi Daredevils.");
teamUser.teamText="DD.txt";
break;
}


System.out.print("Choose your opponent:") ;
char ch2 = sc.nextLine().toUpperCase().charAt(0);
//the two teams cannot be the same
if(ch1==ch2)
{
 do
{
    System.out.println("You can't chose the same team as yourself") ;
    System.out.print("Choose your opponent:") ;
    ch2 = sc.nextLine().toUpperCase().charAt(0);
}while(ch1==ch2);
}
Team teamComp = new Team() ;




switch(ch2)
{
case 'B':
teamComp.teamText="RCB.txt";
System.out.println("The computer's team is Royal Challengers Bangalore");
break;

case 'M':
teamComp.teamText="MI.txt";
System.out.println("The computer's team is Mumbai Indians ");
break;

case 'R':
teamComp.teamText="RR.txt";
System.out.println("The computer's team is Rajasthan Royals");
break;

case 'K':
teamComp.teamText="KKR.txt";
System.out.println("The computer's team is Kolkata Knight Riders ");
break;

case 'D':
teamComp.teamText="DD.txt";
System.out.println("The computer's team is Delhi Daredevils");
break;

case 'C':
teamComp.teamText="CSK.txt";
System.out.println("The computer's team is Chennai Super Kings");
break;

case 'P':
teamComp.teamText="KXIP.txt";
System.out.println("The computer's team is Kings XI Punjab");
break;

case 'W':
teamComp.teamText="PWI.txt";
System.out.println("The computer's team is Pune Warriors India");
break;

case 'H':
teamComp.teamText="SH.txt";
System.out.println("The computer's team is Sunrisers Hyderabad");
break;

default:
if(ch1 != 'M')
{System.out.println("Incorrect entry, the computer chooses its team - Mumbai Indians ");
teamComp.teamText="MI.txt";
}
else
System.out.println("Incorrect entry, the computer chooses its team  - Royal Challengers Banglore ");
teamComp.teamText="RCB.txt";
break;
}

System.out.print("Choose number of overs (between 1-20):") ;
int overs = sc.nextInt() ;
if((overs<1)||(overs>20))
{
    do
    {
        System.out.println("Invalid");
        System.out.print("Choose number of overs (between 1-20):") ;
        overs = sc.nextInt() ;
        
    } while((overs<1)||(overs>20)) ;
}
System.out.println("The match will comprise "+overs+" overs for each team") ;

teamUser.overs = overs; 
teamComp.overs = overs;

teamUser.computeArray() ;
teamComp.computeArray();

System.out.println() ;
System.out.println("YOUR TEAM: ");
System.out.println();
teamUser.printTeam();
System.out.println() ;
System.out.println("THE COMPUTER'S TEAM: ");
System.out.println();
teamComp.printTeam() ;

//invoke function to call the toss
toss(overs, teamUser , teamComp);


}


//to provide a key to the users on what to type to chose which team
public static void displayTeams()
{
System.out.println("B for Royal Challengers Banglore");
System.out.println("M for Mumbai Indians");
System.out.println("R for Rajasthan Royals");
System.out.println("C for Chennai Superkings");
System.out.println("P for Kings XI Punjab");
System.out.println("H for Sunrisers Hyderabad");
System.out.println("D for Delhi Daredevils");
System.out.println("W for Pune Warriors India");
System.out.println("K for Kolkata Knight Riders");


}

//function to decide who will win the toss and accordingly call the appropriate innings
public static void toss(int n, Team one, Team two)
throws Exception
{
Scanner sc=new Scanner(System.in);
System.out.print("Call heads('H')or tails('T'):");
char ch=sc.nextLine().toUpperCase().charAt(0);
//if incorrect entry is entered
if((ch!='H')&&(ch!='T'))
{
    do
    {
        System.out.println("Invalid");
        System.out.print("Call heads('H')or tails('T'):");
        ch=sc.nextLine().toUpperCase().charAt(0);
        
    }while((ch!='H')&&(ch!='T')) ;
}
char c=' ';
int innings = 1 ;

int r=(int)(Math.random()*6+1);//to generate a random number between 1 and 6
if(r%2==0)
{
 c='H';
}
else
{
 c='T';
}


if(ch==c)
{
   System.out.print("You win the toss! Choose batting('B') or fielding('F'):");
   char choice=sc.nextLine().toUpperCase().charAt(0);
   if((choice!='B')&&(choice!='F'))
   {
       do
       { 
           System.out.println("Invalid entry");
           System.out.print("Choose batting('B') or fielding('F'):");
           choice=sc.nextLine().toUpperCase().charAt(0);
           
       }while((choice!='B')&&(choice!='F'));
   }

   if(choice=='B')
    {
     System.out.println("You have won the toss and chosen to bat first.");
      startUserInnings(n, one, two, innings);
      innings++;//counter of innnings to check who is batting first and who will chase
      System.out.println();
      System.out.println();
      startCompInnings(n,two, one, innings) ;
      
      
    }
    else
   {
    System.out.println("You have won the toss and chosen to field first.");
     startCompInnings(n, two, one, innings);
     innings++;//counter of innnings to check who is batting first and who will chase
     System.out.println();
     System.out.println();
     startUserInnings(n, one, two, innings) ;
   }
}
else
{
 int v=(int)(Math.random()*6+1);
 
  if(v%2==0)
  {
   char l='B';
   System.out.println("You have lost the toss.The computer has chosen to bat first.");
   startCompInnings(n, two, one,innings);
   innings++;
   startUserInnings(n, one, two,innings) ;
  }

else
{
    char l='F';
    System.out.println("You have lost the toss.The computer has chosen to field first.");
    startUserInnings(n, one, two, innings);
    innings++;
    startCompInnings(n,two, one, innings) ;
}
}
//to print the top 3 performers of every team
System.out.println() ;
one.Top3Bat(one) ;  
System.out.println() ;
two.Top3Bowl(two) ;
System.out.println() ;
System.out.println() ;
System.out.println() ;
System.out.println() ;

two.Top3Bat(two) ;
System.out.println() ;
one.Top3Bowl(one) ;


}



public static void startUserInnings(int overs,Team a, Team b, int innings)
throws Exception
{

  
    
System.out.println( a.players[0].name + " and " + a.players[1].name + " have come out to bat with " + a.players[0].name + " facing the first ball") ;
a.inningsScore=0;
int i;



for(i=1;i<=overs;i++)
{
a.inningsScore= a.inningsScore+ startUserOver(a,b,innings,i);
int runRate=a.inningsScore/i;
System.out.println("Current run rate:"+runRate);
if(innings == 1)
{
    if(a.wicketsFallen == 10)
{
    
    System.out.println("Final Innings Score is:" + a.inningsScore);
    double requiredRunRate = (double)(a.inningsScore)/(double)(overs) ;
    System.out.println("The required run rate is " + requiredRunRate) ;
    
    System.out.println();
    return ;
}
}


else if(innings == 2)
{
    
    if(a.wicketsFallen == 10)
{
    System.out.println(a.teamName + " has not been able to complete the run chase."); 
  
    System.out.println(a.teamName+" LOSES by " +(b.inningsScore - a.inningsScore )+" runs.");
    return;
}
if(a.inningsScore >= b.inningsScore)
{
    int q =overs*6 - a.balls ;
    double z = (int)(q/6)+((double)(q%6)/(double)(10)) ;
    System.out.println(a.teamName + " has successfully completed the run chase.");
    System.out.println(a.teamName+ " WINS by "+(a.inningsScore - b.inningsScore )+" runs and "+z+" overs");
}
   if(b.inningsScore>a.inningsScore)
   {
   double requiredRunRate=(double)(b.inningsScore-a.inningsScore)/((double)(overs-i)) ;
   System.out.println("The required run rate is : "+requiredRunRate) ;
   }
}
}
  if(innings==1)
  {
  System.out.println("Final Innings Score is:" + a.inningsScore);
  double requiredRunRate = (double)(a.inningsScore)/(double)(overs) ;
  System.out.println("The required run rate is " + requiredRunRate)  ;
 }
 else
 {
     System.out.println("Final Innings Score is:" + a.inningsScore);
     
  }
  System.out.println();
  System.out.println();
 if(innings == 2)
{
    if(a.inningsScore < b.inningsScore)
{   
    
    System.out.println(a.teamName + " has not been able to complete the run chase. ");
    System.out.println(a.teamName + " LOSES by " +(b.inningsScore - a.inningsScore )+" runs.");
}
}
}


  

public static int startUserOver(Team w, Team v, int innings, int currentOver)
throws Exception
{    
    
    
    Bowler currentBowler= generateBowler(v, currentOver);
    System.out.println("This over is going to be bowled by " + currentBowler.name  ) ;
    currentBowler.lastOverBowled = currentOver ;
  
   int overScore=0;
   int currentScore=0;

for(int i = 1;i<=6;i++)
{
int a=askUser();
int c=compRuns();

if(a!=c)
{
switch(a)
{
case 1:
case 2:
case 3:
case 4:
case 6: 
overScore=overScore+a;
w.striker.increaseRuns(a) ;
currentBowler.increase(a) ;
w.balls++ ;
currentScore=overScore+w.inningsScore;
System.out.println("Current score:"+currentScore+"-"+w.wicketsFallen);

if(innings == 2)
{if( (w.inningsScore + overScore)  >= v.inningsScore)
{
    return overScore ;
}
}
break;

default:
System.out.println("Incorrect entry,try again");
i--;
break;
}
 
 if((a==1)||(a==3))
 {
     w.changeStrike();
 }
 
}
else
{
 w.balls++ ;
 currentBowler.increase(0) ;
 w.striker.increaseRuns(0) ;
 currentBowler.increaseWicket() ;
 w.striker.outdata(currentBowler.name);
 currentBowler.printBowlerAnalysis();
 w.striker.printBatsmanAnalysis();
 w.wicketFell();
 currentScore=overScore+w.inningsScore;
 System.out.println("Current Score:"+currentScore+"-"+w.wicketsFallen);
 

}

if(w.wicketsFallen == 10)
{
    System.out.println("All the wickets have fallen") ;
    return overScore ;
}

}
w.changeStrike();
System.out.println("The score of the over is " + overScore) ;

return overScore ;

}





public static void startCompInnings(int overs,Team a, Team b, int innings)
throws Exception
{

    
    
System.out.println( a.players[0].name + " and " + a.players[1].name + " have come out to bat with " + a.players[0].name + " facing the first ball") ;
 a.inningsScore= 0 ;
int i;

for(i=1;i<=overs;i++)
{
a.inningsScore= a.inningsScore+ startCompOver(a,b,innings, i);
int runRate=a.inningsScore/i;
System.out.println("Currrent Run Rate:"+runRate);
if(innings == 1)
{
    if(a.wicketsFallen == 10)
{
    System.out.println("Final Innings Score:" + a.inningsScore) ;
    
    double requiredRunRate = (double)(a.inningsScore)/(double)(overs) ;
    System.out.println("The required run rate is " + requiredRunRate) ;
    System.out.println();
    
    
    return;
}
}

else if(innings == 2)
{
    
    if(a.wicketsFallen == 10)
    {
    System.out.println(a.teamName + " has not been able to complete the run chase. " );
    System.out.println(a.teamName + " LOSES by "+(b.inningsScore - a.inningsScore )+" runs.");
    return;
    }
  if(a.inningsScore >= b.inningsScore)
  {
    int q =overs*6 - a.balls ;
    double z = (int)(q/6)+((double)(q%6)/(double)(10)) ;
    System.out.println(a.teamName + " has successfully completed the run chase.");
    System.out.println(a.teamName +" WINS by " +(10 - a.wicketsFallen ) +" wickets and " + z + " overs") ;
    return;
}  
   if(b.inningsScore>a.inningsScore)
   {
   double requiredRunRate=(double)(b.inningsScore-a.inningsScore)/((double)(overs-i));
   System.out.println("The required run rate is:"+requiredRunRate);
   }
}
}
  if(innings==1)
  {
    double requiredRunRate = (double)(a.inningsScore)/(double)(overs) ;
    System.out.println("The required run rate is " + requiredRunRate) ;
   System.out.println("Final Innings Score is:" + a.inningsScore);
 }
else
{
    
    System.out.println("Final Innings Score is:" + a.inningsScore);
}
    
    System.out.println();
    System.out.println();

if(innings == 2)
{
    if(a.inningsScore < b.inningsScore)
{
System.out.println(a.teamName + " has not been able to complete the run chase.");
System.out.println(a.teamName +" LOSES by " +(b.inningsScore - a.inningsScore )+" runs.");
}
}
}



public static int startCompOver(Team w, Team v, int innings, int currentOver)
throws Exception
{    
    
    Bowler currentBowler = askUserBowler(v, currentOver);
    System.out.println("This over is going to be bowled by " + currentBowler.name  ) ;
    currentBowler.lastOverBowled = currentOver ;
  
   int overScore=0;
   int currentScore=0;

for(int i = 1;i<=6;i++)
{
int a=compRuns();
int c=askUser();
if((c>6)||(c<1))
{
 do
{
    System.out.println("Incorrect entry,try again.");
    c=askUser();

}while((c>6)||(c<1));
}
System.out.println("The Computer scores:"+a+" runs");

if(a!=c)
{
    
   switch(c)
   {
       case 1:
       case 2:
       case 3:
       case 4:
       case 6:
       switch(a)
          {
           case 1:
           case 2:
           case 3:
           case 4:
           case 6: 
          
           w.balls++ ;
           overScore=overScore+a;
           w.striker.increaseRuns(a) ;
           currentBowler.increase(a) ;
           currentScore=overScore+w.inningsScore;
           System.out.println("Current score:"+currentScore+"-"+w.wicketsFallen);

           
           if(innings == 2)
           {
               if( (w.inningsScore + overScore) >= v.inningsScore)
             {
              return overScore ;
             }
           }
           break;


           }
 
       break;
       
       default:
        System.out.println("Incorrect entry. Try again") ;
        i-- ;
        break;
    }


   if((a==1)||(a==3))
    {
      w.changeStrike();
    }
 
}

else
{
 
 w.balls++ ;
 currentBowler.increase(0) ;
 w.striker.increaseRuns(0) ;
 currentBowler.increaseWicket();
 w.striker.outdata(currentBowler.name);
 currentBowler.printBowlerAnalysis();
 w.striker.printBatsmanAnalysis() ;
 w.wicketFell();
 currentScore=overScore+w.inningsScore;
 System.out.println("Current score:"+currentScore+"-"+w.wicketsFallen);
}

if(w.wicketsFallen == 10)
{
    System.out.println("All the wickets have fallen") ;
    break ;
}

}

w.changeStrike();
  
System.out.println("The score of the over is " + overScore) ;
return overScore ;

}

//function to generate a random number,which are the runs of the computer to compare with that of the user
public static int compRuns()
{
int runs=(int)(Math.random()*6+1);//to generate a random number between 1 and 6
while(runs==5)
{
runs=(int)(Math.random()*6+1);
}

return runs;

}
//function to ask user to enter runs and to return the runs entered
public static int askUser()
{

Scanner k=new Scanner(System.in);
System.out.print("Enter runs:(1/2/3/4/6)");
int n=k.nextInt();
return n;

}


public static Bowler generateBowler(Team t, int currentOver)

{   Bowler b = new Bowler(" ");
    if(currentOver>1)
    {
    do
    {
     int n=(int)(Math.random()*5);//to generate a random no between 0 and 4 to invoke bowler from created array of bowlers
     b= t.bowlers[n];
     
     
    } while((b.check(currentOver) != true));
   
    return b;
   }
   else
   {
      int n=(int)(Math.random()*5);//to generate a random no between 0 and 4 to invoke bowler from created array of bowlers
       b= t.bowlers[n];
      return b;
    }
}
    
public static Bowler askUserBowler(Team t, int currentOver)
{
     Scanner s=new Scanner(System.in);
     Bowler b = new Bowler(" ") ;
     int i = 0 ;
     if(currentOver > 1)
     {
         do
         { 
         
             if( i > 0)
            { 
                System.out.println( b.name + " has already bowled the previous over.");
            }
            
          System.out.print("Enter bowler#:(1-5)");
          int n = s.nextInt();
          b = t.bowlers[n-1];
          i++;
        

       }while( b.check(currentOver) != true );
       return b ;
     }
    else
    {
    System.out.print("Enter bowler#:(1-5)");
    int n = s.nextInt();
    //if user entry is incorrect
    if((n>5)||(n<1))
    {
        do
        {
         System.out.println("Invalid");
         System.out.print("Enter bowler#:(1-5)");
         n = s.nextInt();
        }while((n>5)||(n<1)) ;
    }
    b=t.bowlers[n-1];
    return b ;
   }

}
}
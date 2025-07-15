
abstract class Interest{

 abstract double cal();

}

class sI extends Interest {
double si,p,n,r;
sI(double pp,double nn,double rr){
p=pp;n=nn;r=rr;
}
double cal(){
si=(p*n*r)/100;
return si;
}

}
class cI extends Interest {
double ci,p,n,r;
cI(double pp,double nn,double rr){
p=pp;n=nn;r=rr;
}
double cal(){
ci=  p * Math.pow((1 + r / 100), n);
return ci;
}

}

public class calculateInterest{

public static void main(String []args){
 cI CcIi=new cI(25000,5,8.5);
 sI SsIi=new sI(25000,5,9.25);

System.out.println("--------------------------------------------------");
System.out.println("-----------------Calculate Interest---------------");
System.out.println("--------------------------------------------------");
System.out.println();
System.out.printf(" Principle Amount = 25000\n Number of Years = 5 \n Rate of Interest for Simple interest = 9.25%% \n Rate of Interest for Compund interest = 8.5%% \n Simple Interest = %8.2f \n Compound Interest = %8.2f ",SsIi.cal(),CcIi.cal());
}

}
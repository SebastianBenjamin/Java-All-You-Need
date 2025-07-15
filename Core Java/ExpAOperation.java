
class IllegalNumberOfArguments extends Exception{
    public IllegalNumberOfArguments(String message){
        super(message);
    }
}
class InvalidOperatorException extends Exception{
    public InvalidOperatorException(String message){
        super(message);
    }
}
class NegativeResultException extends Exception{
    public NegativeResultException(String message){
        super(message);
    }
}

public class ExpAOperation {

    public static void main(String[] args)throws IllegalNumberOfArguments,InvalidOperatorException,NegativeResultException {
char[] AOs={'+','-','/','*','%'};
double result=0;
boolean booAo=false;
String resultS="";
        if(args.length!=3){
            throw new IllegalNumberOfArguments("Exactly two numbers and a Arthemetic must be provided as arguments, total 3 Arguments. eg: 1 + 2");
        }
       for(int i=0;i<AOs.length;i++){

        if(args[1].charAt(0)==AOs[i]){
            booAo=true;
            double a=Double.valueOf(args[0]);
            double b=Double.valueOf(args[2]);
switch (AOs[i]) {
    case '+':
        result=a+b;
        resultS=a+" + "+b;
        break;
    case '-':
        result=a-b;
        resultS=a+" - "+b;

        break;
    case '/':
        result=a/b;
        resultS=a+" / "+b;

        break;
    case '*':
        result=a*b;
        resultS=a+" * "+b;

        break;
    case '%':
        result=a%b;
        resultS=a+" % "+b;

        break;

    default:
        break;
}
if(result<0){
    throw new NegativeResultException("Result of "+resultS+" is negative that is "+result);
    
}
else{
    System.out.println("Result : "+result);
    
}

      break;  }
     
       }
if(!booAo){
     throw new InvalidOperatorException("' "+args[1].charAt(0)+ " ' is not a Arthmetic Operator");
    }


    }
}

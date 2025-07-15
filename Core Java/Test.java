class VowelException extends Exception{
    public VowelException(String message){
        super(message);
    }
}
class BlankException extends Exception{
    public BlankException(String message){
        super(message);
    }
}
class ExitException extends Exception{
    public ExitException(String message){
        super(message);
    }
}


public class Test {
    public static void main(String[] args) throws VowelException,BlankException,ExitException,ArrayIndexOutOfBoundsException {
        String vowels="aeiou";
        boolean boo=false;
        if(args.length<1||args[0].toLowerCase().charAt(0)==' '){
            throw new BlankException("Blank Character is not accepted");
        }
        else {
            char thing=args[0].toLowerCase().charAt(0);
            for(int i=0;i<vowels.length();i++){
                if(thing==vowels.charAt(i)){
                    boo=true;
                    throw new VowelException("Character ' "+args[0].charAt(0)+" '  is a Vowel");
                }
            }
            if(!boo){
                if(thing=='x'){
                    throw new ExitException("Exiting Program !");
                }
                else{
                System.out.println("\n+--------------------------------------+\n");
                System.out.println("          ' "+args[0].charAt(0)+" ' is a Valid Character");
                System.out.println("\n+--------------------------------------+\n");
            }
        }
    }
    
}
}

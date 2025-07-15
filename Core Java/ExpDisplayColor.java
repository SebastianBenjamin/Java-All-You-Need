class InvalidAlphabetException extends Exception {
    public InvalidAlphabetException(String message) {
        super(message);
    }
}

class InvalidColorException extends Exception {
    public InvalidColorException(String message) {
        super(message);
    }
}

public class ExpDisplayColor {
 public static void main(String[] args) throws InvalidAlphabetException, InvalidColorException {
  if (args.length<1||args.length>1){
    throw new InvalidAlphabetException("minimum 1 character is accepted !");
  }else{
    char c=args[0].toLowerCase().charAt(0);
    DisplayColor(c); }
 }
 public static void DisplayColor(char c) throws InvalidAlphabetException,InvalidColorException{
    String[] Colors = {"Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red"};
    boolean boo=false;

if(Character.isLetter(c)){
for(int i=0;i<Colors.length;i++){
    if(Colors[i].toLowerCase().charAt(0)==c){
        System.out.println("Color : "+Colors[i]);
        boo=false;
        break;
    }
    else{
        boo=true;
    }
}
if(boo){
    throw new InvalidColorException("Alphabet ' "+c+" ' is not a Starting letter of a color in Colors of Rainbow");
}
}
else{
    throw new InvalidAlphabetException("' "+c+" ' is not an Alphabet ");
}
 }
}

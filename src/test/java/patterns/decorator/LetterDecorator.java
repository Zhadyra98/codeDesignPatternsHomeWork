package patterns.decorator;

public abstract class LetterDecorator {
    protected Letter letterToDecorate;
    public LetterDecorator(Letter letterToDecorate){
        this.letterToDecorate=letterToDecorate;
    }
    public void  changeBodyText(){
        letterToDecorate.setBodyText(letterToDecorate.getBodyText());
    }
}

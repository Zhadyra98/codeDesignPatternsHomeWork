package patterns.decorator;

public class InformalLetterDecorator extends LetterDecorator{
    public InformalLetterDecorator(Letter letterToDecorate) {
        super(letterToDecorate);
    }

    @Override
    public void changeBodyText() {
        String bodyText =letterToDecorate.getBodyText()+ " Best wishes, \n Zhadyra";
        letterToDecorate.setBodyText(bodyText);
    }
}


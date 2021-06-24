package patterns.decorator;

import java.awt.*;

public class FormalLetterDecorator extends LetterDecorator{
    public FormalLetterDecorator(Letter letterToDecorate) {
        super(letterToDecorate);
    }

    @Override
    public void changeBodyText() {
        String bodyText =letterToDecorate.getBodyText()+ " Oralkhanova Zhadyra \n email: zhadyra_oralkhanova@epam.com";
        letterToDecorate.setBodyText(bodyText);
    }
}

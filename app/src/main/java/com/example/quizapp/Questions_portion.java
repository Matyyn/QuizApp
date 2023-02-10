package com.example.quizapp;
public class Questions_portion {
    public String myQuestions[]={
            "What is the sum of 11 + 74 + 15?",
            "Who owns Tesla?",
            "Who is the Richest man on Earth?",
            "What is the sum of 72 + 97?",
            "Which planet is called as Red Planet?",
            "When did humans landed on Moon?",
            "Which is the second highest peak in the World?",
            "Which is the No one test team of the World?",
            "Which is the largest country of the World?",
            "What is the modulus of 10 by 3?",
            "Divide 99 by 2?",
            "Where is England located?"
    };
    private String Choices[][] ={
            {"67","87","100","98"},
            {"Elon Musk","Joe Biden","Trump","Bill Gates"},
            {"Zardari","Jeff Bezos","Elon Musk","Bill Gates"},
            {"169","200","90","170"},
            {"Mercury","Jupiter","Mars","Saturn"},
            {"1970","1960","2000","1969"},
            {"Mercury","K2","Nanga Parbat","Mount Everst"},
            {"India","Pakistan","New Zealand","Australia"},
            {"Canada","USA","Australia","Russia"},
            {"0","2","1","10"},
            {"33","8","44.5","99"},
            {"Moon","Ocenia","Asia","Europe"}
    };
    private String[] correctAnswer = {"100","Elon Musk","Jeff Bezos","169","Mars","1969","K2","New Zealand","Russia","1","44.5","Europe"};
    public  String Getquestion(int a){
        String question = myQuestions[a];
        return question;
    }
    public  String Getchoice1(int a){
        String choice = Choices[a][0];
        return choice;
    }

    public  String Getchoice2(int a){
        String choice = Choices[a][1];
        return choice;
    }

    public  String Getchoice3(int a){
        String choice = Choices[a][2];
        return choice;
    }

    public  String Getchoice4(int a){
        String choice = Choices[a][3];
        return choice;
    }
    public String GetCorrectAnswer(int a){
        String answer= correctAnswer[a];
        return answer;
    }
    public void deleteChoice(int n)
    {
        String newQuestions[],  newChoices[][],  newAnswers[];
        newQuestions = new String[myQuestions.length - 1];
        newChoices = new String[Choices.length-1][4];
        newAnswers = new String[correctAnswer.length - 1];

        addElements(myQuestions, newQuestions, n);
        addElements(correctAnswer,newAnswers, n);
        addElements(Choices, newChoices,n);

        Choices = newChoices;
        correctAnswer = newAnswers;
        myQuestions = newQuestions;


    }
    public void addElements(String Questions[], String newQuestions[], int n)
    {
        int j = 0;
        for(int i = 0; i < Questions.length; i++)
        {
            if(i!= n)
                newQuestions[i-j] = Questions[i];
            else
                j++;
        }
    }
    public void addElements(String Choices[][], String newChoices[][], int n)
    {
        int j = 0;
        for(int i = 0; i < Choices.length; i++)
        {
            if(i!= n)
                newChoices[i-j] = Choices[i];
            else
                j++;
        }
    }
    public void reset()
    {
        String newQuestions[]={"Which is the President of Pakistan",
                "Who owns Tesla",
                "Who is the Richest man on Earth",
                "What is the sum of 72 + 97 ",
                "Which planet is called as Red Planet",
                "When did humans landed on Moon",
                "Which is the second highest peak in the World",
                "Which is the No one test team of the World",
                "Which is the largest country of the World",
                "Where does CS means",
                "Divide 99 by 2",
                "Where is England located"
        };
        String newChoices[][] ={
                {"67","87","100","98"},
                {"Elon Musk","Joe Biden","Trump","Bill Gates"},
                {"Zardari","Jeff Bezos","Elon Musk","Bill Gates"},
                {"169","200","90","170"},
                {"Mercury","Jupiter","Mars","Saturn"},
                {"1970","1960","2000","1969"},
                {"Mercury","K2","Nanga Parbat","Mount Everst"},
                {"India","Pakistan","New Zealand","Australia"},
                {"Canada","USA","Australia","Russia"},
                {"0","2","1","10"},
                {"33","8","44.5","99"},
                {"Moon","Ocenia","Asia","Europe"}
        };
        String newAnswers[] = {"100","Elon Musk","Jeff Bezos","169","Mars","1969","K2","New Zealand","Russia","1","44.5","Europe"};

        correctAnswer=newAnswers; Choices = newChoices; myQuestions = newQuestions;
    }
}

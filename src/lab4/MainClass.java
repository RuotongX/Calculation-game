package lab4;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		FileIO fio = new FileIO();
		User user = new User();
		int score = 0;
		UserList userlist = new UserList();
		fio.loaduserdata(userlist);
		int temp = userlist.getuserlist().length;
		boolean exsit;
        int rounds = 10;
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("Hi, please input your name!");
        userInput = scanner.nextLine();
        if(userlist.getuserlist().length==0) {
        	user.setName(userInput);
        	userlist.add(user);
        }
        else {
        for(int i = 0;i<userlist.getuserlist().length;i++) {
        	System.out.println(userlist.getuserlist().length);
        	if(userlist.getuserlist()[i].getName().equals(userInput)) {
        		userlist.remove(i);
        	}
        }
        user.setName(userInput);
    	userlist.add(user);
        QuestionSaveList qsl = new QuestionSaveList();
    
        boolean terminate = false;
        for (int round = 0; round < rounds; ++round) {
            System.out.println("Round " + (round + 1));
            double uAnswer = 0d;
            boolean valid = false;
            boolean generat = true;
            double rAnswer = 0d;
            do {
               GeneratQuestion gq = new GeneratQuestion();
               qsl.setinput(gq.Getquestion());
               if(qsl.AvoidDuplicated() == false) {
            	   generat = false;
               }
               else {
            	   qsl.Add();
            	   rAnswer = gq.rightAnswer();
               }
            } while(generat == false);
            do {
                userInput = scanner.nextLine();
                if (userInput.trim().equals("x")) {
                    terminate = true;
                    break;
                }
                try {
                    uAnswer = Double.parseDouble(userInput.trim());
                    valid = true;
                } catch (NumberFormatException e) {
                    //the exception is caught is the user input is not valid
                    valid = false;
                    System.out.println("The input is invalid, please enter the answer again.");
                }
            } while (!valid);
            if (terminate) {
                break;
            }
            Check check = new Check(uAnswer,rAnswer);
            if (check.row() == true) {
                System.out.println("Answer correct!");
                score += 10;
            } else {
                System.out.println("Sorry, you are wrong.");
                score -= 10;
            }
        }

        System.out.println("You got: " + score);
        user.setScore(score);
        fio.saveuserdata(userlist);
        for(int i = 0;i<qsl.getQuestion().length;i++) {
             System.out.println(qsl.getQuestion()[i]);
           
        }

	}
	}}

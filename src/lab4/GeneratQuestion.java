package lab4;

public class GeneratQuestion {
	double correctResult = 0;
	GeneratNumber gn1 = new GeneratNumber(4);
	GeneratNumber gn2 = new GeneratNumber(100);
	String opStr = "";
	int operator = gn1.gn();
	int num1 = gn2.gn();
	int num2 = gn2.gn();
	public GeneratQuestion() {
		switch (operator) {
		case 0:
			correctResult = num1 + num2;
			opStr = " + ";
			break;
		case 1:
			correctResult = num1 - num2;
			opStr = " - ";
			break;
		case 2:
			correctResult = num1 * num2;
			opStr = " * ";
			break;
		default:
			while (num2 == 0) {
				num2 = gn2.gn();
			}
			correctResult = 1.0 * num1 / num2;
			opStr = " / ";
			break;
		}

		System.out.println(num1 + opStr + num2 + " = ");
	}
	public double rightAnswer() {
		return correctResult;
	}
	public String Getquestion() {
		String question;
		question = num1+opStr+num2;
		return question;
	}
}

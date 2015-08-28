import java.util.Date;
import java.util.Random;

public class ParseAndChangeData {

	public ParseAndChangeData() {

	}

	public static int getAge(String dateOfBirth) {
		int year = Integer.parseInt(dateOfBirth.substring(0, 4));
		int month = Integer.parseInt(dateOfBirth.substring(4, 6));
		int day = Integer.parseInt(dateOfBirth.substring(6, 7));

		Date now = new Date();
		int nowMonth = now.getMonth() + 1;
		int nowYear = now.getYear() + 1900;
		int result = nowYear - year;

		if (month > nowMonth) {
			result--;
		} else if (month == nowMonth) {
			int nowDay = now.getDate();

			if (day > nowDay) {
				result--;
			}
		}
		return result;
	}

	public static String changeDate(String dateOfBirth) {
		Random rand = new Random();
		Date now = new Date();
		String timeOfBirth = "";
		int currentAge = getAge(dateOfBirth.substring(0, 7));
		if (currentAge > 18) {
			// change the date to another date between 19 and 99 years old
			// new year = currentyear - age + random(18)
			int newYear = now.getYear() + 1900 - (rand.nextInt(80) + 19);
			String newYearString = new Integer(newYear).toString();
			// new month = random(12)
			int newMonth = rand.nextInt(12) + 1;
			String newMonthString = new Integer(newMonth).toString();
			if (newMonthString.length() == 1) {
				newMonthString = "0" + newMonthString;
			}
			// new day = random(28)
			int newDay = rand.nextInt(28) + 1;
			String newDayString = new Integer(newDay).toString();
			if (newDayString.length() == 1) {
				newDayString = "0" + newDayString;
			}
			Integer dateOfBirthLength = dateOfBirth.length();
			String newHourString = "";
			String newMinuteString = "";
			String newSecondString = "";
			if (dateOfBirthLength > 8) {
				timeOfBirth = dateOfBirth.substring(8, dateOfBirthLength);
				int newHour = rand.nextInt(23) + 1;
				int newMinute = rand.nextInt(59) + 1;
				int newSecond = rand.nextInt(59) + 1;

				newHourString = new Integer(newHour).toString();
				if (timeOfBirth.length() > 2) {
					newMinuteString = new Integer(newMinute).toString();
				}
				if (timeOfBirth.length() > 4) {
					newSecondString = new Integer(newSecond).toString();
				}

				if (newHourString.length() == 1) {
					newHourString = "0" + newHourString;
				}
				if (newMinuteString.length() == 1) {
					newMinuteString = "0" + newMinuteString;
				}
				if (newSecondString.length() == 1) {
					newSecondString = "0" + newSecondString;
				}
				timeOfBirth = newHourString + newMinuteString + newSecondString;
			}

			else {

				dateOfBirth = "";
			}
			dateOfBirth = newYearString + newMonthString + newDayString + timeOfBirth;
		}

		else

		{
			// change the date to another date between 0 and 18 years
			// new year = currentyear - age + random(18)
			int newYear = now.getYear() + 1900 - rand.nextInt(18) + 1;
			String newYearString = new Integer(newYear).toString();
			// new month = random(12)
			int newMonth = rand.nextInt(12) + 1;
			String newMonthString = new Integer(newMonth).toString();
			if (newMonthString.length() == 1) {
				newMonthString = "0" + newMonthString;
			}
			// new day = random(28)
			int newDay = rand.nextInt(28) + 1;
			String newDayString = new Integer(newDay).toString();
			if (newDayString.length() == 1) {
				newDayString = "0" + newDayString;
			}
			Integer dateOfBirthLength = dateOfBirth.length();

			String newHourString = "";
			String newMinuteString = "";
			String newSecondString = "";
			if (dateOfBirthLength > 8) {
				timeOfBirth = dateOfBirth.substring(8, dateOfBirthLength);
				int newHour = rand.nextInt(23) + 1;
				int newMinute = rand.nextInt(59) + 1;
				int newSecond = rand.nextInt(59) + 1;

				newHourString = new Integer(newHour).toString();
				if (timeOfBirth.length() > 2) {
					newMinuteString = new Integer(newMinute).toString();
				}
				if (timeOfBirth.length() > 4) {
					newSecondString = new Integer(newSecond).toString();
				}

				if (newHourString.length() == 1) {
					newHourString = "0" + newHourString;
				}
				if (newMinuteString.length() == 1) {
					newMinuteString = "0" + newMinuteString;
				}
				if (newSecondString.length() == 1) {
					newSecondString = "0" + newSecondString;
				}
				timeOfBirth = newHourString + newMinuteString + newSecondString;

			}
			dateOfBirth = newYearString + newMonthString + newDayString + timeOfBirth;
		}
		return dateOfBirth;
	}

	public static String[] parseHl7(String[] fields, int i, int[] intArray) {
		String[] repetitions = fields[i].split("~");// split each field
		// on repeats
		fields[i] = ""; // clear the current field
		for (int j = 0; j != repetitions.length; j++) {
			String[] elements = repetitions[j].split("\\^");// split
			// each
			// repeat on
			// caret
			repetitions[j] = ""; // clear the current repeat

			for (int k = 0; k != intArray.length; k++) {

				if (intArray[k] < elements.length) {

					elements[intArray[k]] = ChangeString(elements[intArray[k]]);// alter
																				// the
					// elements that are
					// id'd

				}
			}
			// combine the elements back into a repeat
			for (int k = 0; k != elements.length; k++) {
				repetitions[j] = repetitions[j] + elements[k];
				if (k < elements.length - 1) {
					repetitions[j] = repetitions[j] + "^";
				}
			}
		}
		// combine the repeats back into a field
		for (int k = 0; k != repetitions.length; k++) {
			fields[i] = fields[i] + repetitions[k];
			if (k < repetitions.length - 1) {
				fields[i] = fields[i] + "~";
			}
		}

		return fields;
	}

	public static String ChangeString(String input) {
		// ToDo: check if its a date format. if it is, then change it as a date
		if (input.length() > 14) {
			if (DateUtil.convertToDate(input.substring(0, input.length() - (input.length() - 14))) != null) {
				String timeZone = input.substring(input.length() - (input.length() - 14), input.length());
				return changeDate(input.substring(0, input.length() - (input.length() - 14))) + timeZone;

			}

			if (input != null && !input.isEmpty()) {
				char[] individuals = input.toCharArray();
				for (int i = 0; i != individuals.length; i++) {
					if (Character.isDigit(individuals[i])) {
						individuals[i] = Character.forDigit(randInt(0, 9), 10);
					} else if (Character.isLetter(individuals[i])) {
						individuals[i] = randChar();
					}

				}
				return new String(individuals);
			}

		} else {
			if (DateUtil.convertToDate(input) != null) {
				return changeDate(input);

			}

			if (input != null && !input.isEmpty()) {
				char[] individuals = input.toCharArray();
				for (int i = 0; i != individuals.length; i++) {
					if (Character.isDigit(individuals[i])) {
						individuals[i] = Character.forDigit(randInt(0, 9), 10);
					} else if (Character.isLetter(individuals[i])) {
						if (Character.isUpperCase(individuals[i])) 
						{
							individuals[i] = Character.toUpperCase(randChar());
						} 
						else 
						{
							individuals[i] = Character.toLowerCase(randChar());
						}
					}

				}
				return new String(individuals);
			}
		}
		return input;
	}

	public static char randChar() {
		Random r = new Random();
		char randomChar = (char) (r.nextInt(26) + 'a');

		return randomChar;
	}

	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}

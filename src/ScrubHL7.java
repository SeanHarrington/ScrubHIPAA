import java.util.Random;

import com.sun.xml.internal.ws.util.StringUtils;

public class ScrubHL7 {

	public ScrubHL7() {

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

	public static String ScrubPID(String input) {
		// ToDo:

		String[] fields = input.split("\\|");
		input = ""; // clear the input
		// split on pipe

		// loop through all the fields
		for (int i = 0; i != fields.length; i++) {
			// CX Type & TS/DTM
			if (fields[i] != null && !fields[i].isEmpty()) {

				if (i == 3 || i == 4 || i == 7 || i == 29 || i == 18) {
					int[] intArray = new int[] { 0 };
					fields = parseHl7(fields, i, intArray);
				}
				// XPN TYPE
				else if (i == 5 || i == 6 || i == 9) {
					int[] intArray = new int[] { 0, 1, 2, 3, 4, 5, 6 };
					fields = parseHl7(fields, i, intArray);
				}
				// XAD type
				else if (i == 11) {
					int[] intArray = new int[] { 0, 1, 2, 7, 8, 9 };
					fields = parseHl7(fields, i, intArray);
				}
				// XTN type
				else if (i == 13 || i == 14) {
					int[] intArray = new int[] { 0, 3, 4, 5, 6, 7, 9, 11 };
					fields = parseHl7(fields, i, intArray);
				}
				//CE & CWE TYPE
				else if (i == 16 || i == 17 || i == 23 || i == 26 || i == 27 || i == 39) {
					int[] intArray = new int[] { 0, 1, 3, 4, 9 };
					fields = parseHl7(fields, i, intArray);
				}
				// DLN type
				else if (i == 20) {
					int[] intArray = new int[] { 0, 2};
					fields = parseHl7(fields, i, intArray);
				}

			}
		}
		// combine the fields back into a input
		for (int k = 0; k != fields.length; k++) {
			input = input + fields[k];
			if (k < fields.length - 1) {
				input = input + "|";

			}

		}

		return input;
	}

	public static String ChangeString(String input) {
		// ToDo:
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

	public static String ValidateHL7(String input) {

		String output = "";
		String newString = "";

		if (input.length() > 3) {

			input.replaceAll("\r\n", "\n");
			input.replaceAll("\n\n", "\n");
			String[] segments = input.split("\n");

			for (int i = 0; i != segments.length; i++) {
				// loop through all the segments calling the appropriate
				// scrubber
				// System.out.println(segments[i].substring(0, 3));
				newString = "";
				if (segments[i] != null && segments[i].trim().length() > 3) {
					segments[i] = segments[i].trim();
					if (segments[i].substring(0, 3).equals("PID")) {
						newString = ScrubPID(segments[i]);

					} else if (segments[i].substring(0, 3).equals("PV1")) {
						newString = segments[i];

					} else if (segments[i].substring(0, 3) == "PD1") {
						newString = segments[i];

					} else if (segments[i].substring(0, 3) == "NK1") {
						newString = segments[i];

					} else {
						newString = segments[i];
					}
				} else {
					newString = segments[i];

				}
				output = output + newString + "\r\n";

			}
			// end loop

			/**
			 * String segmentId = input.substring(0, 3); if
			 * (Arrays.asList(segmentIdArray).contains(segmentId)) { output =
			 * segmentId + " is a valid segment identifier"; } else { output =
			 * segmentId + " is not a valid segment identifier"; }
			 */
		}

		return output;

	}
}

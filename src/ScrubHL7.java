public class ScrubHL7 {

	public ScrubHL7() {

	}

	public static String ScrubPD1(String input) {
		String[] fields = input.split("\\|");
		input = ""; // clear the input
		// split on pipe
		// loop through all the fields
		for (int i = 0; i != fields.length; i++) {
			if (fields[i] != null && !fields[i].isEmpty()) {
				if (i == 5 || i == 6 || i == 7 || i == 8 || i == 19 || i == 20 || i == 21) {
					fields = ParseCX_TS_DTM_IS_ID_NM(fields, i); // CX & TS & DTM & IS & ID & NM type
				}
				else if (i == 4) {
					fields = ParseXPN_XCN(fields, i); // XPN & XCN type
				}
				else if (i == 99) {
					fields = ParseXAD(fields, i); // XAD type
				}
				else if (i == 99) {
					fields = ParseXTN(fields, i); // XTN type
				}
				else if (i == 99) {
					fields = ParseCE_CWE(fields, i); // CE&CWE type
				}
				else if (i == 99) {
					fields = ParseDLN(fields, i); // DLN type
				}
				else if (i == 3 || i == 14) {
					fields = ParseXON(fields, i); // XON type
				}
				else if (i == 99) {
					fields = ParseHD(fields, i); // HD type
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

	public static String ScrubPID(String input) {
		// ToDo:

		String[] fields = input.split("\\|");
		input = ""; // clear the input
		// split on pipe

		// loop through all the fields
		for (int i = 0; i != fields.length; i++) {
			if (fields[i] != null && !fields[i].isEmpty()) {
				if (i == 3 || i == 4 || i == 7 || i == 29 || i == 18) {
					fields = ParseCX_TS_DTM_IS_ID_NM(fields, i); // CX & TS & DTM & IS & ID & NM type
				}
				else if (i == 5 || i == 6 || i == 9) {
					fields = ParseXPN_XCN(fields, i); // XPN & XCN type
				}
				else if (i == 11) {
					fields = ParseXAD(fields, i); // XAD type
				}
				else if (i == 13 || i == 14) {
					fields = ParseXTN(fields, i); // XTN type
				}
				else if (i == 16 || i == 17 || i == 23 || i == 26 || i == 27 || i == 39) {
					fields = ParseCE_CWE(fields, i); // CE&CWE type
				}
				else if (i == 20) {
					fields = ParseDLN(fields, i); // DLN type
				} 
				else if (i == 99) {
					fields = ParseXON(fields, i); // XON type
				}

				else if (i == 99) 
				{
					fields = ParseHD(fields, i); // HD type
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

	public static String ScrubNK1(String input) {
		String[] fields = input.split("\\|");
		input = ""; // clear the input
		// split on pipe
		// loop through all the fields
		for (int i = 0; i != fields.length; i++) {
			if (fields[i] != null && !fields[i].isEmpty()) {
				if (i == 10 || i == 12 || i == 16 || i == 37 || i == 38 || i == 33) {
					fields = ParseCX_TS_DTM_IS_ID_NM(fields, i); // CX & TS & DTM & IS & ID & NM type
				}
				else if (i == 2 || i == 26 || i == 30) {
					fields = ParseXPN_XCN(fields, i); // XPN & XCN type
				}
				else if (i == 4 || i == 32) {
					fields = ParseXAD(fields, i); // XAD type
				}
				else if (i == 5 || i == 6 || i == 31) {
					fields = ParseXTN(fields, i); // XTN type
				}
				else if (i == 99) {
					fields = ParseCE_CWE(fields, i); // CE&CWE type
				}
				else if (i == 99) {
					fields = ParseDLN(fields, i); // DLN type
				}
				else if (i == 13) {
					fields = ParseXON(fields, i); // XON type
				}
				else if (i == 99) {
					fields = ParseHD(fields, i); // HD type
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

	public static String ScrubQPD(String input) {
		String[] fields = input.split("\\|");
		input = ""; // clear the input
		// split on pipe
		// loop through all the fields
		for (int i = 0; i != fields.length; i++) {
			if (fields[i] != null && !fields[i].isEmpty()) {
				if (i == 3 || i == 6 || i == 10 || i == 11) {
					fields = ParseCX_TS_DTM_IS_ID_NM(fields, i); // CX & TS & DTM & IS & ID & NM type
				}
				else if (i == 4 || i == 5) {
					fields = ParseXPN_XCN(fields, i); // XPN & XCN type
				}
				else if (i == 8) {
					fields = ParseXAD(fields, i); // XAD type
				}
				else if (i == 9) {
					fields = ParseXTN(fields, i); // XTN type
				}
				else if (i == 99) {
					fields = ParseCE_CWE(fields, i); // CE&CWE type
				}
				else if (i == 99) {
					fields = ParseDLN(fields, i); // DLN type
				}
				else if (i == 99) {
					fields = ParseXON(fields, i); // XON type
				}
				else if (i == 13) {
					fields = ParseHD(fields, i); // HD type
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

	public static String ScrubNTE(String input) {
		String[] fields = input.split("\\|");
		input = ""; // clear the input
		// split on pipe
		// loop through all the fields
		for (int i = 0; i != fields.length; i++) {
			if (fields[i] != null && !fields[i].isEmpty()) {
				if (i == 3) {
					fields = ParseCX_TS_DTM_IS_ID_NM(fields, i); // CX & TS & DTM & IS & ID & NM type
				}
				else if (i == 99) {
					fields = ParseXPN_XCN(fields, i); // XPN & XCN type
				}
				else if (i == 99) {
					fields = ParseXAD(fields, i); // XAD type
				}
				else if (i == 99) {
					fields = ParseXTN(fields, i); // XTN type
				}
				else if (i == 99) {
					fields = ParseCE_CWE(fields, i); // CE&CWE type
				}
				else if (i == 99) {
					fields = ParseDLN(fields, i); // DLN type
				}
				else if (i == 99) {
					fields = ParseXON(fields, i); // XON type
				}
				else if (i == 99) {
					fields = ParseHD(fields, i); // HD type
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

	public static String ScrubPV1(String input) {
		String[] fields = input.split("\\|");
		input = ""; // clear the input
		// split on pipe
		// loop through all the fields
		for (int i = 0; i != fields.length; i++) {
			if (fields[i] != null && !fields[i].isEmpty()) {
				if (i == 99) {
					fields = ParseCX_TS_DTM_IS_ID_NM(fields, i); // CX & TS & DTM & IS & ID & NM type
				}
				else if (i == 99) {
					fields = ParseXPN_XCN(fields, i); // XPN & XCN type
				}
				else if (i == 99) {
					fields = ParseXAD(fields, i); // XAD type
				}
				else if (i == 99) {
					fields = ParseXTN(fields, i); // XTN type
				}
				else if (i == 99) {
					fields = ParseCE_CWE(fields, i); // CE&CWE type
				}
				else if (i == 99) {
					fields = ParseDLN(fields, i); // DLN type
				}
				else if (i == 99) {
					fields = ParseXON(fields, i); // XON type
				}
				else if (i == 99) {
					fields = ParseHD(fields, i); // HD type
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

	public static String[] ParseCX_TS_DTM_IS_ID_NM(String[] fields, int i) {
		int[] intArray = new int[] { 0 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
	}	
	
	public static String[] ParseXPN_XCN(String[] fields, int i) {
		int[] intArray = new int[] { 0, 1, 2, 3, 4, 5 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
	}	
	
	public static String[] ParseXAD(String[] fields, int i) {
		int[] intArray = new int[] { 0, 1, 2, 7, 8, 9 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
	}	
	
	public static String[] ParseXTN(String[] fields, int i) {
		int[] intArray = new int[] { 0, 3, 4, 5, 6, 7, 9, 11 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
	}	

	public static String[] ParseCE_CWE(String[] fields, int i) {
		int[] intArray = new int[] { 0, 1, 3, 4, 9 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
	}	
	
	public static String[] ParseDLN(String[] fields, int i) {
		int[] intArray = new int[] { 0, 2 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
	}	
	
	public static String[] ParseXON(String[] fields, int i) {
		int[] intArray = new int[] { 0, 2, 7, 9 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
	}
	
	public static String[] ParseHD(String[] fields, int i) {
		int[] intArray = new int[] { 0, 1 };
		fields = ParseAndChangeData.parseHl7(fields, i, intArray);
		return fields;
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
					if ("PID".equals(segments[i].substring(0, 3))) {
						newString = ScrubPID(segments[i]);

					} else if ("PV1".equals(segments[i].substring(0, 3))) {
						newString = ScrubPV1(segments[i]);

					} else if ("PD1".equals(segments[i].substring(0, 3))) {
						newString = ScrubPD1(segments[i]);

					} else if ("QPD".equals(segments[i].substring(0, 3))) {
						newString = ScrubQPD(segments[i]);

					} else if ("NK1".equals(segments[i].substring(0, 3))) {
						newString = ScrubNK1(segments[i]);

					} else if ("NTE".equals(segments[i].substring(0, 3))) {
						newString = ScrubNTE(segments[i]);

					} else {
						newString = segments[i];
					}
				} else {
					newString = segments[i];

				}
				output = output + newString + "\r\n";

			}
			// end loop ScrubQPD

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

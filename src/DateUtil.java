
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {

	// List of all date formats that we want to parse.
	// Add your own format here.
	private static List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>() {
		{
			add(new SimpleDateFormat("yyyyMMddHHmm"));
			add(new SimpleDateFormat("yyyyMMddHH"));
			add(new SimpleDateFormat("yyyyMMddHHmmss"));
			add(new SimpleDateFormat("yyyyMMdd"));
			add(new SimpleDateFormat("yyyyMMddHHmmssZZZZ"));
		}
	};

	/**
	 * Convert String with various formats into java.util.Date
	 * 
	 * @param input
	 *            Date as a string
	 * @return java.util.Date object if input string is parsed successfully else
	 *         returns null
	 */
	public static Date convertToDate(String input) {
		Date date = null;
		if (null == input) {
			return null;
		}
		for (SimpleDateFormat format : dateFormats) {
			try {
				format.setLenient(false);
				date = format.parse(input);
			} catch (ParseException e) {
				// Shhh.. try other formats
			}
			if (date != null) {
				break;
			}
		}

		return date;
	}
}
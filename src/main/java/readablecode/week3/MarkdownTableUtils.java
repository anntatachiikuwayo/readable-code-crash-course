package readablecode.week3;

import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;

public class MarkdownTableUtils {
	// TODO3 : find the code to be replace with the method used at TODO2
	// refer OAOO principal

	// TODO4 : extract method and remove the comment if the comment is unnecessary,
	// 11.4, 5.1

	// TODO5 : refactor the extracted method by removing StringBuilder Argument and
	// return String
	// https://cyzennt.co.jp/blog/2021/05/19/java%EF%BC%9A%E5%BC%95%E6%95%B0%E3%81%A7%E6%B8%A1%E3%81%97%E3%81%9F%E5%8F%82%E7%85%A7%E5%9E%8B%E5%A4%89%E6%95%B0%E3%82%92%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E5%86%85%E3%81%A7%E5%A4%89%E6%9B%B4/

	// TODO1 add @throws in javadoc
	// e.g @throws xxxException if xxx is null or is less than XXX

	private static final String PIPE = "|";
	private static final String HYPHEN = "-";
	private static final String SPACE = " ";

	/**
	 * Returns the string of table which has empty rows as Markdown table syntax.
	 * length of captions for separator cell and empty cell is same with their
	 * header captions
	 *
	 *
	 * @param headerRowCaptions the captions for header row
	 * @param emptyRowCount     the number of empty rows.
	 * @return the string of table which has empty rows as Markdown table
	 * @throws IllegalArgumentException
	 *
	 */

	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount)
			throws IllegalArgumentException {

		String firstLine = null;
		String secondLine = null;
		String extraLine = null;

		// validate args
		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}

		firstLine = makeHeaderRowCaptions(headerRowCaptions, PIPE) + putPIPEandNewLine(PIPE);
		secondLine = makeHeaderRowSeparator(headerRowCaptions, PIPE, HYPHEN) + putPIPEandNewLine(PIPE);
		extraLine = makeEmptyRows(headerRowCaptions, emptyRowCount, PIPE, SPACE);

		return firstLine + secondLine + extraLine;
	}

	private static String makeHeaderRowCaptions(List<String> headerRowCaptions, String PIPE) {

		StringBuilder localMarkdownTable = new StringBuilder();
		for (String columnName : headerRowCaptions) {
			localMarkdownTable.append(PIPE + columnName);
		}
		return localMarkdownTable.toString();
	}

	private static String makeHeaderRowSeparator(List<String> headerRowCaptions, final String PIPE, final String HYPHEN) {
		StringBuilder localMarkdownTable = new StringBuilder();
		for (String columnName : headerRowCaptions) {
			String rowSeparator = Strings.repeat(HYPHEN, columnName.length());
			localMarkdownTable.append(PIPE + rowSeparator);
		}
		return localMarkdownTable.toString();
	}

	private static String makeEmptyRows(List<String> headerRowCaptions, int emptyRowCount, final String PIPE,
			final String SPACE) {
		StringBuilder localMarkdownTable = new StringBuilder();
		for (int i = 0; i < emptyRowCount; i++) {
			for (String columnName : headerRowCaptions) {
				String emptyRows = Strings.repeat(SPACE, columnName.length());
				localMarkdownTable.append(PIPE + emptyRows);
			}
			localMarkdownTable.append(putPIPEandNewLine(PIPE));
		}
		return localMarkdownTable.toString();
	}

	private static String putPIPEandNewLine(String PIPE) {
		return PIPE + System.lineSeparator();
	}
}

//------------------------元のコード---------------------------
//validate args
//		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
//		if (headerRowCaptions.isEmpty()) {
//			throw new IllegalArgumentException("headerCaptions must have one more elements");
//		}
//		if (emptyRowCount < 1) {
//			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
//		}
//
//		StringBuilder markdownTable = new StringBuilder();
//
//		String verticalBar = "|";
//		//String hyphen = "-";
//		//String empChar = " ";
//
//		// create line for header row captions
//		for (String e : headerRowCaptions) {
//			markdownTable.append("|");
//			markdownTable.append(e);
//
//			markdownTable.append(verticalBar + e);
//		}
//		markdownTable.append("|");
//		markdownTable.append(System.lineSeparator());
//
//		// create line for header row separator
//		for (String e : headerRowCaptions) {
//			markdownTable.append("|");
//
//			// TODO2 : use com.google.common.base.Strings to replace the followings:13.4
//			// target code to replace with Strings begin
//			for (int i = 0; i < e.length(); i++) {
//				markdownTable.append("-");
//			}
//			// target code to replace with guava end
//			// how to find suitable method in framework
//			// 1.open {@link com.google.common.base.Strings} and check outline (control + o)
//			// and read javadoc
//			// 2.check junit TestCase on github
//
//		}
//		markdownTable.append("|");
//		markdownTable.append(System.lineSeparator());
//
//		// create lines for empty rows
//		for (int i = 0; i < emptyRowCount; i++) {
//			for (String e : headerRowCaptions) {
//				markdownTable.append("|");
//				for (int j = 0; j < e.length(); j++) {
//					markdownTable.append(" ");
//				}
//			}
//			markdownTable.append("|");
//			markdownTable.append(System.lineSeparator());
//		}
//		System.out.println(markdownTable.toString());
//
//		return markdownTable.toString();
package readablecode.week4;

import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;

public class MarkdownTableUtils {

	// TODO1 : find more duplicated codes and extract them and refactor them.
	//
	// hint1. logic of creating separator row and empty row are same except " " or
	// "-"
	// hint2. logic of creating header caption row and other has difference
	//
	// idea1. give up for make all creating row logic into one method and create two
	// method for each
	// idea2. make all creating row logic into one and use selector argument such as
	// idea3. use adapter method
	// 1. use createRow which is existed in this class to replace your the code for
	// header caption row
	// 2. create adapter method for separator row and empty row in order to use
	// createRow

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
	 * @throws NullPointerException     if headerRowCaptions is null
	 * @throws IllegalArgumentException if headerRowCaptions is empty
	 * @throws IllegalArgumentException if emptyRowCount is less than 1
	 */
	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount) {

		//TODO1;重複コードを探して抽出、リファクタ
		//HINT1:セパレータ行と空行の作成ロジックは、" " または "-" を除いて同じです。
		//HINT2:ヘッダーキャプション行の作成ロジックとその他のロジックに違いがあります。
		//IDEA1:行を作成するロジックをすべて1つのメソッドにすることはあきらめ、それぞれ2つのメソッドを作成します。
		//IDEA2:行を作成するロジックをすべて1つにまとめ、セレクタの引数として使用する。
		//IDEA3:アダプター方式を採用。
		//1. ヘッダーキャプション行のコードを置き換えるには、このクラスに存在するcreateRowを使用します。
		//2. createRow を使用するために、セパレータ行と空行のアダプタメソッドを作成します。
		//---コメントアウト---
		//Markdownのテーブル構文として、空の行を持つテーブルの文字列を返す。
		//セパレータセルと空白セルのキャプションの長さは、それらのヘッダキャプションと同じです。

		// validate args
		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}
		String headerRow = createHeaderRow(headerRowCaptions);
		String separatorRow = createSeparatorRow(headerRowCaptions);
		String emptyRows = createEmptyRows(headerRowCaptions, emptyRowCount);
		return headerRow + separatorRow + emptyRows;
	}

	private static String createHeaderRow(List<String> headerRowCaptions) {
		return makeCaptionLine(headerRowCaptions);
	}

	private static String makeCaptionLine(List<String> headerRowCaptions) {
		StringBuilder markdownTable = new StringBuilder();
		for (String captions : headerRowCaptions) {
			markdownTable.append(PIPE + captions);
		}
		insertRowEnd(markdownTable);
		return markdownTable.toString();
	}

	private static String createSeparatorRow(List<String> headerRowCaptions) {
		//StringBuilder markdownTable = new StringBuilder();
		return makeOneHyphenLine(headerRowCaptions, HYPHEN);
		//return markdownTable.toString();
	}

	private static String makeOneHyphenLine(List<String> headerRowCaptions, String param) {
		StringBuilder markdownTable = new StringBuilder();
		for (String captions : headerRowCaptions) {
			markdownTable.append(PIPE + Strings.repeat(param, captions.length()));
		}
		insertRowEnd(markdownTable);
		return markdownTable.toString();
	}

	private static String createEmptyRows(List<String> headerRowCaptions, int emptyRowCount) {
		StringBuilder markdownTable = new StringBuilder();
		for (int i = 0; i < emptyRowCount; i++) {
			makeOneEmptyLine(headerRowCaptions, markdownTable, SPACE);
		}
		return markdownTable.toString();
	}

	private static void makeOneEmptyLine(List<String> headerRowCaptions, StringBuilder markdownTable, String param) {
		for (String captions : headerRowCaptions) {
			markdownTable.append(PIPE);
			markdownTable.append(Strings.repeat(param, captions.length()));
		}
		insertRowEnd(markdownTable);
	}

	private static void insertRowEnd(StringBuilder markdownTable) {
		markdownTable.append(PIPE);
		markdownTable.append(System.lineSeparator());
	}

	private static String createRow(List<String> captions) {
		return "|" + String.join("|", captions) + "|" + System.lineSeparator();
	}
}
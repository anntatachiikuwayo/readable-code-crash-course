package readablecode.week2;

import java.util.List;

public class MarkdownUtils {
	// TODO1 : use early return:Readable code 7.5, 7.7 and remove the 1 nest(you
	// might need to change if condition and if condition is complicated such as
	// if(!(...)) please refactor it after you read 7.2)
	// * you do not need to improve exception handling
	// TODO2 : add line break and comment for each block/paragraph after you read
	// Readable code 4.7
	// TODO3 : re-name the variables after you read Readable code 2.2 2.7, 3.8
	// TODO4 : re-name method as it is after you read Readable code 3.0, 3.9
	// TODO5 : remove the unnecessary variable after you read Readable code 9.1

	public static String createEmptyTableExceptName(List<String> nameListOfColumns, int recordNum)
			throws IllegalArgumentException {
		//ToDo1:早めにreturnしてネストを消す、条件式を簡単に
		//ToDo2:コードを段落に分割して、処理の要約を書く
		//ToDo3:変数の名前をリネーム
		//ToDo4:メソッドの名前をリネーム
		//ToDo5:不要な変数を消す
		if (nameListOfColumns == null) {
			throw new IllegalArgumentException("");
		}
		if (nameListOfColumns.isEmpty()) {
			throw new IllegalArgumentException("");
		}
		if (recordNum <= 0) {
			throw new IllegalArgumentException("");
		}

		StringBuilder sb = new StringBuilder();

		//１行目：カラム名を表示 -> "|カラム名|カラム名|...|"
		for (String columnName : nameListOfColumns) {
			sb.append("|");
			sb.append(columnName);
		}
		sb.append("|");
		sb.append(System.lineSeparator());

		//２行目：カラム名の長さに応じて仕切りを作成 -> "|----|----|...|"
		for (int i = 0; i < nameListOfColumns.size(); i++) {
			sb.append("|");
			String partition = new String(new char[(nameListOfColumns.get(i)).length() - 1]).replace("\0", "-");
			sb.append("-" + partition);
		}
		sb.append("|");
		sb.append(System.lineSeparator());

		//引数recordNumの分だけ行を追加 -> "|    |    |...|" * (columnNum)

		for (int i = 0; i < recordNum; i++) {
			for (int j = 0; j < nameListOfColumns.size(); j++) {
				sb.append("|");
				String empBox = new String(new char[(nameListOfColumns.get(j)).length() - 1]).replace("\0", " ");
				sb.append(" " + empBox);
			}
			sb.append("|");
			sb.append(System.lineSeparator());
		}
		return sb.toString();

		//もともとのコード

		//		if (l != null && !l.isEmpty() && c > 0) {
		//			StringBuilder tmp = new StringBuilder();
		//			for (String e : l) {
		//				tmp.append("|");
		//				tmp.append(e);
		//			}
		//			tmp.append("|");
		//			tmp.append(System.lineSeparator());
		//			for (String e : l) {
		//				tmp.append("|");
		//				for (int i = 0; i < e.length(); i++) {
		//					tmp.append("-");
		//				}
		//			}
		//			tmp.append("|");
		//			tmp.append(System.lineSeparator());
		//			for (int i = 0; i < c; i++) {
		//				for (String e : l) {
		//					tmp.append("|");
		//					for (int j = 0; j < e.length(); j++) {
		//						tmp.append(" ");
		//					}
		//				}
		//				tmp.append("|");
		//				tmp.append(System.lineSeparator());
		//			}
		//			String result = tmp.toString();
		//			return result;
		//		} else {
		//			throw new IllegalArgumentException("");
		//		}
	}
}

//sb.append(empBox.repeat(nameListOfColumns.get(i)).length());
//→repeat()使えない？？？
//Stream.generate(() -> " ").limit(nameListOfColumns.get(i).length());
//			//これはだめそうだった、appendつけたらさらにダメ
//			String.join("", Collections.nCopies(nameListOfColumns.get(i).length(), " "));

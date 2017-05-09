import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {
		//入力
		while(true) {
			System.out.println("コンソール版CRUDシステムです。番号を選んでください。");
			System.out.println("0:終了 1:検索 2:挿入 3:更新 4:削除");
			Scanner sc = new Scanner(System.in);
			int line = sc.nextInt();

			//0:終了
			if(line == 0) {
				System.out.println("終了します");
				break;
			}

			switch(line) {
				//1:検索
				case 1 :
					//1:全検索か2:部分検索か選ぶ
					System.out.println("1:全検索 2:部分検索");
					Scanner sc2 = new Scanner(System.in);
					int selectnum = sc2.nextInt();
					if(selectnum == 1) {
						DbDao.selectAll();
					} else if(selectnum == 2) {
						DbDao.selectPart();
					}
					break;
				//2:挿入
				case 2 :
					DbDao.insert();
					break;
				//3:更新
				case 3 :
					DbDao.update();
					break;
				//4:削除
				case 4 :
					DbDao.delete();
					break;
				default :
					System.out.println("1~5の数字を入力してください");
			}
		}
	}
}

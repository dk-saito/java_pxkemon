package pxkemon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//	********************************************************************************************
//		１．自分のモンスターを3体生成
//	********************************************************************************************

		ArrayList<MyMonster> MyMonsters = new ArrayList<>(6);
		MyMonster myMonster1 = new MyMonster("フ○ギダネ", 100, 100, 20, 5);
		MyMonster myMonster2 = new MyMonster("ヒ○カゲ", 100, 100, 20, 5);
		MyMonster myMonster3 = new MyMonster("ゼ○ガメ", 100, 100, 20, 5);
		MyMonsters.add(myMonster1);
		MyMonsters.add(myMonster2);
		MyMonsters.add(myMonster3);

//	********************************************************************************************
//		２．フィールドモンスターを3体 Field.java から生成
//	********************************************************************************************

		Field fm = new Field();
		
//	********************************************************************************************
//		３．すべてのモンスターを表示
//	********************************************************************************************

		System.out.println("--------------------------------------------");
		System.out.println("【てもちのモンスター】\n");
		for (MyMonster a : MyMonsters) {
			System.out.println("      " + a);
		}
		System.out.println("--------------------------------------------");
		System.out.println("【やせいのモンスター】\n");
		for (EnemyMonster b : fm.EnemyMonsters) {
			System.out.println("      " + b);
		}
		System.out.println("--------------------------------------------\n");

//	********************************************************************************************
//		４．メインとなる処理
//			「たたかう」、「にげる」、「かいふく」など
//	********************************************************************************************

//		L50 ~ L117 までループ
		while (1 < 2) {
			System.out.println("+------------------------------------------------------+");
			System.out.println("|    1 > のはらにでる  2 > かいふくする  3 > おわる    |");
			System.out.println("+------------------------------------------------------+");

			Scanner scanner1 = new Scanner(System.in);
			int mode = scanner1.nextInt();

//			分岐処理
			if (mode == 1) {
				message(fm.EnemyMonsters.get(0).name + "があらわれた！");
				
				int[] n = { 0, 0 };
				while (n[0] < MyMonsters.size() && n[1] < fm.EnemyMonsters.size()) {

					System.out.println("+------------------------------------------------------+");
					System.out.println("|         1 > たたかう 2 > にげる 3 > こうたい         |");
					System.out.println("+------------------------------------------------------+");

					Scanner scanner2 = new Scanner(System.in);
					int battleMode = scanner2.nextInt();

					if (battleMode == 1) {
//						message("ゆけ！" + MyMonsters.get(0).name + "！");
						
					} else if (battleMode == 2) {
						message("にげきれた！");
						break;
						
					} else if (battleMode == 3) {
						if (n[0] < MyMonsters.size() - 1) {
							n[0]++;
							message(MyMonsters.get(n[0]).name + "に 交代した！");
							battle(MyMonsters.get(n[0]), fm.EnemyMonsters.get(n[1]), n);

						} else {
							message("こうたい できない！");
							continue;
						}
					} else {
						message("無効な コマンドだ！");
						continue;
					}
//			戦闘
					battle(MyMonsters.get(n[0]), fm.EnemyMonsters.get(n[1]), n);
				}

			} else if (mode == 2) {
//			回復	
				for (MyMonster a : MyMonsters) {
					a.cure(a);
				}
				for (EnemyMonster b : fm.EnemyMonsters) {
					b.cure(b);
				}

//				MyMonsters.get(0).cure(MyMonsters.get(0));
//				fm.EnemyMonsters.get(0).cure(fm.EnemyMonsters.get(0));

			} else if (mode == 3) {
//			終了
				System.exit(0);
			} else {
				message("無効な コマンドだ！");
				continue;
			}
		}
	}
//	mainメソッドおわり
	
	
//	********************************************************************************************
//		ユーザー定義関数
//	********************************************************************************************


//	攻撃しあう処理
	static int[] battle(MyMonster MyMonsters, EnemyMonster fm, int n[]) {
		while (MyMonsters.life == false) {

			MyMonsters.attack(fm);

			if (fm.hp == 0) {
				message("やせいの " + fm.name + "は たおれた！");
				
//				if(MyMonsters.get(2).hp == 0) {
//					messege("かち！");
//				}else if(fm.get(fm.size() - 1).hp == 0) {
//					message("まけ！");
//				}
//				System.out.println("ゲームクリア！");
				n[1]++;
				fm.life = true;
				break;
			}

			fm.attack(MyMonsters);

			if (MyMonsters.hp == 0) {
				message(MyMonsters.name + "は たおれた！");
//				System.out.println("ゲームオーバー！");
				n[0]++;
				MyMonsters.life = true;
				break;
			}
		}
		return n;
	}
	
//	メッセージ処理
	static void message(String text) {
//		System.out.println("--------------------------------------------");
		System.out.println("********************************************");
		System.out.println("          " + text);
		System.out.println("********************************************\n");
//		System.out.println("--------------------------------------------\n");
	}

}

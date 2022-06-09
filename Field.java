package pxkemon;

import java.util.ArrayList;

public class Field {
	ArrayList<EnemyMonster> EnemyMonsters = new ArrayList<>(6);

//	constractor
	public Field() {
		EnemyMonster enemyMonster1 = new EnemyMonster("○ャース", 80, 80, 25, 5);
		EnemyMonster enemyMonster2 = new EnemyMonster("イ○ツブテ", 80, 80, 25, 20);
		EnemyMonster enemyMonster3 = new EnemyMonster("○ッポ", 80, 80, 25, 5);

		EnemyMonsters.add(enemyMonster1);
		EnemyMonsters.add(enemyMonster2);
		EnemyMonsters.add(enemyMonster3);
	}

//	public EnemyMonster getEnemyMonster() {
//		return this.EnemyMonsters.get(0);
//	}

}

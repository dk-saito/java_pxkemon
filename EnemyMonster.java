package pxkemon;

public class EnemyMonster extends Monster {

	public EnemyMonster(String name, int hp, int maxHp, int attackPower, int defencePower) {
		super(name, hp, maxHp, attackPower, defencePower);

	}

	@Override
	public void attack(Monster target) {
		System.out.println("    " + this.name + "の こうげき！ " + target.name + "に " + this.attackPower + " のダメージ");
		target.hp -= this.attackPower;

		if (target.hp < 0) {
			target.hp = 0;
		}

		System.out.println("    " + target.name + "の のこりHP：" + target.hp + "\n");

	}

//	cure
	@Override
	public void cure(Monster monster) {
		this.hp = this.maxHp;
		System.out.println("    やせいの " + this.name + " の たいりょくは まんたんに なった！ \n");
		this.life = false;
	}

//	toString method
	@Override
	public String toString() {
		return "name: " + name + "   " + "hp: " + hp + "\n";
	}

}

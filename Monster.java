package pxkemon;

public abstract class Monster {
	protected String name;
	protected int hp;
	protected int maxHp;
	protected int attackPower;
	protected int defencePower;
	protected boolean life = false;

//	constractor
	public Monster(String name, int hp, int maxHp, int attackPower, int defencePower) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.attackPower = attackPower;
		this.defencePower = defencePower;
	}

//	getter
	public String getName() {
		return this.name;
	}

	public int getHp() {
		return this.hp;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getAttackPower() {
		return this.attackPower;
	}

	public int getDefencePower() {
		return this.defencePower;
	}

	public boolean getLife() {
		return this.life;
	}

//	setter
	public void setLife(boolean life) {
		this.life = life;
	}

//	attack method
	abstract public void attack(Monster target);

//	cure method
	abstract public void cure(Monster monster);

//	toString method
	@Override
	abstract public String toString();

}

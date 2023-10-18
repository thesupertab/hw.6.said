
enum WeaponType {
    SWORD,
    AXE,
    BOW
}

class Weapon {
    private WeaponType type;
    private String name;

    public Weapon(WeaponType type, String name) {
        this.type = type;
        this.name = name;
    }

    public WeaponType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class GameEntity {
    private int health;
    private int damage;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

class Boss extends GameEntity {
    private Weapon weapon;

    public Boss(int health, int damage, Weapon weapon) {
        setHealth(health);
        setDamage(damage);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String printInfo() {
        return "Boss Information:\n" +
                "Health: " + getHealth() + "\n" +
                "Damage: " + getDamage() + "\n" +
                "Weapon Type: " + getWeapon().getType() + "\n" +
                "Weapon Name: " + getWeapon().getName();
    }
}

// дз на сообразительность
class Skeleton extends Boss {
    private int arrowCount;

    public Skeleton(int health, int damage, Weapon weapon, int arrowCount) {
        super(health, damage, weapon);
        this.arrowCount = arrowCount;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    @Override
    public String printInfo() {
        return "Skeleton Information:\n" +
                "Health: " + getHealth() + "\n" +
                "Damage: " + getDamage() + "\n" +
                "Weapon Type: " + getWeapon().getType() + "\n" +
                "Weapon Name: " + getWeapon().getName() + "\n" +
                "Arrow Count: " + arrowCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Weapon bossWeapon = new Weapon(WeaponType.SWORD, "smash");
        Boss boss = new Boss(1000, 50, bossWeapon);

        System.out.println(boss.printInfo());

        Weapon skeletonWeapon1 = new Weapon(WeaponType.BOW, "fireBow");
        Skeleton skeleton1 = new Skeleton(80, 10, skeletonWeapon1, 20);

        Weapon skeletonWeapon2 = new Weapon(WeaponType.BOW, "iceBow");
        Skeleton skeleton2 = new Skeleton(70, 15, skeletonWeapon2, 15);

        System.out.println("\nSkeleton 1 Info:");
        System.out.println(skeleton1.printInfo());

        System.out.println("\nSkeleton 2 Info:");
        System.out.println(skeleton2.printInfo());
    }
}
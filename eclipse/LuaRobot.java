package eclipse;

import robocode.*;
import java.awt.Color;

public class LuaRobot extends TeamRobot {

	public void run() {
		// Cores do robô:
		setBodyColor(Color.lightGray); // Body => Corpo
		setGunColor(Color.gray); // Gun => Arma
		setRadarColor(Color.white); // Radar => Radar
		setScanColor(Color.lightGray); // Scan => Varredura
		setBulletColor(Color.white); // Bullet => Bala

		while (true) {
			// Batedor: está sempre andando e girando
			ahead(100);
			turnGunRight(360);
			turnRight(45);
			back(100);
			turnGunRight(360);
			turnLeft(45);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if (isTeammate(e.getName())) {
			return; // não atira no parceiro
		}
		fire(1); // tiro leve
	}

	public void onHitByBullet(HitByBulletEvent e) {
		turnRight(90); // foge de lado quando é atingido
		ahead(100);
	}

	public void onHitWall(HitWallEvent e) {
		back(50);
		turnRight(90);
	}
}
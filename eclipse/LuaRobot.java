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

		// Loop principal do robô
		while (true) {
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	// onScannedRobot: O que fazer quando avistar outro robô
	public void onScannedRobot(ScannedRobotEvent e) {

		// Verificando se o robô avistado é um parceiro de equipe
		if (isTeammate(e.getName())) {
			return; // é o parceiro, não atira
		}
		fire(1);
	}

	// onHitByBullet: O que fazer quando for atingido por um projétil
	public void onHitByBullet(HitByBulletEvent e) {

		back(10);
	}

	// onHitWall: O que fazer quando colidir com uma parede
	public void onHitWall(HitWallEvent e) {

		back(20);
	}
}
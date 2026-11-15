package eclipse;

import robocode.*;
import java.awt.Color;

public class SolRobot extends TeamRobot {

	public void run() {

		// Cores do robô:
		setBodyColor(Color.orange); // Body => Corpo
		setGunColor(Color.yellow); // Gun => Arma
		setRadarColor(Color.yellow); // Radar => Radar

		setScanColor(Color.orange); // Scan => Varredura
		setBulletColor(Color.yellow); // Bullet => Bala

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
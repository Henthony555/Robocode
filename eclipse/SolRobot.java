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

		while (true) {
			// Artilheiro: fica quase parado, só gira o canhão procurando inimigo
			turnGunRight(360);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if (isTeammate(e.getName())) {
			return; // não atira no parceiro
		}
		// Tiro forte se o inimigo está perto, mais fraco se está longe
		if (e.getDistance() < 300) {
			fire(3);
		} else {
			fire(1);
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {
		turnRight(90); // sai da linha de tiro
		ahead(100);
	}

	public void onHitWall(HitWallEvent e) {
		back(50);
	}
}
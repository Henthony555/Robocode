package eclipse;

import robocode.*;
import java.awt.Color;

// Ajuda da API : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * SolRobot - um robô criado por (seu nome aqui)
 */
public class SolRobot extends Robot {
	/**
	 * run: Comportamento padrão do SolRobot
	 */
	public void run() {
		// A inicialização do robô deve ser colocada aqui

		// Depois de testar seu robô, tente descomentar o import no topo,
		// e a seguinte linha:

		// setColors(Color.red,Color.blue,Color.green); // corpo, arma, radar

		setBodyColor(Color.orange);
		setGunColor(Color.yellow);
		setRadarColor(Color.yellow);

		setScanColor(Color.orange);
		setBulletColor(Color.yellow);

		// Loop principal do robô
		while (true) {
			// Substitua as próximas 4 linhas por qualquer comportamento que desejar
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: O que fazer quando avistar outro robô
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Substitua a próxima linha por qualquer comportamento que desejar
		fire(1);
	}

	/**
	 * onHitByBullet: O que fazer quando for atingido por um projétil
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Substitua a próxima linha por qualquer comportamento que desejar
		back(10);
	}

	/**
	 * onHitWall: O que fazer quando colidir com uma parede
	 */
	public void onHitWall(HitWallEvent e) {
		// Substitua a próxima linha por qualquer comportamento que desejar
		back(20);
	}
}
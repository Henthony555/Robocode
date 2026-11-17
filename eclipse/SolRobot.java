package eclipse;

import robocode.*;
import java.awt.Color;

public class SolRobot extends TeamRobot {

    public void run() {
        // --- 1. CONFIGURAÇÃO DE CORES ---
        // Define as cores visuais do robô baseadas no tema "Sol"
        setBodyColor(Color.orange);   // Corpo do robô
        setGunColor(Color.yellow);    // Canhão / Arma
        setRadarColor(Color.yellow);  // Radar (olhos do robô)
        setScanColor(Color.orange);   // Raio de varredura do radar
        setBulletColor(Color.yellow); // Cor das balas disparadas

        // --- 2. LOOP PRINCIPAL ---
        // Fica rodando repetidamente enquanto a batalha estiver acontecendo
        while (true) {
            // Artilheiro estático: o corpo fica parado e o canhão gira continuamente
            // para a direita buscando inimigos (5 graus por turno)
            turnGunRight(5);
        }
    }

    // --- 3. DETECÇÃO DE INIMIGOS ---
    // Executado automaticamente sempre que o radar enxerga algum robô
    public void onScannedRobot(ScannedRobotEvent e) {
        // Se o robô avistado for da mesma equipe, ignora para não atirar em aliados
        if (isTeammate(e.getName())) {
            return; 
        }

        // --- 4. CONTROLE DE POTÊNCIA DO TIRO ---
        // Se o inimigo estiver perto (< 300 pixels), dá um tiro forte (potência 3)
        // Se estiver longe, dá um tiro mais fraco (potência 1) para economizar energia
        if (e.getDistance() < 300) {
            fire(3);
        } else {
            fire(1);
        }

        // Força uma varredura imediata para atualizar os dados do radar na hora
        scan();
    }

    // --- 5. DEFESA AO LEVAR UM TIRO ---
    // Executado quando uma bala inimiga acerta o seu robô
    public void onHitByBullet(HitByBulletEvent e) {
        turnRight(90);  // Vira 90 graus para tentar sair da linha de tiro
        ahead(100);     // Avança 100 pixels para se afastar
        scan();         // Varre a área para procurar o inimigo após a esquiva
    }

    // --- 6. DEFESA AO BATER NA PAREDE ---
    // Executado se o robô colidir contra as bordas da arena
    public void onHitWall(HitWallEvent e) {
        back(50);       // Dá 50 passos para trás para desencostar da parede
    }
}
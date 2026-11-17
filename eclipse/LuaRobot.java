package eclipse;

import robocode.*;
import java.awt.Color;

public class LuaRobot extends TeamRobot {

    public void run() {
        // --- 1. CONFIGURAÇÃO DE CORES (Tema da Lua) ---
        // Define as cores visuais do robô em tons prateados, cinza e branco
        setBodyColor(Color.lightGray); // Corpo do robô
        setGunColor(Color.gray);       // Canhão / Arma
        setRadarColor(Color.white);    // Radar (olhos do robô)
        setScanColor(Color.lightGray); // Raio de varredura do radar
        setBulletColor(Color.white);   // Cor das balas disparadas

        // --- 2. LOOP PRINCIPAL DE MOVIMENTAÇÃO E PATRULHA ---
        // Fica executando essa rotina repetidamente para o robô nunca parar de se mover
        while (true) {
            // Batedor: está sempre andando e girando para cobrir a arena
            ahead(100);             // Anda 100 pixels para frente
            turnGunRight(180);      // Gira o canhão/radar em um círculo completo para procurar inimigos
            turnRight(45);          // Vira o corpo 45 graus para a direita
            back(100);              // Anda 100 pixels para trás
            turnGunRight(180);      // Gira o canhão/radar novamente em círculo completo
            turnLeft(45);           // Vira o corpo 45 graus para a esquerda (desfazendo a curva)
            execute();              // Processa e executa todos os comandos acumulados acima
        }
    }

    // --- 3. DETECÇÃO DE INIMIGOS ---
    // Executado automaticamente sempre que o radar enxerga algum robô
    public void onScannedRobot(ScannedRobotEvent e) {
        // Se o robô avistado for da mesma equipe, ignora para não atirar em aliados
        if (isTeammate(e.getName())) {
            return; 
        }
        
        fire(1); // Dispara um tiro leve (potência 1) para economizar energia enquanto se movimenta
    }

    // --- 4. DEFESA AO LEVAR UM TIRO ---
    // Executado quando uma bala inimiga acerta o robô
    public void onHitByBullet(HitByBulletEvent e) {
        turnRight(90);  // Vira 90 graus para fugir de lado e confundir o oponente
        ahead(100);     // Avança 100 pixels para se afastar da linha de fogo
    }

    // --- 5. DEFESA AO BATER NA PAREDE ---
    // Executado se o robô colidir contra as bordas da arena
    public void onHitWall(HitWallEvent e) {
        back(50);       // Dá 50 passos para trás para desencostar da parede
        turnRight(90);  // Vira 90 graus para mudar de rota e evitar prender-se de novo
    }
}
package jogoDaVelha;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class jOptionPane {
	static Scanner sc = new Scanner(System.in);
	static String[][] jogo = new String[3][3];
	static int parar = 0, ganhar = 0;

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				jogo[i][j] = "_";
			}
		}

		JOptionPane.showMessageDialog(null,"Jogador 1: bolinha \nJogador 2: xizinho");
		tabuleiro();
		jogadas();

	}

	static void jogadas() {
		int l, c, l2, c2, i = 0;
		do {
			while (parar == 0) {
				l = Integer.parseInt(JOptionPane.showInputDialog(null,"Jogador 1: informe a linha:  "));
				c = Integer.parseInt(JOptionPane.showInputDialog("Jogador 1: informe a coluna: "));
				if (jogo[l][c] == "x" || jogo[l][c] == "o") {
					JOptionPane.showMessageDialog(null,"jogada invalida");

				} else {
					jogo[l][c] = "o";
					tabuleiro();
					parar = 1;
				}

			}
			parar = 0;
			ganhar = ganhador();
			if (ganhar == 2) {
				JOptionPane.showMessageDialog(null,"Jogador 2 é o vencedor");
				parar = 1;
				i = 10;

			} else if (ganhar == 1) {
				JOptionPane.showMessageDialog(null,"Jogador 1 é o vencedor");
				parar = 1;
				i = 10;
			}
			if (i == 9) {
				i = 10;
				JOptionPane.showMessageDialog(null,"empate");

			} else if(i!=10) {

				while (parar == 0) {
					l2 = Integer.parseInt(JOptionPane.showInputDialog("Jogador 2: informe a linha:  "));
					c2 = Integer.parseInt(JOptionPane.showInputDialog("Jogador 2: informe a coluna: "));
					if (jogo[l2][c2] == "x" || jogo[l2][c2] == "o") {
						JOptionPane.showMessageDialog(null,"jogada invalida");
					} else {
						jogo[l2][c2] = "x";
						tabuleiro();
						parar = 1;
					}
				}
				parar = 0;
				ganhar = ganhador();
				if (ganhar == 2) {
					JOptionPane.showMessageDialog(null,"Jogador 2 é o vencedor");
					parar = 1;
					i = 10;

				} else if (ganhar == 1) {
					JOptionPane.showMessageDialog(null,"Jogador 1 é o vencedor");
					parar = 1;
					i = 10;
				}
			}
			else {
				i=10;
			}
		} while (i < 9);
	}

	static void tabuleiro() {
		JOptionPane.showMessageDialog(null," 0  1  2 \n0 " + jogo[0][0] + "|" + jogo[0][1] + "|" + jogo[0][2]+"\n1 " + jogo[1][0] + "|" + jogo[1][1] + "|" + jogo[1][2]+"\n2 " + jogo[2][0] + "|" + jogo[2][1] + "|" + jogo[2][2]);
	}

	static int ganhador() {
		for (int i = 0; i < 4; i++) {
			if (jogo[0][0] == "x" && jogo[0][1] == "x" && jogo[0][2] == "x"
					|| jogo[0][0] == "x" && jogo[1][0] == "x" && jogo[2][0] == "x"
					|| jogo[1][0] == "x" && jogo[1][1] == "x" && jogo[1][2] == "x"
					|| jogo[0][1] == "x" && jogo[1][1] == "x" && jogo[2][1] == "x"
					|| jogo[2][0] == "x" && jogo[2][1] == "x" && jogo[2][2] == "x"
					|| jogo[0][2] == "x" && jogo[1][2] == "x" && jogo[2][2] == "x"
					|| jogo[0][0] == "x" && jogo[1][1] == "x" && jogo[2][2] == "x"
					|| jogo[0][2] == "x" && jogo[1][1] == "x" && jogo[2][0] == "x") {
				ganhar = 2;
			}
			if (jogo[0][0] == "o" && jogo[0][1] == "o" && jogo[0][2] == "o"
					|| jogo[0][0] == "o" && jogo[1][0] == "o" && jogo[2][0] == "o"
					|| jogo[1][0] == "o" && jogo[1][1] == "o" && jogo[1][1] == "o"
					|| jogo[0][1] == "o" && jogo[1][1] == "o" && jogo[2][1] == "o"
					|| jogo[2][0] == "o" && jogo[2][1] == "o" && jogo[2][2] == "o"
					|| jogo[0][2] == "o" && jogo[1][2] == "o" && jogo[2][2] == "o"
					|| jogo[0][0] == "o" && jogo[1][1] == "o" && jogo[2][2] == "o"
					|| jogo[0][2] == "o" && jogo[1][1] == "o" && jogo[2][0] == "o") {
				ganhar = 1;
			}
		}
		return ganhar;
	}
}

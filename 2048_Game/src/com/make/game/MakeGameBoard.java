package com.make.game;

public class MakeGameBoard {
	Box[][] box;
	private int boxNumber;
	private boolean lose;
	private boolean win;

	public MakeGameBoard() {
		box = new Box[4][4];
		// ���� �ڽ� ����
		this.boxNumber = 0;
		this.lose = false;
		this.win = false;
	}

	public void drawBoard() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (box[i][j] != null) {
					box[i][j].draw();
				}
			}
		}
	}

	// ���ڸ� ����
	private int emptyCounter() {
		int empty = 0;

		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (box[row][col] == null) {
					empty += 1;
				}
			}
		}
		return empty;
	}

	private int[] randomRow() {
		int empty = emptyCounter();
		int[] rowArr = new int[empty];

		// �迭�� null �� �� �迭�� �� ��ȣ ����
		int nullRow = 0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (box[row][col] == null) {
					rowArr[nullRow] = row;
					nullRow += 1;
				}
			}
		}
		return rowArr;

	}

	private int[] randomCol() {
		int empty = emptyCounter();
		int[] colArr = new int[empty];

		// �迭�� null �� �� �迭�� �� ��ȣ ����
		int nullCol = 0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (box[row][col] == null) {
					colArr[nullCol] = col;
					nullCol += 1;
				}
			}
		}
		return colArr;

	}

	public void randomPick() {
		int empty = emptyCounter();
		int random = (int) (Math.random() * empty);

		int[] rowArr = randomRow();
		int[] colArr = randomCol();

		int rowIndex = rowArr[random];
		int colIndex = colArr[random];

		// ���ο� ���� ������ 2 �Ǵ� 4�� �������� ����
		int boxValue;
		// 50% Ȯ����
		if (Math.random() < 0.5) {
			boxValue = 2;
		} else {
			boxValue = 4;
		}

		box[colIndex][rowIndex] = new Box(rowIndex, colIndex, boxValue);
		boxNumber += 1;
	}

	// value�� 2048�� �Ǹ� �̱��
	public void isWin() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (box[i][j].getBoxValue() == 2048) {
					win = true;
				}
			}
		}
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	@Override
	public String toString() {
		String out = "";
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (box[row][col] != null) {
					out += "___" + box[row][col].getBoxValue() + " ";
				} else {
					out += "null ";
				}
			}
			out += '\n';
		}
		return out;

	}

	public void moveBox(char c) {
		if (c == 'w') {
			//��� ������ ���� �� ���� �ö󰡴� ����.
			//�ٽ� ��ü 2���� �迭�� ã�Ƽ� -> ���ڰ� �ִ� ��ġ�� �ε����� ����ϰ� 
			//���� �÷��ݴϴ�.
		} else if (c == 'a') {
		} else if (c == 'd') {
		} else if (c == 's') {
		}
	}

	public static void main(String[] args) {
		MakeGameBoard game1 = new MakeGameBoard();
		game1.randomPick();
		game1.randomPick();
		String out = game1.toString();
		System.out.println(out);
	}
}
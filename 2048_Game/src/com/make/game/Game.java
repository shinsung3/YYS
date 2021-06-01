package com.make.game;

import java.util.Arrays;

public class Game {
	Table[][] box;
	private int boxNumber;
	private boolean lose;
	private boolean win;
	/*
	 * Constructor
	 */
	public Game() {
		box = new Table[4][4];
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

	/*
	 * ù��° ���� 2�� �����
	 */
	public int[][] randomInit(int[][] map) {
		int[] val = { 2, 4 };
		int cnt = 0;
		while (cnt != 2) {
			int x = (int) (Math.random() * 4);
			int y = (int) (Math.random() * 4);
//			if (box[y][x] == null) {
//				box[y][x] = new Table(x, y, val[(int) (Math.random() * 2)]);
//				cnt++;
//			}
			int index = (int) (Math.random() * 2);
			if (map[y][x] == 0) {
				map[y][x] = val[index];
				cnt++;
			}
		}
		return map;
	}

	/*
	 * �����϶����� ���� 1�� ���� Helper Function - private
	 */
	private int[][] randomNumber(int[][] table) {
		int[] val = { 2, 4 };
		int x = (int) (Math.random() * 4);
		int y = (int) (Math.random() * 4);
		int index = (int) (Math.random() * 2);
		if(table[y][x]==0) {
			table[y][x] = val[index];
		}
		return table;
//		if (box[y][x] == null) {
//			box[y][x] = new Table(x, y, val[(int) (Math.random() * 2)]);
//		}
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

	/*
	 * while(true) { if(PennDraw.hasNextKeyTyped()){
	 * 
	 * char key = PennDraw.nextKeyTyped(); if( key == 'a') {
	 * 
	 * }else if(key == 'w') { }else if(key == 's') { }else if( key =='d') { }else {
	 * 
	 * break; }
	 */
	/*
	 * { {j,i} {0,0}, {0,1}, {0,2}, {0,3} {1,0},2{1,1}, {1,2}, {1,3} {2,0}, {2,1},
	 * {2,2}, 4{2,3} {3,0}, {3,1}, {3,2}, {3,3} }
	 */

	/*
	 * 1. 2���� �迭 �ȿ� ���ڰ� ������ �����̵���!
	 */
	public void moveTable(char key, int[][] table) {

		// �����̱� �� ���� ���̺�
		int[][] copyTable = copyMap(table);

		if (key == 'w') {
			// 1. ���� ������ �����δ�.
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 4; i++) { // ��=i, ��=j
					// 2. ���� 0�� �Ǹ� �� �����ϰ�.
					if (i == 0)
						continue;
					if (table[i][j] == 0)
						continue;
					boolean isNull = false;
					for (int k = i - 1; k >= 0; k--) {
						if (table[k][j] != 0) {
							isNull = true;
							table[k + 1][j] = table[i][j];
							table[i][j] = 0;
							break;
						}
					}
					if (!isNull) {
						table[0][j] = table[i][j];
						table[i][j] = 0;
					}
				}
			}

			/*
			 * 2. WŰ�� �̿��ؼ� �������ٸ�, ���ο� random���� �����ǰ�, �ȿ������ٸ� �ƹ��͵� ���Ѵ�.
			 */
			if(isMove(table, copyTable)) {
				table = randomNumber(table);
			}
		}
	}

	/**
	 * ���������� Ȯ���ϴ� Method
	 * @param table - ������ �� ���̺�
	 * @param copyTable - �����̱� �� ���̺�
	 * @return true/false
	 */
	private boolean isMove(int[][] table, int[][] copyTable) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(table[i][j] != copyTable[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ���� ���̺� ����� Method
	 * @param table - �������̺�
	 * @return - ī�����̺�
	 */
	private int[][] copyMap(int[][] table) {
		int[][] copyTable = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyTable[i][j] = table[i][j];
			}
		}
		return copyTable;
	}

	/*
	 * 1. key�� ������ �����̱�. 2. �����̰� �� �������� ���ο� ���ڸ� ������ ��. 3. ���̻� �и����ʾƾ� ��. 4. Table��
	 * ���� ���������� ���θ� �Ǵ��ؼ� �����̴� �ڵ�¥��
	 */
	// (1,3)
	public void moveBox(char key) {
		int index = -1;
		if (key == 'w') {
			for (int i = 0; i < 4; i++) { // ��
				for (int j = 1; j < 4; j++) {
					index = -1;
					if (box[j][i] != null) { // box[1][3] != null
						for (int k = j - 1; k >= 0; k--) { // k = 1-1 0
							if (box[k][i] != null) {// box[0][3] !=null
								break;
							}
							// ����
							index = k;
						}
						if (index != -1) {
							box[index][i] = box[j][i];
							// ��ǥ�� �׸� ǥ��
							box[index][i].setX(i);
							box[index][i].setY(index);
							box[j][i] = null;
						}
					}
				}
			}
			System.out.println();

		} else if (key == 's') {
			for (int i = 0; i < 4; i++) {
				// ������ ��(y=3)�� �������
				for (int j = 0; j < 3; j++) {
					// �ű� �ڽ� �߰� �ϸ�
					if (box[j][i] != null) {
						index = -1;
						for (int k = j + 1; k < 4; k++) {
							// ���⼭ Ȯ��
							if (box[k][i] != null) {
								break;
							}
							index = k;
						}
						// i+1 �� ���ڸ��� (null�̸�)�ű��.
						if (index != -1) {
							box[index][i] = box[j][i];
							box[index][i].setX(i);
							box[index][i].setY(index);
							box[j][i] = null;
						}
					}
				}
			}
		} else if (key == 'a') {
			// x=0 �� Ȯ����
			for (int i = 1; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (box[j][i] != null) {
						index = -1;
						// ���⼭
						for (int k = i - 1; k >= 0; k--) {
							if (box[j][k] != null) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							box[j][index] = box[j][i];
							box[j][index].setX(index);
							box[j][index].setY(j);
							box[j][i] = null;
						}
					}
				}
			}
		} else if (key == 'd') {
			// ������ ���� (x=3)��
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					if (box[j][i] != null) {
						index = -1;
						for (int k = j + 1; k < 4; k++) {
							// ���⼭ Ȯ��
							if (box[j][k] != null) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							box[j][index] = box[j][i];
							box[j][index].setX(j);
							box[j][index].setY(index);
							box[j][i] = null;
						}
					}
				}
			}
		}

	}

	public void sum(char c) {
		if (c == 'w') {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (box[j][i] != null) {
						for (int k = j + 1; k < 4; k++) {
							if (box[k][i] != null) {
								if (box[j][i] == box[k][i]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[k][i] = null;
								}
								break;
							}
						}
					}
				}
			}

		} else if (c == 's') {
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > 0; j--) {
					if (box[j][i] != null) {
						for (int k = j - 1; k >= 0; k++) {
							if (box[k][i] != null) {
								if (box[j][i] == box[k][i]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[k][i] = null;
								}
								break;
							}
						}
					}
				}
			}
		} else if (c == 'a') {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					if (box[j][i] != null) {
						for (int k = i + 1; k < 4; k++) {
							if (box[j][k] != null) {
								if (box[j][i] == box[j][k]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[j][k] = null;
								}
								break;
							}
						}
					}
				}
			}
		} else if (c == 'd') {
			for (int i = 3; i > 0; i--) {
				for (int j = 4; j > 0; j++) {
					if (box[j][i] != null) {
						for (int k = i - 1; k >= 0; k--) {
							if (box[j][k] != null) {
								if (box[j][i] == box[j][k]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[j][k] = null;
								}
								break;
							}
						}
					}
				}
			}
		}
		moveBox(c);
	}
}

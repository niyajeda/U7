public class Damenproblem {
private int n;
private int[][] feld;

public Damenproblem (int d) {
	this.n = d;
	this.feld = new int[d][d];
	for(int i = 0; i < d; i++){
		for(int j = 0; j < d; j++){
			this.feld[i][j] = 0;
		}
	}
}

public void ausgabe() {
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			System.out.print(this.feld[i][j] + " ");
		}
		System.out.print("\n");
	}
	System.out.println("---------------\n");
}

public boolean korrektPlatziert() {
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			if(this.feld[i][j] == 1){
				//Zeile durchsuchen
				for(int k = 0; k < n; k++){
					if(feld[i][k] == 1 && (k != j)) return false;
				}
				//Spalte durchsuchen
				for(int k = 0; k < n; k++){
					if(feld[k][j] == 1 && (k != i)) return false;
				}
				//Diagonalen durchsuchen
				//steigende Diagonale -- Summe der Diagonale ist immer i + j
				for(int k = 0; k < n; k++){
					for(int l = 0; l < n; l++){
						if((l+k) == (j+i) && feld[k][l] == 1 && (k != i) && (l != j)) return false; 
					}
				}
				//fallende Diagonale -- Spalte - Zeile ist immer j - i
				for(int k = 0; k < n; k++){
					for(int l = 0; l < n; l++){
						if((l-k) == (j-i) && feld[k][l] == 1 && (k != i) && (l != j)) return false; 
					}
				}
			}
		}
	}
	return true;
}

public void platziere(int i)
{
    for(int j = 0; j < n; j++)
    {
        feld[i][j] = 1;
        if(korrektPlatziert()){
            if(i == (n-1)) ausgabe();
            else platziere(i+1);
    	}
        feld[i][j] = 0;
    }
}


static public void main (String[] arg) {
	Damenproblem dOk = new Damenproblem(4);
	dOk.feld[1][0] = 1;
	dOk.feld[3][1] = 1;
	dOk.feld[0][2] = 1;
	dOk.feld[2][3] = 1;
	if (dOk.korrektPlatziert()) {
		System.out.println ("dOk ist eine mšgliche Loesung!:");
	}
	else {
		System.out.println ("dOk ist keine erlaubte Loesung:");
	}
	dOk.ausgabe();
	dOk.platziere(1);
	}
}
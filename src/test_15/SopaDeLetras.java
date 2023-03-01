package test_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SopaDeLetras {
	
	/*
	Ejemplos:
	
	S O L,U N O,N U T
	SUN,SOL,LOT,ONU,RAY
	
	C B C D E F,A N D R E A,M A M A G A,I S A H I J,L A K L M N,A L E J A O
	CAMILA,ANDREA,MAMA,ISA,NASA,ALEJA,ANA,AMA
	
	 */

	public static void main(String[] args) throws IOException {
		
		//recibe parametros
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineasSopa = br.readLine().split(",");
        String[] palabras = br.readLine().split(",");
        
        //Crea y sopa de letras
        HashMap<String, List<int[]>> letras = new  HashMap<String, List<int[]>>();
        int columns = lineasSopa[0].split(" ").length;
        int rows = lineasSopa.length;
        Letra[][] sopa = new Letra[rows][columns];
        
        for (int i = 0; i < lineasSopa.length; i++) {
			String[] a = lineasSopa[i].split(" ");
			
			for (int j = 0; j < a.length; j++) {
				sopa[i][j] = new Letra(a[j], j, i);
				int[] location = {i,j};
				List<int[]> temp = letras.get(a[j]);
				
				if(temp == null) {
					temp = new ArrayList<int[]>();
					
				}
				temp.add(location);
				letras.put(a[j], temp);
			}
		}
        
        
        //busca palabra
        for (int k = 0; k < palabras.length; k++) {
        	
        	String word = palabras[k];
        	System.out.println("Searching '"+word+"'");
   		 boolean find = false;
   		 List<int[]> temp = letras.get(word.charAt(0)+""); //lugares de inicio
   		 List<Letra> letrass = new ArrayList<Letra>();
   		 for (int i = 0; temp!= null && i < temp.size() && !find; i++) { 
   			 
   				 int initCol = temp.get(i)[1];
   				 int initRow = temp.get(i)[0];
   				 
   				 //derecha
   				 int posCol = initCol;
   				 int posRow = initRow;
   				 int posChar = 0;
   				 boolean interFlag = true;
   				 while(interFlag && !find && posCol<sopa[0].length) {
   					 String letterSoup = sopa[posRow][posCol].name;
   					 String letterWord = word.charAt(posChar)+"";
   					 if(letterSoup.equalsIgnoreCase(letterWord)) {
   						letrass.add(sopa[posRow][posCol]);
   						 find = posChar == word.length()-1;
   						 posChar++;
   					 }else {
   						 letrass = new ArrayList<Letra>();
   						 interFlag = false;
   					 }
   					 interFlag = interFlag && posChar < word.length();
   					 posCol++;
   				 }
   				 
   				 // izquierda
   				 if(!find) letrass = new ArrayList<Letra>();
   				 posCol = initCol;
   				 posRow = initRow;
   				 posChar = 0;
   				 interFlag = true;
   				 while(interFlag && !find && posCol > -1) {
   					 String letterSoup = sopa[posRow][posCol].name;
   					 String letterWord = word.charAt(posChar)+"";
   					 if(letterSoup.equalsIgnoreCase(letterWord)) {
   						letrass.add(sopa[posRow][posCol]);
   						 find = posChar == word.length()-1;
   						 posChar++;
   					 }else {
   						letrass = new ArrayList<Letra>();
   						interFlag = false;
   					 }
   					 interFlag = interFlag && posChar < word.length();
   					 posCol--;
   				 }
   				//arriba
   				 if(!find) letrass = new ArrayList<Letra>();
   				 posCol = initCol;
   				 posRow = initRow;
   				 posChar = 0;
   				 interFlag = true;
   				 while(interFlag && !find && posRow > -1) {
   					 String letterSoup = sopa[posRow][posCol].name;
   					 String letterWord = word.charAt(posChar)+"";
   					 if(letterSoup.equalsIgnoreCase(letterWord)) {
   						letrass.add(sopa[posRow][posCol]);
   						 find = posChar == word.length()-1;
   						 posChar++;
   					 }else {
   						letrass = new ArrayList<Letra>();
   						interFlag = false;
   					 }
   					 interFlag = interFlag && posChar < word.length();
   					 posRow--;
   				 }
   				 //abajo
   				 if(!find) letrass = new ArrayList<Letra>();
   				 posCol = initCol;
   				 posRow = initRow;
   				 posChar = 0;
   				 interFlag = true;
   				 while(interFlag && !find && posRow < sopa.length) {
   					 String letterSoup = sopa[posRow][posCol].name;
   					 String letterWord = word.charAt(posChar)+"";
   					 if(letterSoup.equalsIgnoreCase(letterWord)) {
   						letrass.add(sopa[posRow][posCol]);
   						 find = posChar == word.length()-1;
   						 posChar++;
   					 }else {
   						letrass = new ArrayList<Letra>();
   						interFlag = false;
   					 }
   					 interFlag = interFlag && posChar < word.length();
   					 posRow++;
   				 }
   		        	
   		 }
   	       
   		 if(find) {
   			 for (int i = 0; i < letrass.size(); i++) {
   				System.out.println(letrass.get(i).toString());
   			}
   		 }else {
   			 System.out.println("'"+word+"' Not found");
   		 }
		}
       
	}
	

}

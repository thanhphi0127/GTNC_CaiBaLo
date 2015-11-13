/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author NguyenThanh
 */

public class Balo {
    int B[][]; //Array for Dynamic 
    int w, k; 
    int remainingWeight;
    
    //Variable for Dynamic 2
    int F[][] = new int[30][500];
    int X[][] = new int[30][500];
    
    public Balo() {
    }
    private int partition(Dovat arr[], int left, int right){
        int i = left, j = right;
	Dovat tmp;
	Dovat pivot = arr[(left + right) / 2];

	while (i <= j) {
	    while (arr[i].dongia < pivot.dongia)
	        i++;
	    while (arr[j].dongia > pivot.dongia)
	        j--;
	        if (i <= j) {
	            tmp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = tmp;
	            i++;
	            j--;
	        }
	};
	      
	return i;
    }
	 
    private void quickSort(Dovat arr[], int left, int right){
	int index = partition(arr, left, right);
	if (left < index - 1)
	    quickSort(arr, left, index - 1);
	if (index < right)
	    quickSort(arr, index, right);
    }
	
    private void tinhdongia(Dovat sp[],int n){
        for(int i=0;i<n;i++)
            sp[i].dongia=sp[i].giatri/sp[i].trongluong;
    }
    
    private void Greedy(Dovat sp[],int n,float w){
        int numOfCurrentValue;
        for(int i=0;i<n;i++){
            numOfCurrentValue = (int)(w/sp[i].trongluong);  //Chọn số lượng đồ vật có đơn giá lớn nhất
            if(numOfCurrentValue > sp[i].soluong){           //Kiểm tra số lượng sẵn có nếu lớn hơn thì lấy TẤT CẢ
                sp[i].soluongChon = sp[i].soluong;
            }
            else {
                sp[i].soluongChon = numOfCurrentValue;
            }
            w -= sp[i].soluongChon*sp[i].trongluong;
        }
    }

    public String resultGreedy(Dovat sp[],int n){
        String result ="ĐỒ VẬT  |  SỐ LƯỢNG \r\n";
        float tongtl=0, tonggiatri=0;
        for(int i=0;i<n;i++)
            if(sp[i].soluongChon > 0){
                result += sp[i].ten + "       :       " +sp[i].soluongChon + "\r\n";
                tonggiatri  += sp[i].giatri*sp[i].soluongChon;
                tongtl      += sp[i].trongluong*sp[i].soluongChon;
            }
        result += "Tổng giá trị: " + tonggiatri + "\r\n";
        result += "Tổng trọng lượng: " + tongtl + "\r\n";
        return result;
    }
    
    public long timeToRunGreedy(Dovat dv[], int sl, int w){
        long start = System.nanoTime();
        tinhdongia(dv,sl);
        quickSort(dv,0,sl-1);
        Greedy(dv,sl,w);
        long end = System.nanoTime();
        return (end - start);  
    }
  
    public long timeToRunDynamic(Dovat dv[], int sl, int w){
        long start = System.nanoTime();
        Dynamic(dv,sl,w);
        long end = System.nanoTime();
        return (end - start);  
    }

    private void Dynamic(Dovat dv[], int numItems, int maxWeight) {
        int xk, yk;
        int FMax, XMax;
        //Cal value and quanlity for item 1
        for (int v=0;v<=maxWeight;v++){
            X[1][v] = Math.min(v/dv[1].trongluong, dv[1].soluong);
            F[1][v] = X[1][v] * dv[1].giatri;
        }
        //Cal value and quanlity for each items
        for(int k=2;k<=numItems;k++){
            X[k][0] = 0;
            F[k][0] = 0;
            for (int v=1; v <= maxWeight; v++) {
                FMax = F[k-1][v] ;
                XMax = 0;
                yk = Math.min(v/dv[k].trongluong, dv[k].soluong);
                for (xk=1; xk <= yk; xk++) 
                    if (F[k-1][v-xk*dv[k].trongluong]+  xk*dv[k].giatri > FMax) {
                        FMax=F[k-1][v-xk *dv[k].trongluong]+ xk*dv[k].giatri;
                        XMax= xk;
                    }
                F[k][v] = FMax;
                X[k][v] = XMax; 
            }
        }

    }
    
    //Test function
    public void PrintArray(){
            for(int j=0;j<9;j++){
                System.out.print("X["+(0)+"]["+(j+1)+"]    ");
            }
            System.out.println();
        
        for(int i=1;i<=5;i++){
            for(int j=0;j<=9;j++){
                System.out.print(F[i][j]+"|"+X[i][j]+ "        ");
            }
            System.out.println();
        }
    }
    
    public String resultDynamic(Dovat dv[], int n, int W){
        String result ="ĐỒ VẬT  |  SỐ LƯỢNG \r\n";
        float sumValue = 0;
	int k, v; 
	v = W;
	for (k = n; k >=1; k--) 
            if (X[k][v] > 0) {
                dv[k].soluongChon = X[k][v];
                result += dv[k].ten + "       :       " + dv[k].soluongChon + "\r\n";
                v = v - X[k][v] * dv[k].trongluong;
                sumValue += dv[k].giatri*dv[k].soluongChon;
            }
        result += "Tổng giá trị: " + sumValue + "\r\n";
        result += "Tổng trọng lượng: " + (W-v) + "\r\n";
        
        return result;
    } 
    
    public void getDataFromFile() throws IOException{
        String fileNameDefined = "src/Balo/Data_1.csv";
        // -File class needed to turn stringName to actual file
        File file = new File(fileNameDefined);

        try{
            // -read from filePooped with Scanner class
            Scanner inputStream = new Scanner(file);
            inputStream.useDelimiter(",");
            // hashNext() loops line-by-line
            while(inputStream.hasNext()){
                //read single line, put in string
                String data = inputStream.next();
                System.out.println(data + "");

            }
            // after loop, close scanner
            inputStream.close();
            
        }catch (FileNotFoundException e){

            e.printStackTrace();
        }
    }

}

/*

    private void Dynamic(Dovat dv[], int numItems, int maxWeight) {
        B = new int [numItems+1][maxWeight+1]; 
        for (w = 0; w <= maxWeight; w++){
            B[0][w] = 0;
        }
          
        for (k = 1; k <= numItems; k++){
            for (w = maxWeight; w >= dv[k].trongluong; w--)
                if ((dv[k].giatri + B[k-1][w-dv[k].trongluong]) > B[k-1][w]){
                    B[k][w] = dv[k].giatri + B[k-1][w-dv[k].trongluong];
                }
                
                else{
                    B[k][w] = B[k-1][w];
                }
                for (w = 0; w < dv[k].trongluong; w++){
                    B[k][w] = B[k-1][w];
                }
        }
    }
    
    public String resultDynamic(Dovat dv[],int numItems, int maxWeight){
        String result ="";
        result += "Items used:";
        for (k = numItems, remainingWeight = maxWeight; k > 0; k--){
            if (remainingWeight >= dv[k].trongluong)
                if ( B[k][remainingWeight] == (dv[k].giatri + B[k-1][remainingWeight - dv[k].trongluong]) ){
                    result += dv[k].giatri+ "  " + k + "\r\n";
                    remainingWeight -= dv[k].trongluong;
                }
        }
        result += "Max benefit = " + B[numItems][maxWeight];
        return result;
    }

    
    private void sapxep(Dovat sp[],int n){
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(sp[i].dongia < sp[j].dongia){
                    Dovat temp=sp[i];
                    sp[i]=sp[j];
                    sp[j]=temp;
                }
    }
*/
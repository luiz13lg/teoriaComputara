/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabteoria;

/**
 *
 * @author Luiz
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numA[];
        int numB[];
        int soma[];
        
        numA = iniciaReg(-6);
        numB = iniciaReg(6);
        
        soma = somaReg(numA, numB);
        
        System.out.println(soma[0]);
        System.out.println(soma[1]);
    }
    
    private static int[] iniciaReg(int num){
        int auxNum[] = new int[2];
        
        if(num >= 0){ 
            auxNum[0] = 1;
            auxNum[1] = num;
        }
        else{ 
            auxNum[0] = 0;
            auxNum[1] = Math.abs(num);
        }
        
        return auxNum;
    }
    
    private static int[] somaReg(int[] A, int [] B){
        if(A[0] == 0 && B[0] == 0){  //dois negativos
            while(true){
                if(B[1] == 0) break;
                A[1]++;
                B[1]--;
            }
            return A;
        }
        
        if(A[0] == 0 || B[0] == 0){  //um positivo
            if(B[0] == 0){   //B negativo
                while(true){
                    if(B[1] == 0) break;
                    A[1]--;
                    B[1]--;
                    if(A[1] == 0){
                        A[0]--;
                        while(true){
                            if(B[1] == 0) break;
                            A[1]++;
                            B[1]--;
                        }
                    }
                }
                return A;
            }else{   //A negativo
                while(true){
                    if(B[1] == 0) break;
                    A[1]--;
                    B[1]--;
                    if(A[1] == 0){
                        A[0]++;
                        while(true){
                            if(B[1] == 0) break;
                            A[1]++;
                            B[1]--;
                        }
                    }
                }
                return A;
            }
        }
        
        while(true){    //dois negativos
                if(B[1] == 0) break;
                A[1]++;
                B[1]--;
            }
        return A;
    }
    
}

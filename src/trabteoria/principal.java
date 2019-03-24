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
        
        numA = iniciaReg(-5);
        numB = iniciaReg(-4);

        if(compReg(numA,numB) == 0) System.out.println("A é maior");
            else System.out.println("B é maior");
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
    
    private static short compReg(int[] A, int [] B){    //se 0 A é maior, se 1 B é maior
        if(A[0] == 0 && B[0] == 0){ //dois negativos
            while(true){
                A[1]--;
                B[1]--;
                if(A[1] == 0) return 0; //A é maior
                if(B[1] == 0) return 1; //B é maior
            }
        }
        
        if(A[0] == 0 || B[0] == 0){  //um dos dois é negativo
            if(A[0] == 0) return 1;
            else return 0;
        }
        
        while(true){
            A[1]--;
            B[1]--;
            if(A[1] == 0) return 1; //B é maior
            if(B[1] == 0) return 0; //A é maior
        }
    }
    
    private static int[] somaRegP(int[] A, int [] B){
        int C = 0;
        
        if(A[0] == 0 && B[0] == 0){  //dois negativos
            while(true){
                if(B[1] == 0) break;
                C++;
                A[1]++;
                B[1]--;
            }
            while(true){
                if(C == 0) break;
                C--;
                B[1]++;
            }
            return A;
        }
        
        if(A[0] == 0 || B[0] == 0){  //um positivo
            if(B[0] == 0){   //B negativo
                while(true){
                    if(B[1] == 0) break;
                    A[1]--;
                    B[1]--;
                    C++;
                    if(A[1] == 0){
                        A[0]--;
                        while(true){
                            if(B[1] == 0) break;
                            C++;
                            A[1]++;
                            B[1]--;
                        }
                    }
                }
                while(true){
                    if(C == 0) break;
                    C--;
                    B[1]++;
                }
                return A;
            }else{   //A negativo
                while(true){
                    if(B[1] == 0) break;
                    A[1]--;
                    B[1]--;
                    C++;
                    if(A[1] == 0){
                        A[0]++;
                        while(true){
                            if(B[1] == 0) break;
                            A[1]++;
                            B[1]--;
                            C++;
                        }
                    }
                }
                while(true){
                    if(C == 0) break;
                    C--;
                    B[1]++;
                }
                return A;
            }
        }
        
        while(true){    //dois negativos
                if(B[1] == 0) break;
                A[1]++;
                B[1]--;
                C++;
            }
        while(true){
            if(C == 0) break;
            C--;
            B[1]++;
        }
        return A;
    }
    
}

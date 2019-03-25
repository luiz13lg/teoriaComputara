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
        
        numA = iniciaReg(10);
        numB = iniciaReg(6);
        
        numA = restoDivReg(numA, numB);

        System.out.println(numA[0]);
        System.out.println(numA[1]);
    }
    
    private static int[] iniciaReg(int num){
        int auxNum[] = new int[2];
        
        if(num >= 0){
            auxNum[0] = 0;
            auxNum[1] = num;
        }
        else{
            auxNum[0] = 1;
            auxNum[1] = Math.abs(num);
        }

        return auxNum;
    }
    
    private static int[] somaReg(int[] A, int [] B){
        if(A[0] == 0 && B[0] == 0){  //dois positivos
            while(true){
                if(B[1] == 0) break;
                A[1]++;
                B[1]--;
            }
            return A;
        }
        
        if(A[0] == 0 || B[0] == 0){  //um positivo
            if(B[0] == 0){   //B positivo
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
            }else{   //A positivo
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
        if(A[0] == 0 && B[0] == 0){ //dois positivos
            while(true){
                A[1]--;
                B[1]--;
                if(A[1] == 0) return 1; //A é maior
                if(B[1] == 0) return 0; //B é maior
            }
        }
        
        if(A[0] == 0 || B[0] == 0){  //um dos dois é negativo
            if(A[0] == 1) return 0;
            else return 1;
        }
        
        while(true){    //dois negativos
            A[1]--;
            B[1]--;
            if(A[1] == 0) return 0; //A é maior
            if(B[1] == 0) return 1; //B é maior
        }
    }
    
    private static int[] somaRegP(int[] A, int [] B){
        int C = 0;
        
        if(A[0] == 0 && B[0] == 0){  //dois positivos
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
            if(B[0] == 0){   //B positivo
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
            }else{   //A positivo
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
        
        while(true){    //dois positivos
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

    private static int[] multReg(int[]A, int[] B){
        int C[] = new int[2];
        C[1]=0;
        while(true){
            C[1]++;
            A[1]--;
            if(A[1]==0)break;
        }
        while(true){
            A[1]=A[1]+B[1];
            C[1]--;
            if(C[1]==0)break;
        }
        if((A[0] == 0 && B[0] == 0)||(A[0] == 1 && B[0] == 1)){
            A[0]=0;
        }else
            A[0]=1;
        return A;
    }

    private static int[] restoDivReg(int[]A, int[] B){
        
    }
    
    private static int[] subReg(int[] A, int[] B){
        if(A[0] == 0 && B[0] == 0){  //dois positivos
            while(true){
                if(B[1] == 0) break;
                A[1]--;
                B[1]--;
                if(A[1] == 0){
                    A[0]++;
                    while(true){
                        A[1]++;
                        B[1]--;
                        if(B[1] == 0) break;
                    }
                    break;
                }
            }
            return A;
        }
        
        if(A[0] == 0 || B[0] == 0){  //um positivo
            if(B[0] == 0){   //B positivo
                while(true){
                    if(B[1] == 0) break;
                    A[1]++;
                    B[1]--;
                    }
                return A;
            }else{   //A positivo
                while(true){
                    if(B[1] == 0) break;
                    A[1]++;
                    B[1]--;
                    }
                return A;
            }    
        }
        while(true){    //dois negativos
            if(B[1] == 0) break;
            A[1]--;
            B[1]--;
            if(A[1] == 0){
                A[0]--;
                while(true){
                    A[1]++;
                    B[1]--;
                    if(B[1] == 0) break;
                }
            }
        }
        return A;
    }
    
    private static int[] potenReg(int[]A, int[] B){
        int[] C = new int[2];
        int[] D = new int[2];
        
        C[1] = 0;
        D[1] = 0;
        
        if(A[0] == 0){  //A positivo
            while(true){
                C[1]++;    
                D[1]++;    
                A[1]--;
                if(A[1]==0)break;
            }
            while(true){
                B[1]--;
                if(B[1]==0)break;
                C[1] = multReg(C, D)[1];
            }
            return C;
        }

        C[0]++; //negativando
        D[0]++; //
        
        while(true){
            C[1]++;    
            D[1]++;    
            A[1]--;
            if(A[1]==0)break;
        }
        while(true){
            B[1]--;
            if(B[1]==0)break;
            C = multReg(C, D);
        }
        return C;
    }
    
    private static int[] fatReg(int[] A){
        int[] C = new int[2];
        int[] D = new int[2];
        C[1] = D[1] = 0;
        
        while(true){
            if(A[1] == 0) break;
            A[1]--;
            C[1]++;
            D[1]++;
        }
        D[1]--;
        while(true){
            if(D[1] == 0) break;
            C[1] = multReg(C,D)[1];
            D[1]--;
        }
        
        return C;
    }
    
}

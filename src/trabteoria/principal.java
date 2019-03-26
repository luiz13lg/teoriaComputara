package trabteoria;

/**
 *
 * @author Luiz & Coutoboy
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numA[];
        int numB[];
        
        numA = iniciaReg(11);
        numB = iniciaReg(2);
        
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
    
    private static short compReg(int[] A, int [] B){    //se 0 A é maior ou igual, se 1 B é maior     
        if(A[0] == 0 && B[0] == 0){ //dois positivos
            while(true){
                A[1]--;
                B[1]--;
                if(A[1] == 0 && B[1] == 0) return 0; //iguais
                if(A[1] == 0) return 1; //B é maior
                if(B[1] == 0) return 0; //A é maior
            }
        }
        
        if(A[0] == 0 || B[0] == 0){  //um dos dois é negativo
            if(A[0] == 1) return 1;
            else return 0;
        }
        
        while(true){    //dois negativos
            A[1]--;
            B[1]--;
            if(A[1] == 0 && B[1] == 0) return 0;
            else if(A[1] == 0) return 0; //A é maior
                else return 1; //B é maior
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
        int auxA[],auxB[], aux2A[], aux2B[];
        
        auxA = copiaReg(A);
        auxB = copiaReg(B);
        
        if(compReg(auxA, auxB) == 0){   //A maior que B
            if(A[0] == 0 && B[0] == 0){  //dois positivos
                while(true){
                    aux2A = copiaReg(A);
                    aux2B = copiaReg(B);
                    A = subReg(aux2A, aux2B);
                    aux2A = copiaReg(A);
                    aux2B = copiaReg(B);
                    if(A[1] == 0) return A; //divisão exata
                    else if(compReg(aux2A,aux2B) == 0) continue;
                    else return A;
                }
            }
            else if(A[0] == 0){ // B negativo
                B[0]--;
                while(true){
                    A = subReg(A, B);
                    aux2A = copiaReg(A);
                    aux2B = copiaReg(B);
                    if(compReg(aux2A, aux2B) == 0) continue;
                    else{
                        A = somaReg(A, B);
                        A[0]++;
                        return A;
                    }
                }
            }
        }
        else{  //B maior que A
            if(A[0] == 0)   //A positivo menor que B
                return A;
            else if(B[0] == 0){   //A negativo B positivo
                A[0]--;
                while(true){
                    A = subReg(A, B);
                    aux2A = copiaReg(A);
                    aux2B = copiaReg(B);
                    if(compReg(aux2A, aux2B) == 0) continue;
                    else{
                        A = somaReg(A, B);
                        A[0]++;
                        return A;
                    }
                }
            }
            else{   //dois negativos
                A[0]--; B[0]--;
                while(true){
                    A = subReg(A, B);
                    aux2A = copiaReg(A);
                    aux2B = copiaReg(B);
                    if(compReg(aux2A, aux2B) == 0) continue;
                    else{
                        A = somaReg(A, B);
                        A[0]++;
                        return A;
                    }
                }
            }
        }
        return A;
    }
    
    private static int[] copiaReg(int[] A){
        int[] a = new int [2];
        int[] aa = new int [2];
        a[0] = aa[0] = a[1] = aa[1] = 0;
        
        if(A[0] == 0){  //sinal
            a[0] = 0;
        } else{
            a[0]++;
        }
        
        while(true){    //magnetide
            if(A[1] == 0) break;
            a[1]++;
            aa[1]++;
            A[1]--;
        }
        
        while(true){
            if(aa[1]==0) break;
            A[1]++;
            aa[1]--;
        }
        
        return a;
    }
    
    private static int[] subReg(int[] A, int[] B){
        if(A[0] == 0 && B[0] == 0){  //dois positivos
            while(true){
                A[1]--;
                B[1]--;
                if(B[1] == 0) break;
                if(A[1] == 0 && B[1] == 0) break;
                else if(A[1] == 0){
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
            if(A[1] == 0 && B[1] == 0) break;
            else if(A[1] == 0){
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

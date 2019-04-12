package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,11,1 , Direction.NORTH,0);
            boolean caja_1[][] = new boolean[10][10];
            boolean caja_2[][] = new boolean[10][10];
            Recojer_objetos(caja_1);
            Cambiar_sentido_objetos(caja_1,caja_2);
            Dejar_objetos(caja_2);
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }
        public static void girar_derecha (){
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            }
        public static void media_vuelta (){
            estudiante.turnLeft();
            estudiante.turnLeft();
            
            }
        public static void moverNcasillas (int n){
            for(int i=0;i<n;i++){
            estudiante.move();
            }
        }
        public static void recogerPeriodico (){
            girar_derecha();
            for(int i=0;i<3;i++){
            moverNcasillas(1);
            estudiante.turnLeft();
            }
            
            boolean Hay_Objeto=estudiante.canPickThing();
            if(Hay_Objeto==true){
                estudiante.pickThing();
            }
            estudiante.turnLeft();
            for(int i=0;i<3;i++){
            moverNcasillas(1);
            girar_derecha();
            }
            }
        public static void Espiral (int n){
        for(int i=n; i!=0;i--){
            for(int k=0; k<2;k++){
                moverNcasillas(i);
            girar_derecha();
            }
                }
        }
        public static void Reordenar (){
        for(int i=0;i<5;i++){
        moverNcasillas(1);
        estudiante.turnLeft();
        boolean Hay_objeto=estudiante.canPickThing();
        while(Hay_objeto==true){
        estudiante.pickThing();
        Hay_objeto=estudiante.canPickThing();
        }
        int objetos=estudiante.countThingsInBackpack();
        if(objetos>0){
        for(int k=0;k<objetos;k++){
            moverNcasillas(1);
            estudiante.putThing();                  
        }
        media_vuelta();
        moverNcasillas(objetos);
        estudiante.turnLeft();
        }else{
        girar_derecha();
        }
        }
        }
        public static void Recojer_objetos(boolean matriz [][]){
            for(int i=0; i<10;i++){
            moverNcasillas(1);
            girar_derecha();
            for(int k=0;k<10;k++){
                matriz [i][k]=estudiante.canPickThing();
                if (matriz[i][k]==true){
                    estudiante.pickThing();
                }
                if(k!=9){
                moverNcasillas(1);
                }
                }
            media_vuelta();
            moverNcasillas(9);   
            girar_derecha();
            }
            media_vuelta();
            moverNcasillas(10);
            media_vuelta();
            
        }
        public static void Dejar_objetos (boolean matriz1 [][]){     
            for(int i=0; i<10;i++){
            moverNcasillas(1);
            girar_derecha();
            for(int k=0;k<10;k++){
                if (matriz1[i][k]==true){
                    estudiante.putThing();
                }
                if(k!=9){
                moverNcasillas(1);
                }
                }
            media_vuelta();
            moverNcasillas(9);   
            girar_derecha();
            }
            media_vuelta();
            moverNcasillas(10);
            media_vuelta();      
        }
        
        public static void Cambiar_sentido_objetos (boolean matriz[][],boolean matriz_cambiada[][]){
            for(int i=0; i<10;i++){
            for(int k=0;k<10;k++){
                int posicion_contraria=9-k;
                if (matriz[i][k]==true){
                    matriz_cambiada[i][posicion_contraria]=true;
               }else{
                   matriz_cambiada[i][posicion_contraria]=false; 
                }
        }
        }
        } 
}
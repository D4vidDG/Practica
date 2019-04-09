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
            estudiante = new Robot(objetos,1,1 , Direction.SOUTH,0);
            Reordenar();
	    //Mover una interseccion en el sentido al cual este apuntando el objeto.
            
            //Girar a la izquierda
           
            
            
            /*
            //Tomando decisiones, Si puedo tomar un Thing
            boolean puedeTomar = estudiante.canPickThing();
            
            //Tomar un Thing
            if(puedeTomar == true)
               estudiante.pickThing();
            
            //Especifica el numero de Thing que tiene en robot en el bolso
            int numeroThings = estudiante.countThingsInBackpack();
            
            //Poner Thing, se debe validar que tenga things en el bolso
            estudiante.putThing();
                       
            //Si el frente esta libre de Wall
            estudiante.frontIsClear();
            
            //Invocando una funcion
            creacionFuncion(4);
            
            //Toman un Thing
            estudiante.pickThing();
            
        */    
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
        }
        

        
        
        
        




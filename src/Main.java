import objects.Nodo;

import javax.swing.JFrame;

public class Main {

    static Nodo nodoA, nodoB, nodoC, nodoD, nodoE, nodoF, nodoG, nodoH, nodoI, nodoJ, nodoK, nodoL, nodoM, nodoN, nodoO;

    static float total = 0;
    static float casas = 0;
    static String log = "";

    static View frame;

    public static void main(String[] args)
    {


        frame = new View();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);

        initTree();

        total = 0;
        casas = 0;
        desconectarNodo(nodoA, 'D');

        System.out.println("Casas " + casas);
        System.out.println("Total dinero " + total);
    }

    public static void desconectarNodo(Nodo nodo, char id){

        if(nodo.getId() == id){
            System.out.println("Se desconecta el nodo " + nodo.getId());

            log = log + "\n Se desconecta la casa " + nodo.getId();
            total = total + (nodo.getCasas() * 150);
            casas = casas + nodo.getCasas();

            if(nodo.getNodo1()!=null){
                desconectarNodo(nodo.getNodo1(), nodo.getNodo1().getId());
                desconectarNodo(nodo.getNodo2(), nodo.getNodo2().getId());
            }
        }else{
            if(nodo.getNodo1()!=null){
                desconectarNodo(nodo.getNodo1(),id);
                desconectarNodo(nodo.getNodo2(),id);
            }
        }
    }

    private static void initTree(){
        frame.inicio();
        nodoA = new Nodo('A',null,null,1,0, frame.crearNodo('A', 80, 0));
        nodoB = new Nodo('B',null,null,2,7, frame.crearNodo('B', 40, 10));
        nodoC = new Nodo('C',null,null,2,5, frame.crearNodo('C', 120, 10));
        nodoD = new Nodo('D',null,null,3,3, frame.crearNodo('D', 20, 20));
        nodoE = new Nodo('E',null,null,3,8,frame.crearNodo('E', 60, 20));
        nodoF = new Nodo('F',null,null,4,9,frame.crearNodo('F', 10, 30));
        nodoG = new Nodo('G',null,null,4,10,frame.crearNodo('G', 30, 30));
        nodoH = new Nodo('H',null,null,4,2,frame.crearNodo('H', 50, 30));
        nodoI = new Nodo('I',null,null,4,4,frame.crearNodo('I', 70, 30));
        nodoJ = new Nodo('J',null,null,3,0,frame.crearNodo('J', 100, 20));
        nodoK = new Nodo('K',null,null,3,0,frame.crearNodo('K', 140, 20));
        nodoL = new Nodo('L',null,null,4,10,frame.crearNodo('L', 90, 30));
        nodoM = new Nodo('M',null,null,4,6,frame.crearNodo('M', 110, 30));
        nodoN = new Nodo('N',null,null,4,10,frame.crearNodo('N', 130, 30));
        nodoO = new Nodo('O',null,null,4,10,frame.crearNodo('O', 150, 30));
        frame.fin();

        nodoD.setNodo1(nodoF);
        nodoD.setNodo2(nodoG);
        frame.unirNodos(nodoD.getUi(), nodoF.getUi());
        frame.unirNodos(nodoD.getUi(), nodoG.getUi());

        nodoE.setNodo1(nodoH);
        nodoE.setNodo2(nodoI);
        frame.unirNodos(nodoE.getUi(), nodoH.getUi());
        frame.unirNodos(nodoE.getUi(), nodoI.getUi());

        nodoB.setNodo1(nodoD);
        nodoB.setNodo2(nodoE);
        frame.unirNodos(nodoB.getUi(), nodoD.getUi());
        frame.unirNodos(nodoB.getUi(), nodoE.getUi());

        nodoJ.setNodo1(nodoL);
        nodoJ.setNodo2(nodoM);
        frame.unirNodos(nodoJ.getUi(), nodoL.getUi());
        frame.unirNodos(nodoJ.getUi(), nodoM.getUi());

        nodoK.setNodo1(nodoN);
        nodoK.setNodo2(nodoO);
        frame.unirNodos(nodoK.getUi(), nodoN.getUi());
        frame.unirNodos(nodoK.getUi(), nodoO.getUi());

        nodoC.setNodo1(nodoJ);
        nodoC.setNodo2(nodoK);
        frame.unirNodos(nodoC.getUi(), nodoJ.getUi());
        frame.unirNodos(nodoC.getUi(), nodoK.getUi());

        nodoA.setNodo1(nodoB);
        nodoA.setNodo2(nodoC);
        frame.unirNodos(nodoA.getUi(), nodoB.getUi());
        frame.unirNodos(nodoA.getUi(), nodoC.getUi());
    }
}


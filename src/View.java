import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.model.mxGeometry;

public class View extends JFrame
{

    /**
     *
     */
    private static final long serialVersionUID = -2707712944901661771L;
    private mxGraph graph = new mxGraph(){

        // Ports are not used as terminals for edges, they are
        // only used to compute the graphical connection point
        public boolean isPort(Object cell)
        {
            mxGeometry geo = getCellGeometry(cell);

            return (geo != null) ? geo.isRelative() : false;
        }

        // Implements a tooltip that shows the actual
        // source and target of an edge
        public String getToolTipForCell(Object cell)
        {
            if (model.isEdge(cell))
            {
                //return convertValueToString(model.getTerminal(cell, true)) + " -> " +
                        //convertValueToString(model.getTerminal(cell, false));
                return "Hola";
            }

            return super.getToolTipForCell(cell);
        }

        // Removes the folding icon and disables any folding
        public boolean isCellFoldable(Object cell, boolean collapse)
        {
            return false;
        }
    };
    private Object parent = graph.getDefaultParent();

    public void inicio(){
        graph.getModel().beginUpdate();
    }

    public Object crearNodo (char letra, double x, double y){
        Object v1 = graph.insertVertex(parent, null, letra, x * 10, y * 10, 50, 50);
        return v1;
    }

    public void unirNodos(Object nodo1, Object nodo2){
        graph.insertEdge(parent, null, "", nodo1, nodo2);
    }

    public void fin(){
        graph.getModel().endUpdate();
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }
}
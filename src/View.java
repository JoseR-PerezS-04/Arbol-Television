import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.model.mxGeometry;

public class View extends JFrame
{

    private static final long serialVersionUID = -2707712944901661771L;
    private mxGraph graph = new mxGraph(){
        public boolean isPort(Object cell){
            mxGeometry geo = getCellGeometry(cell);
            return (geo != null) ? geo.isRelative() : false;
        }
        public String getToolTipForCell(Object cell)
        {
            if (model.isEdge(cell))
            {
                return "";
            }
            return super.getToolTipForCell(cell);
        }
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
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
	        @Override        
	        public void mousePressed(MouseEvent e) {
	            Object cell = graphComponent.getCellAt(e.getX(), e.getY());            
	            if (cell != null) {
	                Main.estimateNodeDisconection(graph.getLabel(cell));
	            }
	        }    
        });
        getContentPane().add(graphComponent);
    }
}
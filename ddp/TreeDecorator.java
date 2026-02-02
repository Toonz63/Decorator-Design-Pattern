package ddp;
import java.util.ArrayList;
/**
 * Description: This is the abstract TreeDecorator class that serves as a base for all tree decorators.
 * @author Phoenix Toon
*/
public abstract class TreeDecorator extends Tree {
    /**
     * Description: Constructor for the TreeDecorator class.
     * @param lines The lines representing the tree.
     */
    public TreeDecorator(ArrayList<String> lines) {
        super(lines);
    }
    /**
     * Description: Integrates decoration lines into the tree lines.
     * @param decor The lines representing the decoration.
     */
    protected void integrateDecor(ArrayList<String> decor){
        for(int i = 0; i < lines.size(); i++){ 
            String treeLine = lines.get(i);
            String decorLine = i < decor.size() ? decor.get(i) : "";
            StringBuilder newLine = new StringBuilder();
            for(int j = 0; j < treeLine.length(); j++){
                char decorChar = j < decorLine.length() ? decorLine.charAt(j) : ' ';
                if(decorChar != ' '){
                    newLine.append(decorChar);
                } else {
                    newLine.append(treeLine.charAt(j));
                }
            }
            lines.set(i, newLine.toString());
        }
    }
}
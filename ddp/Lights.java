package ddp;
import java.util.ArrayList;
/**
 * Description: This class represents a Lights decoration for the tree. 
 * Author: Phoenix Toon
 */
public class Lights extends TreeDecorator {
    private Tree tree;
    /**
     * Description: Constructor for the Lights class.
     * @param tree The tree to be decorated with lights.
     */
    public Lights(Tree tree) {
        super(tree.lines);
        this.tree = tree;
        ArrayList<String> lightLines = FileReader.getLines("lights.txt");
        integrateDecor(lightLines);
    }
}
package ddp;
import java.util.ArrayList;
/**
 * Description: This class represents an Ornaments decoration for the tree.
 * Author: Phoenix Toon
 */
public class Ornaments extends TreeDecorator {
    private Tree tree;
    /**
     * Description: Constructor for the Ornaments class.
     * @param tree The tree to be decorated with ornaments.
     */
    public Ornaments(Tree tree) {
        super(tree.lines);
        this.tree = tree;
        ArrayList<String> ornamentLines = FileReader.getLines("ornaments.txt");
        integrateDecor(ornamentLines);
    }
}
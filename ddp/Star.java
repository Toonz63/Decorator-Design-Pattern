package ddp;
import java.util.ArrayList;
/**
 * Description: This class represents a Star decoration for the tree.
 * Author: Phoenix Toon
 */
public class Star extends TreeDecorator {
    private Tree tree;
    /**
     * Description: Constructor for the Star class.
     * @param tree The tree to be decorated with a star.
     */
    public Star(Tree tree) {
        super(tree.lines);
        this.tree = tree;
        ArrayList<String> starLines = FileReader.getLines("star.txt");
        integrateDecor(starLines);
    }
}
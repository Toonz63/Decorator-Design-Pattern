package ddp;
/**
 * Description: This class represents a Spruce Tree.
 * Author: Phoenix Toon
 */ 
public class SpruceTree extends Tree {
    /**
     * Description: Constructor for the SpruceTree class.
     */
    public SpruceTree() {
        super(FileReader.getLines("ddp/spruce-tree.txt"));
    }
}
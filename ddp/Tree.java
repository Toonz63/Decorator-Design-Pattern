package ddp;
import java.util.ArrayList;
/**
 * Description: This is the abstract Tree class that provides the base functionality for tree decorations.
 * @author Phoenix Toon
*/
public abstract class Tree {
    private static final String RESET = "\033[0m";  // Text Reset
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String WHITE = "\033[0;37m";   // WHITE
    private static final String RED = "\033[0;31m";     // RED
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BROWN = "\u001B[38;2;139;69;19m"; // RGB: 139, 69, 19
    protected ArrayList<String> lines;
    private int markerScanDistance = 5;
    /**
     * Description: Constructor for the Tree class.
     * @param lines The lines representing the tree.
     */
    public Tree(ArrayList<String> lines) {
        this.lines = lines;
    }
    /**
     * Description: how far a marker will look forward to find a group to color.
     * @param distance The distance to set.
     */
    public void setMarkerScanDistance(int distance) {
        if (distance < 0) throw new IllegalArgumentException("markerScanDistance must be >= 0");
        this.markerScanDistance = distance;
    }
    /**
     * Description: Gets the marker scan distance.
     * @return The marker scan distance.
     */
    public int getMarkerScanDistance() {
        return markerScanDistance;
    }
    /**
     * Description: Converts the tree to a string with colors applied based on markers.
     * @return The string representation of the tree with colors applied.
     */
    public String toString() {
        if (lines == null || lines.isEmpty()) {
            ArrayList<String> fallback = FileReader.getLines("spruce-tree.txt");
            if (fallback == null || fallback.isEmpty()) {
                fallback = FileReader.getLines("ddp/spruce-tree.txt");
            }
            if (fallback != null && !fallback.isEmpty()) {
                lines = fallback;
            }
        }
        StringBuilder sb = new StringBuilder(); //CBT
        String colorCodes = "RGBYW";
        boolean greenAll = false;
        boolean brownTrunk = false;
        for (String l : lines) {
            if (l.indexOf('G') >= 0) greenAll = true;
            if (l.indexOf('B') >= 0) brownTrunk = true;
        }
        for (String line : lines) {
            boolean isTrunkLine = line.indexOf('|') >= 0;
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                String color = null;
                if (c == 'R') color = RED;
                else if (c == 'G') color = GREEN;
                else if (c == 'B') color = BROWN;
                else if (c == 'Y') color = YELLOW;
                else if (c == 'W') color = WHITE;
                if (color != null) {
                    int j = i + 1;
                    int spacesBetween = 0;
                    while (j < line.length() && line.charAt(j) == ' ') {
                        spacesBetween++;
                        j++;
                    }
                    StringBuilder group = new StringBuilder();
                    while (j < line.length() && line.charAt(j) != ' ' && colorCodes.indexOf(line.charAt(j)) == -1) {
                        group.append(line.charAt(j));
                        j++;
                    }
                    if (group.length() > 0) {
                        out.append(' ');
                        for (int k = 0; k < spacesBetween; k++) out.append(' ');
                        out.append(color).append(group.toString()).append(RESET);
                        i = j - 1;
                        continue;
                    }
                    out.append(' ');
                    continue;
                }
                if (greenAll && (c == '/' || c == '\\' || c == '-' || c == '<' || c == '>' || c == '_')) {
                    out.append(GREEN).append(c).append(RESET);
                } else if (brownTrunk && isTrunkLine && (c == '|' )) {
                    out.append(BROWN).append(c).append(RESET);
                } else {
                    out.append(c);
                }
            }
            sb.append(out.toString()).append("\n");
        }
        return sb.toString();
    }
}
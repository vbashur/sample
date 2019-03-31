package com.vbashur.backtracking.stackboxes;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by vic on 3/31/19.
 */
public class Solution2 {

    public static class Box {
        int w;
        int h;
        int d;
        String name; // for test purposes

        public Box(String name, int w, int h, int d ) {
            this.w = w;
            this.h = h;
            this.d = d;
            this.name = name;
        }

        public boolean less( Solution2.Box other ) {

            int[] thisBox = new int[] { this.d, this.h, this.w };
            int[] otherBox = new int[] { other.d, other.h, other.w };
            for( int i = 0; i < thisBox.length; ++i ) {
                if( thisBox[i] >= otherBox[i] ) return false;
            }
            return true;
        }

        public String toString() {
            return name;
        }
    }

    public static class Trie {
        LinkedHashMap<Box, List<Box>> boxes = new LinkedHashMap<>();

        Box root;

        boolean tryAdd(Box box) {
            if (root == null) {
                root = box;
                boxes.put(root, new LinkedList<>());
                return true;
            }
            return tryAddHelper(box, root);
        }

        private boolean tryAddHelper(Box addedBox, Box smallerBox) {
            if (addedBox.less(smallerBox)) {
                LinkedList childBoxes = new LinkedList<>();
                childBoxes.add(smallerBox);
                boxes.put(addedBox, childBoxes);
                if (addedBox.less(root)) root = addedBox;
            }
            if (smallerBox.less(addedBox)) {
                for (Box childBox : boxes.get(smallerBox)) {
                    tryAddHelper(addedBox, childBox);
                }
                boxes.get(smallerBox).add(addedBox);
            }
            boxes.put(addedBox, new LinkedList<>());
            return true;
        }

        int getMaxDepth() {
            Box root = getRootItem();
            if (root == null) return 0;
            return getMaxDepthHelper(1, boxes.get(root));

        }

        private int getMaxDepthHelper(int counter, List<Box> childBoxes) {
            int max = counter;
            for (Box b : childBoxes) {
                int localDepth = getMaxDepthHelper(++counter, boxes.get(b));
                max = Math.max(max, localDepth);
            }
            return max;
        }

        private Box getRootItem() {
            if (boxes.isEmpty()) return null;
            return boxes.entrySet().iterator().next().getKey();
        }

    }

    public int getStackedBoxes( Box[] boxes ) {
        Trie boxTrie = new Trie();
        for (int i = 0; i < boxes.length; ++i) {
            boxTrie.tryAdd(boxes[i]);
        }
        return boxTrie.getMaxDepth();
    }


}

package com.vbashur.backtracking.stackboxes;

import java.util.*;

/**
 * Created by vic on 3/31/19.
 */
public class Solution2 {

    public static void main(String args) {

        Solution2.Box matches = new Solution2.Box("matches", 5, 2, 1 );
        Solution2.Box microwave = new Solution2.Box("microwave", 50, 40, 30 );
        Solution2.Box owen = new Solution2.Box("owen", 51, 41, 31 );
        Solution2.Box tv = new Solution2.Box("tv", 150, 20, 100 );
        Solution2.Box ski = new Solution2.Box("ski", 300, 40, 20 );
        Solution2.Box ipad = new Solution2.Box("ipad", 30, 20, 1 );
        Solution2 s = new Solution2();
        int res = s.getStackedBoxes( new Solution2.Box[]{ipad, ski, owen, matches, tv, microwave} );
        System.out.println("expected is 3, actual is " + res);
    }

    public int getStackedBoxes(Box[] boxes) {

        PriorityQueue<Box> priorityQueue = new PriorityQueue<>(boxMinPQComparator);

        for (int i = 0; i < boxes.length; ++i) {
            priorityQueue.add(boxes[i]);
        }
        List<Trie> tries = new LinkedList<>();
        while (priorityQueue.hasItems()) {
            Box minSizeBox = priorityQueue.poll();
            for (Trie tr : tries) {
                tr.tryAdd(minSizeBox);
            }
            Trie newTrie = new Trie();
            newTrie.tryAdd(minSizeBox);
            tries.add(newTrie);
        }
        int max = Integer.MIN_VALUE;
        for (Trie tr : tries) {
            int depth = tr.getMaxDepth();
            if (depth > max) {
                max = depth;
            }
        }
        return max;
    }

    public Comparator<Box> boxMinPQComparator = new Comparator<Box>() {
        @Override
        public int compare(Box o1, Box o2) {
            return o1.less(o2) ? 1 : -1;
        }
    };

    public static class Box {
        int w;
        int h;
        int d;
        String name; // for test purposes

        public Box(String name, int w, int h, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
            this.name = name;
        }

        public boolean less(Solution2.Box other) {

            int[] thisBox = new int[]{this.d, this.h, this.w};
            int[] otherBox = new int[]{other.d, other.h, other.w};
            for (int i = 0; i < thisBox.length; ++i) {
                if (thisBox[i] >= otherBox[i]) return false;
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
            if (!root.less(box)) return false;
            return tryAddHelper(box, root);
        }

        private boolean tryAddHelper(Box addedBox, Box parentBox) {
            if (parentBox.less(addedBox)) {
                for (Box childBox : boxes.get(parentBox)) {
                    tryAddHelper(addedBox, childBox);
                }
                boxes.get(parentBox).add(addedBox);
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
                int localDepth = getMaxDepthHelper(counter + 1, boxes.get(b));
                max = Math.max(max, localDepth);
            }
            return max;
        }

        private Box getRootItem() {
            if (boxes.isEmpty()) return null;
            return boxes.entrySet().iterator().next().getKey();
        }

    }

    public static class PriorityQueue<T> {

        private Comparator<T> comparator;
        private List<T> items;

        public PriorityQueue(Comparator<T> comparator) {
            this.comparator = comparator;
            this.items = new ArrayList<>();
        }


        public void add(T item) {
            if (items.size() == 0) {
                items.add(null);
            }
            items.add(item);
            buildTreeUp(items.size() - 1);
        }

        public T poll() {
            if (items.size() > 1) {
                T peek = items.get(1);
                items.set(1, items.get(items.size() - 1));
                items.set(items.size() - 1, peek);
                items.remove(items.size() - 1);
                buildTreeDown(1);
                return peek;
            }
            return null;
        }

        public T peek() {
            if (items.size() > 1)
                return items.get(1);
            return null;
        }


        public boolean hasItems() {
            return items.size() > 1;
        }

        private void buildTreeUp(int index) {
            while (index > 1) {
                buildHeapSubtree(index);
                index /= 2;
            }
            buildHeapSubtree(1);
        }

        private void buildTreeDown(int index) {
            while (index < items.size() && getSubtreeMaxElementIndex(index) != index) {
                int subtreeMaxElementIndex = getSubtreeMaxElementIndex(index);
                buildHeapSubtree(index);
                index = subtreeMaxElementIndex;
            }
        }

        private void buildHeapSubtree(int index) {
            int subtreeMaxElementIndex = getSubtreeMaxElementIndex(index);
            if (subtreeMaxElementIndex != index) {
                T tmp = items.get(subtreeMaxElementIndex);
                items.set(subtreeMaxElementIndex, items.get(index));
                items.set(index, tmp);
            }
        }

        private int getSubtreeMaxElementIndex(int rootIndex) {
            T left = rootIndex * 2 < items.size() ? items.get(rootIndex * 2) : null;
            T right = rootIndex * 2 + 1 < items.size() ? items.get(rootIndex * 2 + 1) : null;
            T root = items.get(rootIndex);
            int maxElementIndex = rootIndex;
            if (left != null && right != null) {
                maxElementIndex = comparator.compare(left, right) > 0 ? rootIndex * 2 : rootIndex * 2 + 1;
            } else if (left != null) {
                maxElementIndex = rootIndex * 2;
            } else if (right != null) {
                maxElementIndex = rootIndex * 2 + 1;
            }
            return comparator.compare(items.get(rootIndex), items.get(maxElementIndex)) > 0 ? rootIndex : maxElementIndex;
        }
    }
}

package unionfind;

/**
 * Created by Paul Miller on 23.12.2017.
 * <p>
 * Quick-Union implementation with weights optimisation and path compression optimisation
 */
public class QuickUnion implements IUnionFind {


    private int[] data;
    private int[] treeSizes;

    public QuickUnion(int size) {
        data = new int[size];
        treeSizes = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
            treeSizes[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (treeSizes[pRoot] > treeSizes[qRoot]) {
            data[qRoot] = data[pRoot];
            treeSizes[pRoot] += treeSizes[qRoot];
        } else {
            data[pRoot] = data[qRoot];
            treeSizes[qRoot] += treeSizes[pRoot];
        }
    }

    public boolean isConnected(int p, int q) {

        return getRoot(p) == getRoot(q);
    }

    private int getRoot(int index) {
        while (data[index] != index) {
            data[index] = data[data[index]]; // <- Pass compression optimisation to keep the trees as flat as possible
            index = data[index];
        }
        return index;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("(%d)  %d\r\n", i, data[i]));
        }
        sb.append("Tree sizes: \r\n");
        for (int i = 0; i < treeSizes.length; i++) {
            sb.append(String.format("root: %d size: %d\r\n", i, treeSizes[i]));
        }
        return sb.toString();
    }
}

package unionfind;

/**
 * Created by Paul Miller on 23.12.2017.
 *
 *
 *
 * Plain Quick-Find implementation
 */
public class QuickFind implements IUnionFind{


    private int[] data;

    public QuickFind(int size) {
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
    }

    public void union(int p, int q) {
        int oldUnion = data[q];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == oldUnion) {
                data[i] = data[p];
            }
        }
    }

    public boolean isConnected(int p, int q) {

        return data[p] == data[q];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            sb.append("(" + i + ")  " + data[i] + "\r\n");
        }
        return sb.toString();
    }
}

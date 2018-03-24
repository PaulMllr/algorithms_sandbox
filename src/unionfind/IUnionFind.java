package unionfind;

/**
 * Created by Paul Miller on 24.03.2018.
 */
public interface IUnionFind {

    /**
     * Union two elements of the set
     *
     * @param p first element index
     * @param q second element index
     */
    void union(int p, int q);

    /**
     * Show if two elements of the set are connected
     * @param p first element index
     * @param q second element index
     * @return true if the elements are connected
     */
    boolean isConnected(int p, int q);
}

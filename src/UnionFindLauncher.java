import unionfind.*;

public class UnionFindLauncher {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Commands:");
        System.out.println("'exit' - quit the program");
        System.out.println("'print' - print implementation data structure");
        System.out.println("'X Y' - connect the Xth element with the Yth element");
        System.out.println("'X Y?' - ask whether the Xth element is connected to the Yth element");
        System.out.println();

        System.out.println("Please choose implementation: 1 for Quick-Find, 2 for Weighted Quick-Union");
        Integer implId = Integer.valueOf(System.console().readLine());

        System.out.println("Please input data size:");
        Integer size = Integer.valueOf(System.console().readLine());

        IUnionFind unionFind = getImplementation(implId, size);

        System.out.println("Please enter commands");
        while (true) {
            Thread.sleep(200);

            String input = System.console().readLine();
            if (input.equals("print")) {
                System.out.println(unionFind);
            } else if (input.equals("exit")) {
                break;
            } else if (input.endsWith("?")) {
                String[] nums = input.replace("?", "").split(" ");
                if (nums.length == 2) {
                    int p = Integer.valueOf(nums[0]);
                    int q = Integer.valueOf(nums[1]);
                    if (unionFind.isConnected(p, q)) {
                        System.out.println("+");
                    } else {
                        System.out.println("-");
                    }
                }
            } else {
                String[] nums = input.split(" ");
                if (nums.length == 2) {
                    int p = Integer.valueOf(nums[0]);
                    int q = Integer.valueOf(nums[1]);
                    if (!unionFind.isConnected(p, q)) {
                        unionFind.union(p, q);
                        System.out.println(p + "-" + q);
                    }

                }


            }
        }

    }

    private static IUnionFind getImplementation(final int implId, final Integer size) {
        switch (implId) {
            case 1:
                return new QuickFind(size);
            case 2:
                return new QuickUnion(size);
            default:
                throw new IllegalArgumentException("Invalid algorithm implementation number");
        }
    }
}

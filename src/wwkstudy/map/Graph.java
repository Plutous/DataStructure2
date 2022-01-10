package wwkstudy.map;

import java.util.ArrayList;

/**
 * @author 王文凯
 * 图的创建（无向图）+ 深度优先
 * @create 2022/1/9,16:28
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertex = {"A", "B", "C", "D", "E"};
        for (String s : vertex) {
            graph.insertVertex(s);
        }
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 4);
        graph.insertEdge(2, 3);
        graph.insertEdge(4, 5);

        graph.showGraph();

        graph.dfs();

    }

    private ArrayList<String> vertexList;//存放各个结点名称的集合
    private int[][] edges;//存放邻接矩阵中的值（0 / 1）
    private int numOfEdges;//边的数目
    //用来记录节点是否被访问
    private boolean[] isVisited;

    /**
     * 初始化数组
     *
     * @param n
     */
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
        numOfEdges = 0;
    }

    /**
     * 获取该节点的一个邻接节点
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取v1的下下一个连通节点？
     *
     * @param v1 邻接矩阵中的，对应着节点‘A’
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先算法
     * 遍历这个结点的邻接结点
     */
    public void dfs(boolean[] isVisited, int i) {
        //输出
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;//设置成已访问

        int w = getFirstNeighbor(i);//获取i节点的邻接节点
        while (w != -1) {//存在邻接节点
            if (!isVisited[w]){//没有被访问过
                dfs(isVisited, w);
            }
            //如果w已经被访问,获取v1下一个邻接
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs(){
        //对所有结点都深度优先一遍
        for (int i = 0; i < vertexList.size() -1; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 结点之间设置边
     *
     * @param v1
     * @param v2
     */
    public void insertEdge(int v1, int v2) {
        //因为数组索引从0开始
        edges[v1 - 1][v2 - 1] = 1;
        edges[v2 - 1][v1 - 1] = 1;
        numOfEdges++;
    }

    /**
     * 添加结点到ArrayList
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 通过索引获取结点值
     *
     * @param index
     * @return
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 显示邻接矩阵
     */
    public void showGraph() {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1; j++) {
                System.out.print(edges[i][j]);
            }
            System.out.println();//换行
        }
    }

}

/*
 * *
 *  * Licensed to the Apache Software Foundation (ASF) under one or more
 *  * contributor license agreements.  See the NOTICE file distributed with
 *  * this work for additional information regarding copyright ownership.
 *  * The ASF licenses this file to You under the Apache License, Version 2.0
 *  * (the "License"); you may not use this file except in compliance with
 *  * the License.  You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.james.codelib.algorithms.graph.undirected;

import com.google.common.collect.Queues;

import java.util.Queue;

/**
 * 连通分量
 * 在无向图中，如果从顶点vi到顶点vj有路径，则称vi和vj连通。
 * 如果图中任意两个顶点之间都连通，则称该图为连通图，否则，称该图为非连通图，则其中的极大连通子图称为连通分量，
 * 这里所谓的极大是指子图中包含的顶点个数极大。
 * <p>
 * 看提交的图中包含了几个孤立的图形
 * <p>
 *
 *  这个可以用来检查DAG图中是否有多个图形，比如两个平行线，两个DAG子图
 *
 * Created by James.Hez on 2015/9/25.
 */
public class CC {
    /**
     * 顶点是否已经被标记
     */
    private boolean[] marked;

    /**
     * 每个顶点所属的连通分量编号
     */
    private int[] id;

    /**
     * 顶点的连通分量
     */
    private int[] size;

    /**
     * 连通分量
     */
    private int count;

    /**
     * 图形
     */
    private Graph graph = null;


    /**
     * 连通分量，默认使用深度优先查找
     *
     * @param g
     */
    public CC(Graph g) {
        graph = g;
        marked = new boolean[graph.verticesNumber()];
        id = new int[graph.verticesNumber()];
        size = new int[graph.verticesNumber()];
        for (int v = 0; v < graph.verticesNumber(); v++) {
            if (!marked[v]) {
                dfs(v);
                count++;
            }
        }
    }

    /**
     * dfs搜索
     *
     * @param v
     */
    private void dfs(int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(w);
            }
        }
    }


    /**
     * v所在连通分量的标识符
     *
     * @param v
     * @return
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * 连通分量
     *
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 顶点v和w是否连通
     *
     * @param v
     * @param w
     * @return
     */
    public boolean connected(int v, int w) {
        return id(v) == id(w);
    }


}

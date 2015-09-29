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

/**
 * 二分图
 * 就是顶点集V可分割为两个互不相交的子集，并且图中每条边依附的两个顶点都分属于这两个互不相交的子集
 * Created by James.Hez on 2015/9/29.
 */
public class TwoColor {
    /**
     * 顶点是否已经被标记
     */
    private boolean[] marked;

    /**
     * 图形
     */
    private Graph graph = null;

    private boolean[] color;
    private boolean isTwoColor = true;


    /**
     * 二分图判断
     *
     * @param g
     */
    public TwoColor(Graph g) {
        graph = g;
        marked = new boolean[graph.verticesNumber()];
        color = new boolean[g.verticesNumber()];
        for (int v = 0; v < graph.verticesNumber(); v++) {
            if (!marked[v]) {
                dfs(v);
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
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(w);
            } else if (color[w] == color[v]) {
                isTwoColor = false;
            } else {
                continue;
            }
        }
    }

    public boolean isBipartite() {
        return this.isTwoColor;
    }
}

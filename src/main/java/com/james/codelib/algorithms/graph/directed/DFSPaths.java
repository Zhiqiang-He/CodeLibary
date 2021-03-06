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

package com.james.codelib.algorithms.graph.directed;

import com.google.common.collect.Lists;
import com.james.codelib.algorithms.graph.Paths;

import java.util.List;
import java.util.Stack;

/**
 * 深度优先算法只能解决图的连通问题，要寻找最短路径，还是必须广度优先
 * Created by James.Hez on 2015/9/24.
 */
public class DFSPaths extends Paths {
    private DirectedGraph graph = null;

    /**
     * 顶点是否已经被标记
     */
    private boolean[] marked;

    /**
     * 从起点到终点的路径
     */
    private int[] edgeTo;

    /**
     * 起点
     */
    private int start;

    /**
     * 从图中找到所有起点为s的路径
     *
     * @param g 图
     * @param s 起点
     */
    public DFSPaths(DirectedGraph g, int s) {
        graph = g;
        marked = new boolean[g.verticesNumber()];
        edgeTo = new int[g.verticesNumber()];
        start = s;
        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public List<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != start; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(start);


        List<Integer> results = Lists.newArrayList();
        while (!path.isEmpty()) {
            results.add(path.pop());
        }

        return results;
    }
}

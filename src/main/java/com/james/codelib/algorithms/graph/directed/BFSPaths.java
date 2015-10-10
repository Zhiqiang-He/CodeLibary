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
import com.google.common.collect.Queues;
import com.james.codelib.algorithms.graph.Paths;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 广度优先
 * 不带权值
 * Created by James.Hez on 2015/9/25.
 */
public class BFSPaths extends Paths {

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


    public BFSPaths(DirectedGraph g, int s) {
        graph = g;
        marked = new boolean[g.verticesNumber()];
        edgeTo = new int[g.verticesNumber()];
        start = s;
        bfs(s);
    }

    private void bfs(int s) {
        //标记起点
        marked[s] = true;
        Queue<Integer> queue = Queues.newArrayDeque();
        //将起点加入队列
        queue.add(s);
        while (!queue.isEmpty()) {
            //从队列中删去下一顶点
            int v = queue.remove();
            for (int w : graph.adj(v)) {
                //每个未标记的相邻顶点
                if (!marked[w]) {
                    //保存最短路径的最后一条边
                    edgeTo[w] = v;
                    //标记该节点，因为最短路径已知
                    marked[w] = true;
                    //加入队列
                    queue.add(w);
                }
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

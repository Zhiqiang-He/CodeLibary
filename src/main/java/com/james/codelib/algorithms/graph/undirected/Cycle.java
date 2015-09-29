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
 * 检测途中是否有环
 * Created by James.Hez on 2015/9/29.
 */
public class Cycle {
    /**
     * 顶点是否已经被标记
     */
    private boolean[] marked;
    /**
     * 是否有环
     */
    private boolean cycle = false;
    /**
     * 图形
     */
    private Graph graph = null;

    /**
     * 是否有环判断
     * @param g
     */
    public Cycle(Graph g) {
        graph = g;
        marked = new boolean[graph.verticesNumber()];
        for (int v = 0; v < graph.verticesNumber(); v++) {
            if (!marked[v]) {
                dfs(v, v);
            }
        }
    }

    /**
     * dfs搜索
     *
     * @param v
     */
    private void dfs(int v, int s) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(w, v);
            } else if (w != s) {
                this.cycle = true;
            } else {
                continue;
            }
        }
    }


    public boolean isCycle() {
        return this.cycle;
    }

}

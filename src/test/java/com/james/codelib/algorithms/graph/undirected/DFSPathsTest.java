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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by James.Hez on 2015/9/24.
 */
public class DFSPathsTest {

    @Test
    public void Test1() {
        Graph g = new Graph(6);
        g.adEdge(0, 1);
        g.adEdge(0, 2);
        g.adEdge(0, 5);
        g.adEdge(1, 2);
        g.adEdge(2, 4);
        g.adEdge(3, 2);
        g.adEdge(3, 4);
        g.adEdge(3, 5);

        //开始节点
        int s = 0;

        Paths dfs = new DFSPaths(g, s);

        for (int v = 0; v < g.verticesNumber(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (dfs.hasPathTo(v)) {
                for (int x : dfs.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }

                }
            }
            System.out.println();
        }
    }
}
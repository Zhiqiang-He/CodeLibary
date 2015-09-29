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

/**
 * Created by James.Hez on 2015/9/24.
 */
public class ConnectedGraphTest {

    @Test
    public void Test1() {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 6);
        g.addEdge(0, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 6);

        //开始节点
        int s = 0;
        Search dfs = new ConnectedGraph(g, s);
        for (int v = 0; v < g.verticesNumber(); v++) {
            if (dfs.marked(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
        if (dfs.count() != g.verticesNumber()) {
            System.out.print("Not ");
        }
        System.out.println("Connected");
    }


    @Test
    public void Test2() {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        //开始节点
        int s = 0;
        Search dfs = new ConnectedGraph(g, s);
        for (int v = 0; v < g.verticesNumber(); v++) {
            if (dfs.marked(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
        if (dfs.count() != g.verticesNumber()) {
            System.out.print("Not ");
        }
        System.out.println("Connected");
    }

}
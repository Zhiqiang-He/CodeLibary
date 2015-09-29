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

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by James.Hez on 2015/9/25.
 */
public class CCTest {

    @Test
    public void Test1() {
        Graph graph = new Graph(13);
        graph.addEdge(0,5);
        graph.addEdge(4,3);
        graph.addEdge(0,1);
        graph.addEdge(9,12);
        graph.addEdge(6,4);
        graph.addEdge(5,4);
        graph.addEdge(0,2);
        graph.addEdge(11,12);
        graph.addEdge(9,10);
        graph.addEdge(0,6);
        graph.addEdge(7,8);
        graph.addEdge(9,11);
        graph.addEdge(5,3);

        CC cc = new CC(graph);

        // number of connected components
        int M = cc.count();
        System.out.println(M + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new ArrayDeque<Integer>();
        }
        for (int v = 0; v < graph.verticesNumber(); v++) {
            components[cc.id(v)].add(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void Test2() {
        Graph graph = new Graph(7);
        graph.addEdge(0,5);
        graph.addEdge(4,3);
        graph.addEdge(0,1);
        graph.addEdge(6,4);
        graph.addEdge(5,4);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(5,3);

        CC cc = new CC(graph);

        // number of connected components
        int M = cc.count();
        System.out.println(M + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new ArrayDeque<Integer>();
        }
        for (int v = 0; v < graph.verticesNumber(); v++) {
            components[cc.id(v)].add(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
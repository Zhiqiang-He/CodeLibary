/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.james.codelib.algorithms.graph.undirected;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by James.Hez on 2015/9/23.
 */
public class GraphTest {

    @Test
    public void testCommonGraph() {
        Graph graph = new Graph(4);
        graph.adEdge(0,1);
        graph.adEdge(0,2);
        graph.adEdge(0,3);
        System.out.println(graph.toString());
        assertEquals(graph.adj(1).size(), 1);
        assertEquals(graph.adj(2).size(), 2);
        assertEquals(graph.maxDegree(), 3);
        assertEquals(graph.edgeNumber(), 3);
        assertEquals(graph.numberOfSelfLoops(), 0);
    }

    @Test
    public void testLoopGraph() {
        Graph graph = new Graph(13);
        graph.adEdge(0,5);
        graph.adEdge(4,3);
        graph.adEdge(0,1);
        graph.adEdge(9,12);
        graph.adEdge(6,4);
        graph.adEdge(5,4);
        graph.adEdge(0,2);
        graph.adEdge(11,12);
        graph.adEdge(9,10);
        graph.adEdge(0,6);
        graph.adEdge(7,8);
        graph.adEdge(9,11);
        graph.adEdge(5,3);
        graph.adEdge(0,0);
        System.out.println(graph.toString());
        assertEquals(graph.adj(1).size(), 1);
        //自环，节点会重复添加
        assertEquals(graph.adj(0).size(), 6);
        assertEquals(graph.maxDegree(), 6);
        assertEquals(graph.edgeNumber(), 14);
        assertEquals(graph.numberOfSelfLoops(), 1);
    }

}
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
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * 有符号图
 * Created by James.Hez on 2015/10/10.
 */
public class SymbolGraph {

    private Map<String, Integer> namesMapping;

    private DirectedGraph graph;

    private List<String> vertices;

    /**
     * 创建一个含有v个顶点，但是不含有边的图
     *
     * @param vs
     */
    public SymbolGraph(List<String> vs) {
        vertices = vs;
        namesMapping = Maps.newHashMap();
        for (int i = 0; i < vs.size(); i++) {
            namesMapping.put(vs.get(i), i);
        }
        graph = new DirectedGraph(vs.size());
    }


    public String toString() {
        String s = namesMapping.size() + " vertices, " + graph.edgeNumber() + " edges\n";
        for (Map.Entry<String, Integer> et : namesMapping.entrySet()) {
            s += et.getKey() + ": ";
            for (int w : graph.adj(et.getValue())) {
                s += getKey(w) + " ";
            }
            s += "\n";
        }
        return s;
    }

    public String getKey(int value) {
        for (Map.Entry<String, Integer> et : namesMapping.entrySet()) {
            if (et.getValue().equals(value)) {
                return et.getKey();
            }
        }
        return null;
    }

    public List<String> getVertices() {
        return vertices;
    }

    public int getValue(String key) {
        return namesMapping.get(key);
    }

    public int verticesNumber() {
        return graph.verticesNumber();
    }



    public List<String> adj(String v) {
        List<Integer> res = graph.adj(getValue(v));
        List<String> results = Lists.newArrayList();
        for (Integer i : res) {
            results.add(getKey(i));
        }
        return results;
    }

    public DirectedGraph getGraph() {
        return graph;
    }

    public void addEdge(String s, String s1) {
        graph.addEdge(getValue(s),getValue(s1));
    }
}

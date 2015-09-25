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

import java.util.List;

/**
 * Created by James.Hez on 2015/9/24.
 */
public abstract class Paths {

    /**
     * 是否存在从S到V的路径
     *
     * @param v
     * @return
     */
    public abstract boolean hasPathTo(int v);

    /**
     * 从S到V的路径，如果不存在则返回null
     *
     * @param v
     * @return
     */
    public abstract List<Integer> pathTo(int v);
}
